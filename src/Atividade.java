/**
 * Representa uma atividade, com o respetivo instrutor, data,
 * duração e preço.
 *
 * @author Fausto Henriques
 * @author Rodrigo Correia
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

    /** Preço base da atividade. */
    protected double custoBase;

    /**
     * Cria uma atividade com os dados indicados.
     *
     * @param nome nome da atividade
     * @param instrutor instrutor responsável
     * @param date data e hora da atividade
     * @param duracao duração em minutos
     * @param custoBase preço base da atividade em euros
     */
    public Atividade(String nome, Instrutor instrutor, Tempo date,
                     int duracao, double custoBase) {
        this.nome = nome;
        this.instrutor = instrutor;
        this.date = date;
        this.duracao = duracao;
        this.custoBase = custoBase;
    }

    /**
     * Devolve o preço base da atividade.
     *
     * @return preço base da atividade
     */
    public double getCustoBase() {
        return custoBase;
    }

    /**
     * Devolve o nome da atividade.
     *
     * @return nome da atividade
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve a data e hora da atividade.
     *
     * @return data e hora da atividade
     */
    public Tempo getDate() {
        return date;
    }

    /**
     * Devolve a duração da atividade em minutos.
     *
     * @return duração da atividade
     */
    public int getDuracao() {
        return duracao;
    }

    public Instrutor getInstrutor(){ return instrutor; }

}