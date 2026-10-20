/**
 * Representa uma data e hora, com ano, mês, dia, hora e minutos.
 *
 * @author Fausto Henriques
 * @author Rodrigo Correia
 */
public class Tempo {

    /** Ano da data. */
    private int ano;

    /** Mês da data. */
    private int mes;

    /** Dia da data. */
    private int dia;

    /** Hora do dia. */
    private int hora;

    /** Minutos da hora. */
    private int minutos;

    /**
     * Cria uma data e hora com os valores indicados.
     *
     * @param ano ano da data
     * @param mes mês da data
     * @param dia dia da data
     * @param hora hora do dia
     * @param minutos minutos da hora
     */
    public Tempo(int ano, int mes, int dia, int hora, int minutos) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minutos = minutos;
    }

    /**
     * Devolve a data e hora no formato de texto.
     *
     * @return data e hora no formato ano-mês-dia hora:minutos
     */
    public String getDate() {
        return ano + "-" + mes + "-" + dia + " " + hora + ":" + minutos;
    }

    /**
     * Devolve apenas a data.
     *
     * @return data no formato ano-mês-dia
     */
    public String getSimpleDate() {
        return ano + "-" + mes + "-" + dia;
    }

    /**
     * Devolve a hora e os minutos no formato de texto.
     *
     * @return hora no formato hora:minutos
     */
    public String getHourAndMinutes() {
        return hora + ":" + minutos;
    }

    /**
     * Converte a hora e os minutos num total de minutos.
     *
     * @return total de minutos correspondentes à hora e aos minutos
     */
    public int getMinutes() {
        return hora * 60 + minutos;
    }
}