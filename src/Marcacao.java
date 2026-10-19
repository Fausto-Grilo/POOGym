import java.time.LocalDateTime;

public class Marcacao {
    //Variáveis
    private Socio socio;
    private Atividade atividade;
    private LocalDateTime dataHora;
    private double custoFinal;
    private double valorPoupado;

    //Construtor
    public Marcacao(Socio socio, Atividade atividade, LocalDateTime dataHora){
        this.socio = socio;
        this.atividade = atividade;
        this.dataHora = dataHora;
        calcCustoFinal();
    }

    //Metodos
    private void calcCustoFinal(){
        double custoBase = this.atividade.getCustoBase();
        double desconto = this.socio.getDesconto();

        this.valorPoupado = desconto * custoBase;
        this.custoFinal = custoBase - valorPoupado;
    }

    public double getCustoFinal(){ return this.custoFinal;}

    public String toString() {
        return "Marcação -> Sócio: " + this.socio.getNome() +
                " | Atividade: " + this.atividade.getNome() +
                " | Data/Hora: " + this.dataHora +
                " | Custo Final: " + this.custoFinal + "€" +
                " (Valor Poupado: " + this.valorPoupado + "€)";
    }
}
