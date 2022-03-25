package br.com.addTeste.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int id;

    @Column(name = "logradouro")
    public String logradouro;

    @Column(name="complemento")
    public String complemento;

    @Column(name="bairro")
    public String bairro;

    @Column(name="cidade")
    public String cidade;

    @Column(name="estado")
    public String estado;

}
