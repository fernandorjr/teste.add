package br.com.addTeste.repository;

import br.com.addTeste.entity.Turma;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TurmaRepository extends CrudRepository<Turma, Integer> {

    @Override
    List<Turma> findAll();
}
