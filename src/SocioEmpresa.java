/**
 * Representa um sócio de uma empresa.
 * Herda os dados pessoais e o desconto da classe {@link Socio}.
 */
public class SocioEmpresa extends Socio {

    // Variáveis

    /** Número de identificação fiscal da empresa. */
    private String nif;

    // Construtor

    /**
     * Cria um sócio de empresa com os dados indicados.
     *
     * @param nome nome da empresa
     * @param id identificador do sócio
     * @param email endereço de correio eletrónico
     * @param nif número de identificação fiscal da empresa
     */
    public SocioEmpresa(String nome, int id, String email, String nif) {
        super(nome, id, email, 0.2);
        this.nif = nif;
    }

    /**
     * Apresenta os dados do sócio de empresa na consola.
     */
    public void showData() {
        System.out.println("Nome da Empresa: " + nome);
        System.out.println("NIF: " + nif);
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Desconto: " + desconto + "\n");
    }


}