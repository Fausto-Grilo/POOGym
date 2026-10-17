public class Socio{
    //Variaveis
    private String nome;
    private int id;
    private String email;
    private double desconto;
    //Alterei de protected para private porque o super nas subclasses já inicializa estas variáveis

    //Construtor
    public Socio(String nome, int id, String email, double desconto){
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.desconto = desconto;
    }
}