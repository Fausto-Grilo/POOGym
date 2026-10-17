import java.time.LocalDateTime;

public class PersonalTraining extends Atividades{
    //Variáveis
    private NiveisTreinoEnum nivelTreino;

    //Construtor
    public PersonalTraining(String nome, Instrutor instrutorAtividade, int duracao, LocalDateTime dataHora, NiveisTreinoEnum nivelTreino){
        super (nome, instrutorAtividade, duracao, dataHora);
        this.nivelTreino = nivelTreino;
    }
}
