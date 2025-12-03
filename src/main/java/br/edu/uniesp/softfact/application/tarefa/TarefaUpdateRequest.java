package br.edu.uniesp.softfact.application.tarefa;
import br.edu.uniesp.softfact.shared.enums.PrioridadeTarefa;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TarefaUpdateRequest {
    @NotNull(message = "Id da tarefa é obrigatório")
    private Long id;

    @Size(max = 200, message = "Título deve ter no máximo 200 caracteres")
    private String titulo;

    @Size(max = 1000, message = "Descrição deve ter no máximo 1000 caracteres")
    private String descricao;

    private LocalDate dataEntrega;

    private String status;

    private PrioridadeTarefa prioridade;

    private Long alunoId;

    private Long projetoId;

    @Size(max = 500, message = "Observações devem ter no máximo 500 caracteres")
    private String observacoes;

    public TarefaUpdateRequest() {}

    public TarefaUpdateRequest(Long id, String titulo, String descricao, LocalDate dataEntrega, String status, PrioridadeTarefa prioridade, Long alunoId, Long projetoId, String observacoes) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.status = status;
        this.prioridade = prioridade;
        this.alunoId = alunoId;
        this.projetoId = projetoId;
        this.observacoes = observacoes;
    }

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDate getDataEntrega() { return dataEntrega; }
    public void setDataEntrega(LocalDate dataEntrega) { this.dataEntrega = dataEntrega; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public PrioridadeTarefa getPrioridade() { return prioridade; }
    public void setPrioridade(PrioridadeTarefa prioridade) { this.prioridade = prioridade; }

    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }

    public Long getProjetoId() { return projetoId; }
    public void setProjetoId(Long projetoId) { this.projetoId = projetoId; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
