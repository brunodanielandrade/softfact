package br.edu.uniesp.softfact.infra.aluno;

import br.edu.uniesp.softfact.infra.tarefa.TarefaEntity;
import br.edu.uniesp.softfact.shared.entity.BaseEntity;
import br.edu.uniesp.softfact.shared.enums.Curso;
import br.edu.uniesp.softfact.shared.enums.Periodo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "tb_aluno",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_aluno_email", columnNames = "email"),
                @UniqueConstraint(name = "uk_aluno_matricula", columnNames = "matricula")
        })
@NoArgsConstructor @AllArgsConstructor @Builder
public class AlunoEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nome;

    @Email
    @Column(nullable = false, length = 100)
    private String email;

    @Column(length = 20)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Curso curso;

    @NotBlank
    @Column(nullable = false, length = 20)
    private String matricula;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Periodo periodo;

    @ManyToMany(mappedBy = "alunos")
    private Set<br.edu.uniesp.softfact.infra.projeto.ProjetoEntity> projetos = new HashSet<>();

    @OneToMany(mappedBy = "responsavel")
    private Set<TarefaEntity> tarefasResponsavel = new HashSet<>();

    @OneToMany(mappedBy = "aluno")
    private Set<br.edu.uniesp.softfact.infra.certificado.CertificadoEntity> certificados = new HashSet<>();
}
