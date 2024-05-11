/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passagensrodoviarias.passagem;

/**
 *
 * @author gabrielpaiva
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import passagensrodoviarias.cidade.Cidade;
import passagensrodoviarias.veiculo.Veiculo;
public class GerenciadorPassagens {
    private List<Passagem> passagens;

    // Construtor
    public GerenciadorPassagens() {
        this.passagens = new ArrayList<>();
    }

    public void cadastrarPassagem(int idPassagem, Veiculo veiculo, int poltrona, Date dataSaida, String horaSaida, Cidade cidadeOrigem, Cidade cidadeDestino, double valorPassagem) {
        Passagem novaPassagem = new Passagem(idPassagem, veiculo, poltrona, dataSaida, horaSaida, cidadeOrigem, cidadeDestino, valorPassagem);
        passagens.add(novaPassagem);
        System.out.println("Passagem cadastrada com sucesso: " + novaPassagem);
    }

    public List<Passagem> consultarPassagens() {
        return passagens;
    }

    public void excluirPassagem(Passagem passagem) {
        if (passagens.remove(passagem)) {
            System.out.println("Passagem removida com sucesso: " + passagem);
        } else {
            System.out.println("Passagem não encontrada: " + passagem);
        }
    }

    // Método para imprimir todas as passagens cadastradas (apenas para fins de teste)
    public void imprimirPassagens() {
        System.out.println("Passagens cadastradas:");
        for (Passagem passagem : passagens) {
            System.out.println(passagem);
        }
    }
    
    public double calcularFaturamentoPorPeriodo(Date inicioPeriodo, Date fimPeriodo) {
        double faturamentoTotal = 0;

        for (Passagem passagem : passagens) {
            Date dataSaida = passagem.getDataSaida();

            // Verifica se a data de saída está dentro do período especificado
            if (dataSaida.after(inicioPeriodo) && dataSaida.before(fimPeriodo)) {
                faturamentoTotal += passagem.getValorPassagem();
            }
        }

        return faturamentoTotal;
    }
    
    // Método para consultar as passagens vendidas para um determinado roteiro
    public List<Passagem> consultarPassagensPorRoteiro(Cidade cidadeOrigem, Cidade cidadeDestino) {
        List<Passagem> passagensRoteiro = new ArrayList<>();

        for (Passagem passagem : passagens) {
            Cidade origemPassagem = passagem.getCidadeOrigem();
            Cidade destinoPassagem = passagem.getCidadeDestino();

            // Verifica se a passagem tem origem na cidade de origem e destino na cidade de destino especificadas
            if (origemPassagem.equals(cidadeOrigem) && destinoPassagem.equals(cidadeDestino)) {
                passagensRoteiro.add(passagem);
            }
        }

        return passagensRoteiro;
    }

    // Método principal apenas para fins de teste
    public static void main(String[] args) {
        GerenciadorPassagens gerenciador = new GerenciadorPassagens();

        // Cadastro de algumas passagens para teste
        gerenciador.cadastrarPassagem(1, new Veiculo("001", "ABC-1234", "João", "Modelo A", new Date(), 40), 1, new Date(), "08:00", new Cidade("São Paulo", "SP", "SP"), new Cidade("Rio de Janeiro", "RJ", "RJ"), 100.0);
        gerenciador.cadastrarPassagem(2, new Veiculo("002", "DEF-5678", "Maria", "Modelo B", new Date(), 30), 2, new Date(), "09:00", new Cidade("Belo Horizonte", "MG", "MG"), new Cidade("São Paulo", "SP", "SP"), 150.0);

        // Definição do período para consulta de faturamento (apenas para fins de teste)
        Date inicioPeriodo = new Date(); // Usando a data atual como exemplo
        Date fimPeriodo = new Date(inicioPeriodo.getTime() + (7 * 24 * 60 * 60 * 1000)); // Adicionando uma semana ao período de consulta

        // Cálculo do faturamento no período especificado
        double faturamento = gerenciador.calcularFaturamentoPorPeriodo(inicioPeriodo, fimPeriodo);
        System.out.println("Faturamento total no período: R$" + faturamento);
        
        // Definição das cidades de origem e destino do roteiro para consulta de passagens
        Cidade cidadeOrigem = new Cidade("São Paulo", "SP", "SP");
        Cidade cidadeDestino = new Cidade("Rio de Janeiro", "RJ", "RJ");

        // Consulta das passagens vendidas para o roteiro especificado
        List<Passagem> passagensRoteiro = gerenciador.consultarPassagensPorRoteiro(cidadeOrigem, cidadeDestino);
        System.out.println("Passagens vendidas para o roteiro " + cidadeOrigem.getNomeCidade() + " -> " + cidadeDestino.getNomeCidade() + ":");
        for (Passagem passagem : passagensRoteiro) {
            System.out.println(passagem);
        }
    }
}
