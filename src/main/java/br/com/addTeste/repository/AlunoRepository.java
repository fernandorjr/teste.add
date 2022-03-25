package br.com.addTeste.repository;

import br.com.addTeste.entity.Aluno;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlunoRepository extends CrudRepository<Aluno, Integer>{

    @Override
    List<Aluno>findAll();
}
