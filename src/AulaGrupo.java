import java.util.Date;

public class AulaGrupo extends Atividade{

    //Variaveis
    private ModalidadeEnum modalidadeEnum;

    //Construtor

    public AulaGrupo(String nome, Instrutor instrutor, Tempo date, int duracao, double preco, ModalidadeEnum modalidadeEnum){
        super(nome,instrutor,date,duracao,preco);

        this.modalidadeEnum = modalidadeEnum;
    }

    public void showData(){
        System.out.println("Nome: " + nome);
        System.out.println("Instrutor: " + instrutor.get_nome());
        System.out.println("Data: " + date.getDate());
        System.out.println("Duração: " + duracao);
        System.out.println("Modalidade: " + modalidadeEnum.name());
        System.out.println("\nPreço: " + preco + "\n");
    }

}
