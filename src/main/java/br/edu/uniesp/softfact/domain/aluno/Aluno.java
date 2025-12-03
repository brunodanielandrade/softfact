package br.edu.uniesp.softfact.domain.aluno;

import br.edu.uniesp.softfact.shared.enums.Curso;
import br.edu.uniesp.softfact.shared.enums.Periodo;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private Curso curso;
    private String matricula;
    private Periodo periodo;
}