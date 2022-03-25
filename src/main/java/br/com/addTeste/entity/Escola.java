package br.com.addTeste.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int id;

    @Column(name="nome")
    public String nome;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    public Endereco endereco;

}
