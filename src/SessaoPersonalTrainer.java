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
     * @param preco preço da sessão (€)
     * @param nivelEnum nível da sessão de treino
     */
    public SessaoPersonalTrainer(String nome, Instrutor instrutor, Tempo date, int duracao, double preco, NivelEnum nivelEnum) {
        super(nome, instrutor, date, duracao, preco);

        this.nivelEnum = nivelEnum;
    }

    /**
     * Apresenta os dados da sessão de treino.
     */
    public void showData() {
        System.out.println("Nome: " + nome);
        System.out.println("Instrutor: " + instrutor.getNome());
        System.out.println("Data: " + date.getDate());
        System.out.println("Duração: " + duracao);
        System.out.println("Nivel: " + nivelEnum.name());
        System.out.println("\nPreço: " + custoBase + "\n");
    }

}