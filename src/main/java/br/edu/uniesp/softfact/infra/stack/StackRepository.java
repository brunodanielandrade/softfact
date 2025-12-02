package br.edu.uniesp.softfact.infra.stack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StackRepository extends JpaRepository<StackEntity, Long> {
    
    Optional<StackEntity> findByNome(String nome);
    
    List<StackEntity> findByCategoria(String categoria);
    
    @Query("SELECT s FROM StackEntity s WHERE LOWER(s.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<StackEntity> findByNomeContaining(@Param("nome") String nome);
}