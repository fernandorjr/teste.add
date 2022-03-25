package br.com.addTeste.service;

import br.com.addTeste.entity.Aluno;
import br.com.addTeste.entity.Escola;
import br.com.addTeste.repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscolaService {

    @Autowired
    private EscolaRepository escolaRepository;

    public void salvar(Escola escola){
        this.escolaRepository.save(escola);
    }

    public List<Escola> findAll(){
        return this.escolaRepository.findAll();
    }

    public Escola findById(int id){return this.escolaRepository.findById(id).get();}

    public void apagar(int id) { this.escolaRepository.deleteById(id);};
}
