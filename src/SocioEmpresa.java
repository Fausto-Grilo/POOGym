public class SocioEmpresa extends Socio {
    //Variaveis
    private int nif;

    //Construtor
    public SocioEmpresa(String nome, int id, String email, int nif){
        super(nome, id, email, 20);
        this.nif = nif; 
    }
}
