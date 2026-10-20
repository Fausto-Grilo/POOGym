import java.time.LocalDateTime;

public class Marcacao {
    //Variáveis
    private Socio socio;
    private Atividade atividade;
    private Tempo dataHora;
    private double custoFinal;
    private double valorPoupado;

    //Construtor
    public Marcacao(Socio socio, Atividade atividade){
        this.socio = socio;
        this.atividade = atividade;
        this.dataHora = atividade.date;
        calcCustoFinal();
    }

    //Metodos
    private void calcCustoFinal(){
        double custoBase = this.atividade.getCustoBase();
        double desconto = this.socio.getDesconto();

        this.valorPoupado = desconto * custoBase;
        this.custoFinal = custoBase - valorPoupado;
    }

    public double getCustoFinal(){ return custoFinal;}

    public String showData() {
        return "Sócio: " + socio.getNome() + "\nAtividade: " + atividade.getNome() + "\nData e Hora: "
                + atividade.getDate().getDate() + "\nCusto Final: " + custoFinal + "\nValor Poupado: " + valorPoupado
                + "\n\n";
    }

    public Atividade getAtividade(){
        return atividade;
    }
}