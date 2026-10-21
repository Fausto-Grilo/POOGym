/**
 * Representa um sócio, com os respetivos dados pessoais e desconto.
 *
 * @author Fausto Henriques
 * @author Rodrigo Correia
 */
public class Socio {

    // Variáveis

    /** Nome do sócio. */
    private String nome;

    /** Identificador do sócio. */
    private int id;

    /** Endereço de correio eletrónico do sócio. */
    private String email;

    /** Desconto atribuído ao sócio. */
    private double desconto;

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

    /**
     * Devolve o identificador único do sócio.
     *
     * @return identificador do sócio
     */
    public int getId() {
        return id;
    }

    /**
     * Devolve o endereço de correio eletrónico do sócio.
     *
     * @return endereço de correio eletrónico
     */
    public String getEmail() {
        return email;
    }
}