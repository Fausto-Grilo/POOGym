import java.time.LocalDateTime;

public class AulaDeGrupo extends Atividades {
    //Variaveis
    private ModalidadeEnum modalidade;
    private int capacidadeMax;  //adicionei porque o enunciado pede

    //Construtor
    public AulaDeGrupo(String nome, Instrutor instrutorAtividade, int duracao, LocalDateTime dataHora, ModalidadeEnum modalidade, int capacidadeMax){
        super (nome, instrutorAtividade, duracao, dataHora);
        this.modalidade = modalidade;
        this.capacidadeMax = capacidadeMax;
    }
}
