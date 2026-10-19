/**
 * Representa um instrutor, com os seus dados pessoais e formação.
 */
public class Instrutor {

    // Variáveis

    /** Nome do instrutor. */
    private String nome;

    /** Género do instrutor. */
    private String genero;

    /** Formação do instrutor. */
    private String formacao;

    // Construtor

    /**
     * Cria um instrutor com os dados indicados.
     *
     * @param nome nome do instrutor
     * @param genero género do instrutor
     * @param formacao formação do instrutor
     */
    public Instrutor(String nome, String genero, String formacao) {
        this.nome = nome;
        this.genero = genero;
        this.formacao = formacao;
    }

    /**
     * Devolve o nome do instrutor.
     *
     * @return nome do instrutor
     */
    public String get_nome() {
        return nome;
    }

}