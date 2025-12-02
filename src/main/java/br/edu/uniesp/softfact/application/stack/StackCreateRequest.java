package br.edu.uniesp.softfact.application.stack;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StackCreateRequest(
        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 80, message = "Nome deve ter no máximo 80 caracteres")
        String nome,
        
        @Size(max = 40, message = "Categoria deve ter no máximo 40 caracteres")
        String categoria,
        
        @Size(max = 500, message = "Descrição deve ter no máximo 500 caracteres")
        String descricao
) {}