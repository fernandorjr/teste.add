package br.com.addTeste.service;

import br.com.addTeste.entity.Turma;
import br.com.addTeste.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    public TurmaRepository turmaRepository;

    public void salvar(Turma turma){
        this.turmaRepository.save(turma);
    };

    public void apagar(int id) { this.turmaRepository.deleteById(id);};

    public List<Turma> findAll(){
        return this.turmaRepository.findAll();
    }

    public Turma findById(int id){
        return this.turmaRepository.findById(id).get();
    }
}