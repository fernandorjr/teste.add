package br.com.addTeste.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int id;

    @Column(name="nome")
    public String nome;

    @Column(name="dataDeNascimento")
    public Date dataDeNascimento;

    @ManyToOne
    public Turma turma;


    public Aluno(String nome, Date dataDeNascimento){
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }
}
