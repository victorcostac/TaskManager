/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

/**
 *
 * @author Usuario
 */

public class Endereco {
    private String Id;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    } 
    

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    

    public Endereco() {
    }

    public Endereco(String Id, String logradouro, String bairro, String cidade, String uf, String cep) {
        this.Id = Id;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public Endereco(String logradouro, String bairro, String cidade, String uf, String cep) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
    
    
    

    @Override
    public String toString() {
        return String.format("Rua: %s, Bairro: %s, Cidade: %s - %s, cep: %s", logradouro, bairro, cidade, uf, cep);
    }
}
