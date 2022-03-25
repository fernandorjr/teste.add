package br.com.addTeste.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int id;

    @Column(name="nome")
    public String nome;

    @Column(name="capacidade")
    public int capacidade;



    public Turma(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }
}
