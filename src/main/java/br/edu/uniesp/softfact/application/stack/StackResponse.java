package br.edu.uniesp.softfact.application.stack;

import java.time.LocalDateTime;

public record StackResponse(
        Long id,
        String nome,
        String categoria,
        String descricao,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}