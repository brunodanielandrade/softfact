package br.edu.uniesp.softfact.application.tarefa;

import br.edu.uniesp.softfact.shared.enums.PrioridadeTarefa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record TarefaCreateRequest(
        @NotBlank(message = "Título é obrigatório")
        @Size(max = 200, message = "Título deve ter no máximo 200 caracteres")
        String titulo,
        
        @Size(max = 1000, message = "Descrição deve ter no máximo 1000 caracteres")
        String descricao,
        
        @NotNull(message = "Data de entrega é obrigatória")
        LocalDate dataEntrega,
        
        @NotNull(message = "ID do projeto é obrigatório")
        Long projetoId,
        
        @NotNull(message = "ID do responsável é obrigatório")
        Long responsavelId,
        
        PrioridadeTarefa prioridade,
        
        @Size(max = 500, message = "Observações devem ter no máximo 500 caracteres")
        String observacoes
) {}

