public class SocioEmpresa extends Socio {
    //Variaveis
    private int nif;

    //Construtor
    public SocioEmpresa(String nome, int id, String email, int nif){
        super(nome, id, email, 20);
        this.nif = nif; 
    }

    public void showData(){
        System.out.println("Nome da Empresa: "+ nome);
        System.out.println("NIF: " + nif);
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Desconto: " + desconto + "\n");
    }

}
