/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passagensrodoviarias.passagem;

/**
 *
 * @author gabrielpaiva
 */
import java.util.Date;
import passagensrodoviarias.cidade.Cidade;
import passagensrodoviarias.veiculo.Veiculo;

public class Passagem {
    private int idPassagem;
    private Veiculo veiculo;
    private int poltrona;
    private Date dataSaida;
    private String horaSaida;
    private Cidade cidadeOrigem;
    private Cidade cidadeDestino;
    private double valorPassagem;

    // Construtor
    public Passagem(int idPassagem, Veiculo veiculo, int poltrona, Date dataSaida, String horaSaida, Cidade cidadeOrigem, Cidade cidadeDestino, double valorPassagem) {
        this.idPassagem = idPassagem;
        this.veiculo = veiculo;
        this.poltrona = poltrona;
        this.dataSaida = dataSaida;
        this.horaSaida = horaSaida;
        this.cidadeOrigem = cidadeOrigem;
        this.cidadeDestino = cidadeDestino;
        this.valorPassagem = valorPassagem;
    }

    public int getIdPassagem() {
        return idPassagem;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public int getPoltrona() {
        return poltrona;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public Cidade getCidadeOrigem() {
        return cidadeOrigem;
    }

    public Cidade getCidadeDestino() {
        return cidadeDestino;
    }

    public double getValorPassagem() {
        return valorPassagem;
    }

    public void setIdPassagem(int idPassagem) {
        this.idPassagem = idPassagem;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setPoltrona(int poltrona) {
        this.poltrona = poltrona;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public void setCidadeOrigem(Cidade cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public void setCidadeDestino(Cidade cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    public void setValorPassagem(double valorPassagem) {
        this.valorPassagem = valorPassagem;
    }

    public boolean podeVenderPassagem() {
        if (this.poltrona > this.veiculo.getQtdPoltronas()) {
            System.out.println("Número de poltrona inválido. Excede o limite do veículo.");
            return false;
        }
        
        for (Passagem passagemExistente : this.veiculo.getPassagens()) {
            if (passagemExistente.getDataSaida().equals(this.dataSaida) && passagemExistente.getPoltrona() == this.poltrona) {
                System.out.println("Esta poltrona já está ocupada para esta data de saída.");
                return false;
            }
        }
        
        return true;
    }
    
    @Override
    public String toString() {
        return "Passagem: ID " + idPassagem + ", Veículo: " + veiculo.getModelo() + ", Poltrona: " + poltrona + ", Data de Saída: " + dataSaida;
    }
}
