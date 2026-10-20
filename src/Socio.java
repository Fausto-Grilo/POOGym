/**
 * Representa um sócio, com os respetivos dados pessoais e desconto.
 *
 * @author Fausto Henriques
 * @author Rodrigo Correia
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

    /**
     * Devolve o nome do sócio.
     *
     * @return nome do sócio
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve o desconto atribuído ao sócio.
     *
     * @return desconto do sócio
     */
    public double getDesconto() {
        return desconto;
    }
}