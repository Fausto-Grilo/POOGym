/**
 * Representa um sócio, com os respetivos dados pessoais e desconto.
 */
public class Socio {

    // Variáveis

    /** Nome do sócio. */
    protected String nome;

    /** Identificador do sócio. */
    protected int id;

    /** Endereço de correio eletrónico do sócio. */
    protected String email;

    /** Desconto atribuído ao sócio. */
    protected double desconto;

    // Construtor

    /**
     * Cria um sócio com os dados indicados.
     *
     * @param nome nome do sócio
     * @param id identificador do sócio
     * @param email endereço de correio eletrónico do sócio
     * @param desconto desconto atribuído ao sócio
     */
    public Socio(String nome, int id, String email, double desconto) {
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.desconto = desconto;
    }
}