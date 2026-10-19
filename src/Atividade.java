
public class Atividade {
    //Variaveis
    protected String nome;
    protected Instrutor instrutor;
    protected Tempo date;
    protected int duracao;
    protected double preco;

    //Construtor
    public Atividade(String nome, Instrutor instrutor, Tempo date, int duracao, double preco){
        this.nome = nome;
        this.instrutor = instrutor;
        this.date = date;
        this.duracao = duracao;
        this.preco = preco;
    }

}