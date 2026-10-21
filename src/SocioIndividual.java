import java.time.Year;

/**
 * Representa um sócio individual, com os respetivos dados pessoais
 * e ano de nascimento.
 * Herda os atributos da classe {@link Socio}.
 */
public class SocioIndividual extends Socio {

    // Variáveis

    /** Ano de nascimento do sócio. */
    private int anoNascimento;

    // Construtor

    /**
     * Cria um sócio individual com os dados indicados.
     *
     * @param nome nome do sócio
     * @param id identificador do sócio
     * @param email endereço de correio eletrónico do sócio
     * @param anoNascimento ano de nascimento do sócio
     */
    public SocioIndividual(String nome, int id, String email, int anoNascimento){
        super(nome, id, email, calcularDesconto(anoNascimento));
        this.anoNascimento = anoNascimento;
    }

    // Metodo

    /**
     * Calcula o desconto do sócio com base na sua idade.
     *
     * @param anoNascimento ano de nascimento do sócio
     * @return desconto aplicável ao sócio
     */
    private static double calcularDesconto(int anoNascimento) {
        int idade = Year.now().getValue() - anoNascimento;
        if(idade < 18){
            return 0.1;
        }else if(idade >= 65){
            return 0.15;
        }
        return 0;
    }

    /**
     * Apresenta os dados do sócio individual na consola.
     */
    public void showData(){
        System.out.println("Nome: " + getNome());
        System.out.println("Ano de Nascimento: " + anoNascimento);
        System.out.println("ID: " + getId());
        System.out.println("Email: " + getEmail());
        System.out.println("Desconto: " + getDesconto() * 100 + "%\n");
    }


}