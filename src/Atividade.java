import java.time.LocalDateTime;
//SUPERCLASSE DAS ATIVIDADES QUE JUNTA AS AULAS DE GRUPO E PERSONAL TRAINING

public class Atividade {
    //Variáveis
    protected String nome;
    protected Instrutor instrutorAtividade;
    protected LocalDateTime dataHora; //LocalDateTime dá para meter a data e a hora mais precisamente
    protected int duracao;
    protected double custoBase;

    //Construtor
    public Atividade(String nome, Instrutor instrutorAtividade, int duracao, LocalDateTime dataHora, double custoBase){
        this.nome = nome;
        this.instrutorAtividade = instrutorAtividade;
        this.duracao = duracao;
        this.dataHora = dataHora;
        this.custoBase = custoBase;
    }

    //Metodo
    public double getCustoBase(){ return this.custoBase;}
    public String getNome(){return this.nome;}
}
