/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passagensrodoviarias.cidade;

/**
 *
 * @author gabrielpaiva
 */
import java.util.ArrayList;
import java.util.List;
public class GerenciadorCidades {
    private List<Cidade> cidades;

    // Construtor
    public GerenciadorCidades() {
        this.cidades = new ArrayList<>();
    }

    public void cadastrarCidade(String nomeCidade, String idCidade, String uf) {
        Cidade novaCidade = new Cidade(nomeCidade, idCidade, uf);
        cidades.add(novaCidade);
        System.out.println("Cidade cadastrada com sucesso: " + novaCidade);
    }

    public List<Cidade> consultarCidades() {
        return cidades;
    }

    public void excluirCidade(Cidade cidade) {
        if (cidades.remove(cidade)) {
            System.out.println("Cidade removida com sucesso: " + cidade);
        } else {
            System.out.println("Cidade não encontrada: " + cidade);
        }
    }

    // Método para imprimir todas as cidades cadastradas (apenas para fins de teste)
    public void imprimirCidades() {
        System.out.println("Cidades cadastradas:");
        for (Cidade cidade : cidades) {
            System.out.println(cidade);
        }
    }

    // Método principal apenas para fins de teste
    public static void main(String[] args) {
        GerenciadorCidades gerenciador = new GerenciadorCidades();

        gerenciador.cadastrarCidade("São Paulo", "SP", "SP");
        gerenciador.cadastrarCidade("Rio de Janeiro", "RJ", "RJ");
        gerenciador.cadastrarCidade("Belo Horizonte", "MG", "MG");

        List<Cidade> todasCidades = gerenciador.consultarCidades();
        gerenciador.imprimirCidades();

        Cidade cidadeRemover = todasCidades.get(0);
        gerenciador.excluirCidade(cidadeRemover);
        gerenciador.imprimirCidades();
    }
}
