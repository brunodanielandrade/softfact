package br.edu.uniesp.softfact.application.tarefa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TarefaCreateRequest {

        @NotBlank(message = "Título é obrigatório")
        @Size(max = 100, message = "Título deve ter no máximo 100 caracteres")
        private String titulo;

        @Size(max = 1000, message = "Descrição deve ter no máximo 1000 caracteres")
        private String descricao;

        private String status;

        @NotNull(message = "AlunoId é obrigatório")
        private Long alunoId;

        @NotNull(message = "StackId é obrigatório")
        private Long stackId;

        public TarefaCreateRequest() {}

        public TarefaCreateRequest(String titulo, String descricao, String status, Long alunoId, Long stackId) {
            this.titulo = titulo;
            this.descricao = descricao;
            this.status = status;
            this.alunoId = alunoId;
            this.stackId = stackId;
        }

        public String getTitulo() { return titulo; }
        public void setTitulo(String titulo) { this.titulo = titulo; }

        public String getDescricao() { return descricao; }
        public void setDescricao(String descricao) { this.descricao = descricao; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public Long getAlunoId() { return alunoId; }
        public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }

        public Long getStackId() { return stackId; }
        public void setStackId(Long stackId) { this.stackId = stackId; }
    }

