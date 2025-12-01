package br.edu.uniesp.softfact.application.tarefa;
import java.time.LocalDate;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TarefaResponse {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate dataEntrega;
    private boolean concluida;
}
