import java.time.LocalDateTime;

public class PersonalTraining extends Atividade{
    //Variáveis
    private NiveisTreinoEnum nivelTreino;

    //Construtor
    public PersonalTraining(String nome, Instrutor instrutorAtividade, int duracao, LocalDateTime dataHora, double custoBase, NiveisTreinoEnum nivelTreino){
        super (nome, instrutorAtividade, duracao, dataHora, definirPreco(nivelTreino));
        this.nivelTreino = nivelTreino;
    }

    //Metodo
    private static double definirPreco(NiveisTreinoEnum nivelTreino){
        double custoBase = switch (nivelTreino){
            case Iniciacao -> 18.0;
            case Intermedio -> 22.0;
            case Avancado -> 28.0;
        };
        return custoBase;
    }
}
