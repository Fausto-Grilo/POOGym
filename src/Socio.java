public class Socio {
    //Variaveis
    protected String nome;
    protected int id;
    protected String email;
    protected double desconto;

    //Construtor
    public Socio(String nome, int id, String email, double desconto) {
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.desconto = desconto;
    }

    //Metodo
    public double getDesconto() {return this.desconto; }
    public String getNome() {return this.nome;}
}