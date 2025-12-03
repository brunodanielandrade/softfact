package br.edu.uniesp.softfact.application.tarefa;

import br.edu.uniesp.softfact.shared.enums.PrioridadeTarefa;
import br.edu.uniesp.softfact.shared.enums.StatusTarefa;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TarefaResponse(
        Long id,
        String titulo,
        String descricao,
        LocalDate dataEntrega,
        StatusTarefa status,
        PrioridadeTarefa prioridade,
        Long projetoId,
        String responsavelNome,
        String observacoes,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
