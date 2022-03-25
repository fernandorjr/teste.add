package br.com.addTeste.service;

import br.com.addTeste.entity.Aluno;
import br.com.addTeste.entity.Turma;
import br.com.addTeste.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public void salvar(Aluno aluno){
        this.alunoRepository.save(aluno);
    }

    public List<Aluno> findAll(){
        return this.alunoRepository.findAll();
    }

    public Aluno findById(int id){return this.alunoRepository.findById(id).get();}

    public void apagar(int id) { this.alunoRepository.deleteById(id);};
}
