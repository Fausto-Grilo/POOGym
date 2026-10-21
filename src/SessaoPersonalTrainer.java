/**
 * Representa uma sessão de treino personalizada.
 * Herda os atributos da classe {@link Atividade}.
 */
public class SessaoPersonalTrainer extends Atividade {

    // Variáveis

    /** Nível da sessão de treino. */
    private NivelEnum nivelEnum;

    // Construtor

    /**
     * Cria uma sessão de treino com os dados indicados.
     *
     * @param nome nome da sessão
     * @param instrutor instrutor responsável pela sessão
     * @param date data e hora da sessão
     * @param duracao duração da sessão em minutos
     * @param nivelEnum nível da sessão de treino
     */
    public SessaoPersonalTrainer(String nome, Instrutor instrutor, Tempo date, int duracao, NivelEnum nivelEnum) {
        super(nome, instrutor, date, duracao, obterPrecoNivel(nivelEnum));

        this.nivelEnum = nivelEnum;
    }

    /**
     * Apresenta os dados da sessão de treino.
     */
    public void showData() {
        System.out.println("Nome: " + getNome());
        System.out.println("Instrutor: " + getInstrutor().getNome());
        System.out.println("Género do instrutor: " + getInstrutor().getGenero());
        System.out.println("Formação do instrutor: " + getInstrutor().getFormacao());
        System.out.println("Data: " + getDate().getDate());
        System.out.println("Duração: " + getDuracao() + " minutos");
        System.out.println("Nível: " + nivelEnum.name());
        System.out.printf("Preço base: %.2f €%n%n", getCustoBase());
    }


    /**
     * Determina o preço base da sessão de personal training a partir do nível.
     *
     * @param nivel nível escolhido
     * @return preço base em euros
     */
    private static double obterPrecoNivel(NivelEnum nivel) {
        switch (nivel) {
            case Iniciação:
                return 18.00;
            case Intermédio:
                return 22.00;
            case Avançado:
                return 28.00;
            default:
                return -1;
        }
    }


}