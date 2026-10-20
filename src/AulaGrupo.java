import java.util.Date;

/**
 * Representa uma aula de grupo, com uma modalidade e capacidade máxima.
 * Herda os atributos da classe {@link Atividade}.
 */
public class AulaGrupo extends Atividade {

    // Variáveis

    /** Modalidade da aula de grupo. */
    private ModalidadeEnum modalidadeEnum;

    /** Capacidade máxima de participantes na aula. */
    private int maxCap;

    // Construtor

    /**
     * Cria uma aula de grupo com os dados indicados.
     *
     * @param nome nome da aula
     * @param instrutor instrutor responsável pela aula
     * @param date data e hora da aula
     * @param duracao duração da aula em minutos
     * @param preco preço da aula (€)
     * @param modalidadeEnum modalidade da aula
     * @param maxCap capacidade máxima de participantes
     */
    public AulaGrupo(String nome, Instrutor instrutor, Tempo date, int duracao, double preco, ModalidadeEnum modalidadeEnum, int maxCap) {
        super(nome, instrutor, date, duracao, preco);

        this.modalidadeEnum = modalidadeEnum;
        this.maxCap = maxCap;
    }

    /**
     * Apresenta os dados da aula de grupo.
     */
    public void showData() {
        System.out.println("Nome: " + nome);
        System.out.println("Instrutor: " + instrutor.getNome());
        System.out.println("Data: " + date.getDate());
        System.out.println("Duração: " + duracao);
        System.out.println("Modalidade: " + modalidadeEnum.name());
        System.out.println("\nPreço: " + custoBase + "\n");
    }

    /**
     * Devolve a capacidade máxima da Aula de Grupo
     *
     * @return capacidade máxima
     */
    public int getMaxCap(){return maxCap;}

}