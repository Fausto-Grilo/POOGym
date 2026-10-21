import java.time.LocalDateTime;

/**
 * Representa uma marcação de um sócio numa atividade.
 * Guarda o preço final e o valor poupado com o desconto.
 *
 * @author Fausto Henriques
 * @author Rodrigo Correia
 */
public class Marcacao {

    // Variáveis

    /** Sócio que fez a marcação. */
    private Socio socio;

    /** Atividade escolhida pelo sócio. */
    private Atividade atividade;

    /** Data e hora da marcação. */
    private Tempo dataHora;

    /** Preço final da atividade após o desconto. */
    private double custoFinal;

    /** Valor poupado pelo sócio. */
    private double valorPoupado;

    /**
     * Cria uma marcação para o sócio e a atividade indicados.
     * Calcula também o preço final e o valor poupado.
     *
     * @param socio sócio que faz a marcação
     * @param atividade atividade escolhida
     */
    public Marcacao(Socio socio, Atividade atividade) {
        this.socio = socio;
        this.atividade = atividade;
        this.dataHora = atividade.date;
        calcCustoFinal();
    }

    /**
     * Calcula o preço final da atividade e o valor poupado,
     * tendo em conta o desconto do sócio.
     */
    private void calcCustoFinal() {
        double custoBase = this.atividade.getCustoBase();
        double desconto = this.socio.getDesconto();

        this.valorPoupado = desconto * custoBase;
        this.custoFinal = custoBase - valorPoupado;
    }

    /**
     * Devolve os dados da marcação num formato de texto.
     *
     * @return informação sobre o sócio, a atividade, a data,
     *         o custo final e o valor poupado
     */
    public String toString() {
        return "Sócio: " + socio.getNome()
                + "\nAtividade: " + atividade.getNome()
                + "\nData e Hora: " + atividade.getDate().getDate()
                + "\nCusto Final: " + custoFinal
                + "\nValor Poupado: " + valorPoupado
                + "\n\n";
    }

    /**
     * Devolve o preço final da marcação.
     *
     * @return preço final da atividade
     */
    public double getCustoFinal() {
        return custoFinal;
    }

    /**
     * Devolve o valor poupado pelo sócio.
     *
     * @return valor do desconto aplicado
     */
    public double getValorPoupado() {
        return valorPoupado;
    }

    /**
     * Devolve a atividade associada à marcação.
     *
     * @return atividade escolhida
     */
    public Atividade getAtividade() {
        return atividade;
    }

    /**
     * Devolve o sócio que fez a marcação.
     *
     * @return sócio associado à marcação
     */
    public Socio getSocio() {
        return socio;
    }

}