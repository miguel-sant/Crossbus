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
import java.util.Date;
import java.util.List;
public class GerenciadorVeiculos {
   
    private List<Veiculo> veiculos;

    public GerenciadorVeiculos() {
        this.veiculos = new ArrayList<>();
    }

    public void cadastrarVeiculo(String numero, String placa, String motorista, String modelo, Date dataCompra, int qtdPoltronas) {
        Veiculo novoVeiculo = new Veiculo(numero, placa, motorista, modelo, dataCompra, qtdPoltronas);
        veiculos.add(novoVeiculo);
        System.out.println("Veículo cadastrado com sucesso: " + novoVeiculo);
    }

    public List<Veiculo> consultarVeiculos() {
        return veiculos;
    }

    public void excluirVeiculo(Veiculo veiculo) {
        if (veiculos.remove(veiculo)) {
            System.out.println("Veículo removido com sucesso: " + veiculo);
        } else {
            System.out.println("Veículo não encontrado: " + veiculo);
        }
    }

    public void imprimirVeiculos() {
        System.out.println("Veículos cadastrados:");
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo);
        }
    }

    public static void main(String[] args) {
        GerenciadorVeiculos gerenciador = new GerenciadorVeiculos();

        gerenciador.cadastrarVeiculo("001", "ABC-1234", "João", "Modelo A", new Date(), 40);
        gerenciador.cadastrarVeiculo("002", "DEF-5678", "Maria", "Modelo B", new Date(), 30);

        List<Veiculo> todosVeiculos = gerenciador.consultarVeiculos();
        gerenciador.imprimirVeiculos();
       
        Veiculo veiculoRemover = todosVeiculos.get(0); 
        gerenciador.excluirVeiculo(veiculoRemover);
        gerenciador.imprimirVeiculos();
    }
}
