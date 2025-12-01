package br.edu.uniesp.softfact.infra.tarefa;
import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tarefas")
public class TarefaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String titulo;
    private String descricao;
    private LocalDate dataEntrega;
    private boolean concluida;

    public TarefaEntity() {}

    public TarefaEntity(Long id, String titulo, String descricao, LocalDate dataEntrega, boolean concluida) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.concluida = concluida;
    }

    // GETTERS
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public LocalDate getDataEntrega() { return dataEntrega; }
    public boolean isConcluida() { return concluida; }


    public void setConcluida(boolean concluida) {
    }

    public void setDescricao(String descricao) {
    }
}
