package org.example.DTO;

public class ClientDTO {
    private String nome;

    private String phone;

    private String cpf;

    public ClientDTO() {
    }

    public ClientDTO(String nome, String phone, String cpf) {
        this.nome = nome;
        this.phone = phone;
        this.cpf = cpf;
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
}
