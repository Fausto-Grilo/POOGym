import java.time.LocalDateTime;

public class Marcacao {
    //Variáveis
    private Socio pessoa;
    private Atividade atividade;
    private LocalDateTime dataHora;
    private double custoFinal;
    private double valorPoupado;

    //Construtor
    public Marcacao(Socio pessoa, Atividade atividade, LocalDateTime dataHora){
        this.pessoa = pessoa;
        this.atividade = atividade;
        this.dataHora = dataHora;
    }

    //Metodo
    private double custoFinal(Socio pessoa, Atividade atividade){

    }
}
