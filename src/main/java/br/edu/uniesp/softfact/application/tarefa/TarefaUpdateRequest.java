package br.edu.uniesp.softfact.application.tarefa;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TarefaUpdateRequest {
    @NotNull(message = "Id da tarefa é obrigatório")
    private Long id;

    @Size(max = 100, message = "Título deve ter no máximo 100 caracteres")
    private String titulo;

    @Size(max = 1000, message = "Descrição deve ter no máximo 1000 caracteres")
    private String descricao;

    private String status;

    private Long alunoId;

    private Long stackId;

    public TarefaUpdateRequest() {}

    public TarefaUpdateRequest(Long id, String titulo, String descricao, String status, Long alunoId, Long stackId) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.alunoId = alunoId;
        this.stackId = stackId;
    }

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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
