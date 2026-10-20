/**
 * Representa uma atividade, com o respetivo instrutor, data,
 * duração e preço.
 */
public class Atividade {

    // Variáveis

    /** Nome da atividade. */
    protected String nome;

    /** Instrutor responsável pela atividade. */
    protected Instrutor instrutor;

    /** Data e hora da atividade. */
    protected Tempo date;

    /** Duração da atividade em minutos. */
    protected int duracao;

    /** Preço da atividade. */
    protected double custoBase;

    // Construtor

    /**
     * Cria uma atividade com os dados indicados.
     *
     * @param nome nome da atividade
     * @param instrutor instrutor responsável pela atividade
     * @param date data e hora da atividade
     * @param duracao duração da atividade em minutos
     * @param custoBase preço da atividade (€)
     */
    public Atividade(String nome, Instrutor instrutor, Tempo date, int duracao, double custoBase) {
        this.nome = nome;
        this.instrutor = instrutor;
        this.date = date;
        this.duracao = duracao;
        this.custoBase = custoBase;
    }

    public double getCustoBase(){ return custoBase;}
    public String getNome(){return nome;}
    public Tempo getDate(){return date;}
    public int getDuracao(){return  duracao;}
}