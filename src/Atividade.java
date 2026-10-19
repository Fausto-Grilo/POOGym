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
    protected double preco;

    // Construtor

    /**
     * Cria uma atividade com os dados indicados.
     *
     * @param nome nome da atividade
     * @param instrutor instrutor responsável pela atividade
     * @param date data e hora da atividade
     * @param duracao duração da atividade em minutos
     * @param preco preço da atividade (€)
     */
    public Atividade(String nome, Instrutor instrutor, Tempo date, int duracao, double preco) {
        this.nome = nome;
        this.instrutor = instrutor;
        this.date = date;
        this.duracao = duracao;
        this.preco = preco;
    }

}