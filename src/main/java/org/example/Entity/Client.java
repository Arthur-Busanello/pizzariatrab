package org.example.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;

    private String phone;

    private  String cpf;

    @ManyToMany
    private List<Adress> adress;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Adress> getEndereco() {
        return adress;
    }

    public void setEndereco(List<Adress> adress) {
        this.adress = adress;
    }

    public void addEndereco(Adress adress) {
        this.adress.add(adress);
    }
}
