public class SocioIndividual extends Socio {
    //Variaveis
    private int anoNascimento;

    //Construtor
    public SocioIndividual(String nome, int id, String email, int anoNascimento){
        super(nome, id, email, calcularDesconto(anoNascimento));
        this.anoNascimento = anoNascimento;
    }

    //Metodo
    private static double calcularDesconto(int anoNascimento){
        int idade = 2026 - anoNascimento;
        if(idade < 18){
            return 0.1;
        }else if(idade >= 65){
            return 0.15;
        }
        return 0;
    }

    public void showData(){
        System.out.println("Nome: "+ nome);
        System.out.println("Ano de Nascimento: " + anoNascimento);
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Desconto: " + desconto + "\n");
    }



}