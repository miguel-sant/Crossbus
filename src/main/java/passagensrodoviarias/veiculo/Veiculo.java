/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passagensrodoviarias.veiculo;

/**
 *
 * @author gabrielpaiva
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import passagensrodoviarias.passagem.Passagem;
public class Veiculo {
    private String numero;
    private String placa;
    private String motorista;
    private String modelo;
    private Date dataCompra;
    private int qtdPoltronas;
    private List<Passagem> passagens;
    
    public Veiculo(String numero, String placa, String motorista, String modelo, Date dataCompra, int qtdPoltronas) {
        this.numero = numero;
        this.placa = placa;
        this.motorista = motorista;
        this.modelo = modelo;
        this.dataCompra = dataCompra;
        this.qtdPoltronas = qtdPoltronas;
        
        passagens = new ArrayList<>();
    }
    
    public void adicionarPassagem(Passagem passagem) {
        passagens.add(passagem);
    }

    public void removerPassagem(Passagem passagem) {
        passagens.remove(passagem);
    }
    
    public List<Passagem> getPassagens() {
        return passagens;
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public Date getdataCompra() {
        return dataCompra;
    }

    public void setdataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
    
    public int getQtdPoltronas() {
        return qtdPoltronas;
    }

    public void setQtdPoltronas(int qtdPoltronas) {
        this.qtdPoltronas = qtdPoltronas;
    }
    
    public boolean estaDisponivel(Date data) {
        for (Passagem passagem : passagens) {
            if (passagem.getDataSaida().equals(data)) {
                return false;
            }
        }
        return true;
    }
    
    // toString() para imprimir informações do veículo
    @Override
    public String toString() {
        return "Veículo: " + modelo + ", Placa: " + placa + ", Motorista: " + motorista;
    }
}
