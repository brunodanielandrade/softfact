package br.edu.uniesp.softfact.infra.projeto;

import br.edu.uniesp.softfact.infra.aluno.AlunoEntity;
import br.edu.uniesp.softfact.infra.stack.StackEntity;
import br.edu.uniesp.softfact.infra.tarefa.TarefaEntity;
import br.edu.uniesp.softfact.shared.entity.BaseEntity;
import br.edu.uniesp.softfact.shared.enums.StatusProjeto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "tb_projeto")
@NoArgsConstructor @AllArgsConstructor @Builder
public class ProjetoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 150)
    private String nome;

    @Column(length = 1000)
    private String descricao;

    @NotNull
    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private StatusProjeto status = StatusProjeto.PLANEJAMENTO;

    @ManyToMany
    @JoinTable(name = "tb_projeto_aluno",
            joinColumns = @JoinColumn(name = "projeto_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    @Builder.Default
    private Set<AlunoEntity> alunos = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "tb_projeto_stack",
            joinColumns = @JoinColumn(name = "projeto_id"),
            inverseJoinColumns = @JoinColumn(name = "stack_id"))
    @Builder.Default
    private Set<StackEntity> stacks = new HashSet<>();

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<TarefaEntity> tarefas = new HashSet<>();
}