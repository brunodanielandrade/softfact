-- Criação das tabelas principais do sistema

-- Tabela de Stacks
CREATE TABLE tb_stack (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(80) NOT NULL UNIQUE,
    categoria VARCHAR(40),
    descricao VARCHAR(500),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de Alunos
CREATE TABLE tb_aluno (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(20),
    curso VARCHAR(50) NOT NULL,
    matricula VARCHAR(20) NOT NULL UNIQUE,
    periodo VARCHAR(10) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de Tarefas
CREATE TABLE tb_tarefa (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    descricao TEXT,
    data_entrega DATE NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDENTE',
    prioridade VARCHAR(20) NOT NULL DEFAULT 'MEDIA',
    aluno_id BIGINT NOT NULL,
    observacoes VARCHAR(500),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (aluno_id) REFERENCES tb_aluno(id) ON DELETE CASCADE
);

-- Tabela de relacionamento Aluno-Stack (Many-to-Many)
CREATE TABLE tb_aluno_stack (
    aluno_id BIGINT NOT NULL,
    stack_id BIGINT NOT NULL,
    PRIMARY KEY (aluno_id, stack_id),
    FOREIGN KEY (aluno_id) REFERENCES tb_aluno(id) ON DELETE CASCADE,
    FOREIGN KEY (stack_id) REFERENCES tb_stack(id) ON DELETE CASCADE
);

-- Índices para performance
CREATE INDEX idx_tarefa_aluno_id ON tb_tarefa(aluno_id);
CREATE INDEX idx_tarefa_status ON tb_tarefa(status);
CREATE INDEX idx_tarefa_data_entrega ON tb_tarefa(data_entrega);
CREATE INDEX idx_aluno_curso ON tb_aluno(curso);
CREATE INDEX idx_stack_categoria ON tb_stack(categoria);