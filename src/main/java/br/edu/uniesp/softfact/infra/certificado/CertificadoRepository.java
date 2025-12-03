package br.edu.uniesp.softfact.infra.certificado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificadoRepository extends JpaRepository<CertificadoEntity, Long> {
}