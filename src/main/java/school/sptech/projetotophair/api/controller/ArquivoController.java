package school.sptech.projetotophair.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.projetotophair.domain.arquivo.Arquivo;
import school.sptech.projetotophair.domain.arquivo.repository.ArquivoRepository;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/arquivos")
public class ArquivoController {

    @Autowired
    private ArquivoRepository arquivoRepository;

    private Path diretorioBase = Path.of(System.getProperty("java.io.tmpdir") + "/arquivos");

    @PostMapping("/upload")
    public ResponseEntity<Arquivo> upload(@RequestParam("arquivo") MultipartFile file) {

        if (file.isEmpty()){
            return ResponseEntity.status(400).build();
        }

        if (!this.diretorioBase.toFile().exists()) {
            this.diretorioBase.toFile().mkdir();
        }

        String nomeArquivoFormatado = formatarNomeArquivo(file.getOriginalFilename());

        String filePath = this.diretorioBase + "/" + nomeArquivoFormatado;
        File dest = new File(filePath);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(422, "Não foi possível salvar o arquivo", null);
        }

        Arquivo arquivo = new Arquivo();
        arquivo.setDataUpload(LocalDate.now());
        arquivo.setNomeArquivoOriginal(file.getOriginalFilename());
        arquivo.setNomeArquivoSalvo(nomeArquivoFormatado);
        Arquivo arquivoBanco = arquivoRepository.save(arquivo);

        return ResponseEntity.status(200).body(arquivoBanco);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Integer id){
        Optional<Arquivo> arquivoOptional = arquivoRepository.findById(id);

        if (arquivoOptional.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        Arquivo arquivoBanco = arquivoOptional.get();

        File file = this.diretorioBase.resolve(arquivoBanco.getNomeArquivoSalvo()).toFile();
        try {
            InputStream fileInputStream = new FileInputStream(file);

            return ResponseEntity.status(200)
                    .header("Content-Disposition",
                            "attachment; filename=" + arquivoBanco.getNomeArquivoOriginal())
                    .body(fileInputStream.readAllBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ResponseStatusException(422, "Diretório não encontrado", null);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(422, "Não foi possível converter para byte[]", null);
        }
    }

    private String formatarNomeArquivo(String nomeOriginal) {
        return String.format("%s_%s", UUID.randomUUID(), nomeOriginal);
    }
}