package br.edu.uniesp.softfact.infra.certificado;

import br.edu.uniesp.softfact.infra.aluno.AlunoEntity;
import br.edu.uniesp.softfact.shared.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@Entity
@Table(name = "tb_certificado")
@NoArgsConstructor @AllArgsConstructor @Builder
public class CertificadoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "aluno_id", nullable = false)
    private AlunoEntity aluno;

    @NotBlank
    @Column(nullable = false, length = 200)
    private String descricao;

    @Column(name = "arquivo_url", length = 500)
    private String arquivoUrl;

    @NotNull
    @Column(name = "data_envio", nullable = false)
    private LocalDate dataEnvio;
}