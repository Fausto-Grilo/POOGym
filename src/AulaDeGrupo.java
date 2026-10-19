import java.time.LocalDateTime;

public class AulaDeGrupo extends Atividade {
    //Variaveis
    private ModalidadeEnum modalidade;
    private int capacidadeMax;  //adicionei porque o enunciado pede

    //Construtor
    public AulaDeGrupo(String nome, Instrutor instrutorAtividade, int duracao, double custoBase, LocalDateTime dataHora, ModalidadeEnum modalidade, int capacidadeMax){
        super (nome, instrutorAtividade, duracao, dataHora, definirPreco(modalidade));
        this.modalidade = modalidade;
        this.capacidadeMax = capacidadeMax;
    }

    //Metodo
    private static double definirPreco(ModalidadeEnum modalidade){
        double custoBase = switch(modalidade){
            case Yoga -> 8.0;
            case Zumba -> 8.50;
            case CrossFit -> 12.0;
            case Spinning -> 9.0;
        };
        return custoBase;
    }
}
