import java.time.LocalDateTime;
//SUPERCLASSE DAS ATIVIDADES QUE JUNTA AS AULAS DE GRUPO E PERSONAL TRAINING

public class Atividade {
    //Variáveis
    private String nome;
    private Instrutor instrutorAtividade;
    private LocalDateTime dataHora; //LocalDateTime dá para meter a data e a hora mais precisamente
    private int duracao;
    private double custoBase;
    //Meti as variáveis private porque o super nas subclasses inicializa-as

    //Construtor
    public Atividade(String nome, Instrutor instrutorAtividade, int duracao, LocalDateTime dataHora, double custoBase){
        this.nome = nome;
        this.instrutorAtividade = instrutorAtividade;
        this.duracao = duracao;
        this.dataHora = dataHora;
        this.custoBase = custoBase;
    }

    //Metodo
    public double getCustoBase(){ return this.custoBase; }

}
