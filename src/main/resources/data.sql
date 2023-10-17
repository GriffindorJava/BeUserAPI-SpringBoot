INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('66677788899', 'Frank Adams', 'frank@example.com', 'frank5678', '(55) 5555-7654', false, null, null, null, null),
    ('77788899900', 'Grace Young', 'grace@example.com', 'grace2022', '(55) 5555-6543', true, null, null, null, null),
    ('88899900011', 'Henry Brown', 'henry@example.com', 'henry111', '(55) 5555-5432', false, null, null, null, null),
    ('99900011122', 'Isabel Garcia', 'isabel@example.com', 'isabel777', '(55) 5555-4321', true, null, null, null, null),
    ('00011122233', 'Jack Anderson', 'jack@example.com', 'jack999', '(55) 5555-3210', false, null, null, null, null);

INSERT INTO Endereco (logradouro, numero, estado, complemento, cidade, cep)
VALUES
    ('Rua A', 123, 'São Paulo', 'Apto 101', 'São Paulo', '12345-678'),
    ('Avenida B', 456, 'Rio de Janeiro', 'Casa 2', 'Rio de Janeiro', '23456-789'),
    ('Rua C', 789, 'Minas Gerais', 'Bloco 3', 'Belo Horizonte', '34567-890'),
    ('Avenida D', 1011, 'São Paulo', 'Casa 4', 'São Paulo', '45678-901'),
    ('Rua E', 1213, 'Rio de Janeiro', 'Sala 5', 'Rio de Janeiro', '56789-012'),
    ('Avenida F', 1415, 'Minas Gerais', 'Loja 6', 'Belo Horizonte', '67890-123'),
    ('Rua G', 1617, 'São Paulo', 'Andar 7', 'São Paulo', '78901-234'),
    ('Avenida H', 1819, 'Rio de Janeiro', 'Casa 8', 'Rio de Janeiro', '89012-345'),
    ('Rua I', 2021, 'Minas Gerais', 'Apto 9', 'Belo Horizonte', '90123-456'),
    ('Avenida J', 2223, 'São Paulo', 'Bloco 10', 'São Paulo', '01234-567');

INSERT INTO Empresa (razao_Social, cnpj, fk_Endereco)
VALUES
    ('Empresa A', '12345678000101', 1),
    ('Empresa B', '23456789000102', 2),
    ('Empresa C', '34567890000103', 3),
    ('Empresa D', '45678901000104', 4),
    ('Empresa E', '56789010000105', 5),
    ('Empresa F', '67890100000106', 6),
    ('Empresa G', '78901000000107', 7),
    ('Empresa H', '89010000000108', 8),
    ('Empresa I', '90100000000109', 9),
    ('Empresa J', '01000000000110', 10);

INSERT INTO Agenda (data, hora, status)
VALUES
    ('2023-10-20', '10:00:00', 'Agendado'),
    ('2023-10-21', '11:30:00', 'Agendado'),
    ('2023-10-22', '14:45:00', 'Reagendado'),
    ('2023-10-23', '16:15:00', 'Agendado'),
    ('2023-10-24', '09:00:00', 'Agendado'),
    ('2023-10-25', '13:30:00', 'Reagendado'),
    ('2023-10-26', '15:45:00', 'Agendado'),
    ('2023-10-27', '12:00:00', 'Agendado'),
    ('2023-10-28', '08:30:00', 'Cancelado'),
    ('2023-10-29', '17:00:00', 'Agendado');

INSERT INTO Servico (nome_Servico, descricao, preco, qtd_Tempo_Servico, fk_Agenda, fk_Empresa)
VALUES
    ('Corte de Cabelo Masculino', 'Corte moderno para homens', 40.00, '00:30:00', 1, 1),
    ('Corte de Cabelo Feminino', 'Corte estilizado para mulheres', 50.00, '00:45:00', 2, 2),
    ('Corte de Cabelo Infantil', 'Corte divertido para crianças', 30.00, '00:30:00', 3, 3),
    ('Barba e Bigode', 'Corte e modelagem de barba', 25.00, '00:30:00', 4, 4),
    ('Corte de Cabelo Moderno', 'Tendências da moda', 60.00, '00:45:00', 5, 5),
    ('Corte de Cabelo Clássico', 'Estilo tradicional', 45.00, '00:45:00', 6, 6),
    ('Corte e Penteado', 'Corte e estilização', 55.00, '01:00:00', 7, 7),
    ('Corte de Cabelo Longo', 'Corte para cabelos longos', 70.00, '01:15:00', 8, 8),
    ('Corte de Cabelo Curto', 'Corte para cabelos curtos', 50.00, '01:00:00', 9, 9),
    ('Corte e Coloração', 'Corte e mudança de cor', 80.00, '01:30:00', 10, 10);

INSERT INTO Historico_Servico (ano, mes, semana, faturamento, fk_Agenda)
VALUES
    (2023, 1, 1, 1000.00, 1),
    (2023, 1, 2, 1200.00, 2),
    (2023, 1, 3, 900.00, 3),
    (2023, 2, 4, 1100.00, 4),
    (2023, 2, 5, 1300.00, 5),
    (2023, 2, 6, 950.00, 6),
    (2023, 3, 7, 1050.00, 7),
    (2023, 3, 8, 1250.00, 8),
    (2023, 3, 9, 920.00, 9),
    (2023, 4, 10, 1150.00, 10);
