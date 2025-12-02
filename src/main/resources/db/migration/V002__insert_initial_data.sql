-- Inserção de dados iniciais

-- Stacks de tecnologia
INSERT INTO tb_stack (nome, categoria, descricao) VALUES
('Java', 'Backend', 'Linguagem de programação orientada a objetos'),
('Spring Boot', 'Framework', 'Framework para desenvolvimento de aplicações Java'),
('React', 'Frontend', 'Biblioteca JavaScript para construção de interfaces'),
('Angular', 'Frontend', 'Framework TypeScript para aplicações web'),
('Node.js', 'Backend', 'Runtime JavaScript para servidor'),
('Python', 'Backend', 'Linguagem de programação versátil'),
('PostgreSQL', 'Database', 'Sistema de gerenciamento de banco de dados relacional'),
('MongoDB', 'Database', 'Banco de dados NoSQL orientado a documentos'),
('Docker', 'DevOps', 'Plataforma de containerização'),
('Kubernetes', 'DevOps', 'Orquestrador de containers');

-- Alunos de exemplo
INSERT INTO tb_aluno (nome, email, telefone, curso, matricula, periodo) VALUES
('João Silva', 'joao.silva@email.com', '(11) 99999-1111', 'CIENCIA_DA_COMPUTACAO', '2024001', 'P5'),
('Maria Santos', 'maria.santos@email.com', '(11) 99999-2222', 'ENGENHARIA_DE_SOFTWARE', '2024002', 'P3'),
('Pedro Oliveira', 'pedro.oliveira@email.com', '(11) 99999-3333', 'SISTEMAS_DE_INFORMACAO', '2024003', 'P7'),
('Ana Costa', 'ana.costa@email.com', '(11) 99999-4444', 'ANALISE_E_DESENVOLVIMENTO_DE_SISTEMAS', '2024004', 'P4');

-- Relacionamento Aluno-Stack
INSERT INTO tb_aluno_stack (aluno_id, stack_id) VALUES
(1, 1), (1, 2), (1, 7), -- João: Java, Spring Boot, PostgreSQL
(2, 3), (2, 4), (2, 9), -- Maria: React, Angular, Docker
(3, 5), (3, 8), (3, 10), -- Pedro: Node.js, MongoDB, Kubernetes
(4, 1), (4, 6), (4, 7); -- Ana: Java, Python, PostgreSQL