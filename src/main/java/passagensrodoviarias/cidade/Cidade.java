/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passagensrodoviarias.cidade;

/**
 *
 * @author gabrielpaiva
 */
public class Cidade {
    private String nomeCidade;
    private String idCidade;
    private String uf;

    // Construtor
    public Cidade(String nomeCidade, String idCidade, String uf) {
        this.nomeCidade = nomeCidade;
        this.idCidade = idCidade;
        this.uf = uf;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public String getIdCidade() {
        return idCidade;
    }

    public String getUf() {
        return uf;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public void setIdCidade(String idCidade) {
        this.idCidade = idCidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    @Override
    public String toString() {
        return "Cidade: " + nomeCidade + ", ID: " + idCidade + ", UF: " + uf;
    }
}
