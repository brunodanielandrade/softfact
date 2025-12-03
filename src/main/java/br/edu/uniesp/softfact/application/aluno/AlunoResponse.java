package br.edu.uniesp.softfact.application.aluno;

import br.edu.uniesp.softfact.shared.enums.Curso;
import br.edu.uniesp.softfact.shared.enums.Periodo;
import java.time.LocalDateTime;

public record AlunoResponse(
        Long id,
        String nome,
        String email,
        String telefone,
        Curso curso,
        String matricula,
        Periodo periodo,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
