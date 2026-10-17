public class SocioEmpresa extends Socio {
    //Variaveis
    private int nif;

    //Construtor
    public SocioEmpresa(String nome, int id, String email, int nif){
        super(nome, id, email, 0.2); //alterei de 20 para 0.2
        this.nif = nif; 
    }

}
