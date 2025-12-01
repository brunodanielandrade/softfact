package br.edu.uniesp.softfact.infra.tarefa;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaEntity, Long> {
}
