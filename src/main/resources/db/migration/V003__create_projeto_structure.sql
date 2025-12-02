-- Reestruturação para incluir Projetos

-- Criar tabela de projetos
CREATE TABLE tb_projeto (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    descricao TEXT,
    data_inicio DATE NOT NULL,
    data_fim DATE,
    status VARCHAR(20) NOT NULL DEFAULT 'PLANEJAMENTO',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Criar tabela de relacionamento Projeto-Aluno (Many-to-Many)
CREATE TABLE tb_projeto_aluno (
    projeto_id BIGINT NOT NULL,
    aluno_id BIGINT NOT NULL,
    PRIMARY KEY (projeto_id, aluno_id),
    FOREIGN KEY (projeto_id) REFERENCES tb_projeto(id) ON DELETE CASCADE,
    FOREIGN KEY (aluno_id) REFERENCES tb_aluno(id) ON DELETE CASCADE
);

-- Criar tabela de relacionamento Projeto-Stack (Many-to-Many)
CREATE TABLE tb_projeto_stack (
    projeto_id BIGINT NOT NULL,
    stack_id BIGINT NOT NULL,
    PRIMARY KEY (projeto_id, stack_id),
    FOREIGN KEY (projeto_id) REFERENCES tb_projeto(id) ON DELETE CASCADE,
    FOREIGN KEY (stack_id) REFERENCES tb_stack(id) ON DELETE CASCADE
);

-- Alterar tabela de tarefas para referenciar projeto
ALTER TABLE tb_tarefa DROP CONSTRAINT IF EXISTS tb_tarefa_aluno_id_fkey;
ALTER TABLE tb_tarefa DROP COLUMN IF EXISTS aluno_id;
ALTER TABLE tb_tarefa ADD COLUMN projeto_id BIGINT NOT NULL DEFAULT 1;
ALTER TABLE tb_tarefa ADD COLUMN responsavel_id BIGINT;
ALTER TABLE tb_tarefa ADD CONSTRAINT fk_tarefa_projeto FOREIGN KEY (projeto_id) REFERENCES tb_projeto(id) ON DELETE CASCADE;
ALTER TABLE tb_tarefa ADD CONSTRAINT fk_tarefa_responsavel FOREIGN KEY (responsavel_id) REFERENCES tb_aluno(id);

-- Remover tabela antiga de relacionamento aluno-stack
DROP TABLE IF EXISTS tb_aluno_stack;

-- Criar índices
CREATE INDEX idx_projeto_status ON tb_projeto(status);
CREATE INDEX idx_projeto_data_inicio ON tb_projeto(data_inicio);
CREATE INDEX idx_tarefa_projeto_id ON tb_tarefa(projeto_id);
CREATE INDEX idx_tarefa_responsavel_id ON tb_tarefa(responsavel_id);