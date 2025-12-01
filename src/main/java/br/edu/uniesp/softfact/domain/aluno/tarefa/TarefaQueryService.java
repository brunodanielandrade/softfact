package br.edu.uniesp.softfact.domain.aluno.tarefa;

import java.util.List;


public interface TarefaQueryService {
    List<Tarefa> findAll();
    Tarefa findById(Long id);
}