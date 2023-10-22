package school.sptech.projetotophair.domain.servico;

import school.sptech.projetotophair.domain.agenda.Agenda;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.endereco.Endereco;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArquivoCsv {

    public static void gravaArquivoCsv(ListaObj<Servico> lista, String nomeArq) {
        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileWriter(nomeArq);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        // Bloco try-catch para gravar o arquivo
        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Servico p = lista.getElemento(i);

                // Converte LocalDate para LocalDateTime com horário 00:00
                LocalDate dataLocalDate = p.getAgenda().getData();
                LocalDateTime dataLocalDateTime = dataLocalDate.atStartOfDay();

                // Formatar a data
                DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                String dataFormatada = dataLocalDateTime.format(formatoBrasileiro);

                saida.format("%d;%s;%s;%.2f;%s;%s;%s\n", p.getIdServico(),
                        p.getNomeServico(),
                        p.getDescricao(),
                        p.getPreco(),
                        p.getQtdTempoServico(),
                        dataFormatada, // Utilizar a data formatada
                        p.getEmpresa().getRazaoSocial());
            }
        }
        catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim= true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void leArquivoCsv(String nomeArq) {
        FileReader arq = null;
        Scanner entrada = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro) {
            System.out.println("Arquivo nao encontrado");
            System.exit(1);
        }


        try {
            System.out.printf("%-4S %-20S %-50S %-5S %-17S %19S %-50S\n","id","Serviço","Descrição","Preço","Tempo de Serviço",
                    "Agenda", "Empresa");
            while (entrada.hasNext()) {
                Long id = entrada.nextLong();
                String Servico = entrada.next();
                String descricao = entrada.next();
                Double preco = entrada.nextDouble();
                String qtdTempoServico = entrada.next();
                String agenda = entrada.next();
                String empresa = entrada.next();
                System.out.printf("%04d %-20s %-50s %5.1f %-17s %19s %-50s\n", id, Servico, descricao, preco, qtdTempoServico, agenda, empresa);
            }
        }
        catch(NoSuchElementException erro) {
            System.out.println("Arquivo com erro ao gravar");
            deuRuim = true;
        }
        catch(IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }
    public static void main(String[] args) {

        ListaObj<Servico> lista = new ListaObj<>(5);

        lista.adiciona(new Servico(1L, "Hidratação", "Hidrata o cabelo com produtos de qualidade.",
                100.50, "1 hora", new Agenda(1L, LocalDate.now(),"1", "sim"),
                new Empresa(2L, "Carmens Cabelo & Vida.", "12.356.444.0001/45" ,
                        new Endereco(3L,"rua dois", 5, "São Paulo",
                                "A", "São Paulo", "12345-089")
                )));

       gravaArquivoCsv(lista, "Servico");
       leArquivoCsv("Servico");

    }
}
