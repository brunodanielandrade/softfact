package br.edu.uniesp.softfact.infra.tarefa;

import br.edu.uniesp.softfact.infra.aluno.AlunoEntity;
import br.edu.uniesp.softfact.shared.entity.BaseEntity;
import br.edu.uniesp.softfact.shared.enums.PrioridadeTarefa;
import br.edu.uniesp.softfact.shared.enums.StatusTarefa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@Entity
@Table(name = "tb_tarefa")
@NoArgsConstructor @AllArgsConstructor @Builder
public class TarefaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(length = 1000)
    private String descricao;

    @NotNull
    @Column(name = "data_entrega", nullable = false)
    private LocalDate dataEntrega;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private StatusTarefa status = StatusTarefa.PENDENTE;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private PrioridadeTarefa prioridade = PrioridadeTarefa.MEDIA;

    @ManyToOne(optional = false)
    @JoinColumn(name = "projeto_id", nullable = false)
    private br.edu.uniesp.softfact.infra.projeto.ProjetoEntity projeto;

    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private AlunoEntity responsavel;

    @Column(name = "observacoes", length = 500)
    private String observacoes;
}
