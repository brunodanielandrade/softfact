package br.edu.uniesp.softfact.domain.aluno.tarefa;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate dataEntrega;
    private boolean concluida;
}
