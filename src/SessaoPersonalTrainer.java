import java.util.Date;

public class SessaoPersonalTrainer extends Atividade{

    //Variaveis
    private NivelEnum nivelEnum;

    //Construtor

    public SessaoPersonalTrainer(String nome, Instrutor instrutor, Tempo date, int duracao, double preco, NivelEnum nivelEnum){
        super(nome,instrutor,date,duracao,preco);

        this.nivelEnum = nivelEnum;
    }

    public void showData(){
        System.out.println("Nome: " + nome);
        System.out.println("Instrutor: " + instrutor.get_nome());
        System.out.println("Data: " + date.getDate());
        System.out.println("Duração: " + duracao);
        System.out.println("Nivel: " + nivelEnum.name());
        System.out.println("\nPreço: " + preco + "\n");
    }

}
