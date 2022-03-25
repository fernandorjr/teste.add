package br.com.addTeste.repository;

import br.com.addTeste.entity.Escola;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EscolaRepository extends CrudRepository<Escola, Integer> {

    @Override
    List<Escola> findAll();
}
