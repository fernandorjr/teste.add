package br.com.addTeste.service;

import br.com.addTeste.entity.Endereco;
import br.com.addTeste.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    public EnderecoRepository enderecoRepository;

    public void salvar(Endereco endereco){ this.enderecoRepository.save(endereco);};

    public List<Endereco> findAll(){
        return this.enderecoRepository.findAll();
    }
}
