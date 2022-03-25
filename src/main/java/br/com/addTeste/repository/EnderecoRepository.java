package br.com.addTeste.repository;

import br.com.addTeste.entity.Endereco;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {

    @Override
    List<Endereco> findAll();
}
