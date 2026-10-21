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
     * @param modalidadeEnum modalidade da aula
     * @param maxCap capacidade máxima de participantes
     */
    public AulaGrupo(String nome, Instrutor instrutor, Tempo date, int duracao, ModalidadeEnum modalidadeEnum, int maxCap) {
        super(nome, instrutor, date, duracao, obterPrecoModalidade(modalidadeEnum));

        this.modalidadeEnum = modalidadeEnum;
        this.maxCap = maxCap;
    }

    /**
     * Apresenta os dados da aula de grupo.
     */
    public void showData() {
        System.out.println("Nome: " + getNome());
        System.out.println("Instrutor: " + getInstrutor().getNome());
        System.out.println("Género do instrutor: " + getInstrutor().getGenero());
        System.out.println("Formação do instrutor: " + getInstrutor().getFormacao());
        System.out.println("Data: " + getDate().getDate());
        System.out.println("Duração: " + getDuracao() + " minutos");
        System.out.println("Modalidade: " + modalidadeEnum.name());
        System.out.println("Capacidade máxima: " + maxCap);
        System.out.printf("Preço base: %.2f €%n%n", getCustoBase());
    }

    /**
     * Devolve a capacidade máxima da Aula de Grupo
     *
     * @return capacidade máxima
     */
    public int getMaxCap(){return maxCap;}


    /**
     * Determina o preço base da aula de grupo a partir da modalidade.
     *
     * @param modalidade modalidade escolhida
     * @return preço base em euros
     */
    private static double obterPrecoModalidade(ModalidadeEnum modalidade) {
        switch (modalidade) {
            case Yoga:
                return 8.00;
            case Spinning:
                return 9.00;
            case Zumba:
                return 8.50;
            case CrossFit:
                return 12.00;
            default:
                throw new IllegalArgumentException("Modalidade desconhecida.");
        }
    }

}