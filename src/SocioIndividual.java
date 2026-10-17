public class SocioIndividual extends Socio {
    //Variaveis
    private int anoNascimento;

    //Construtor
    public SocioIndividual(String nome, int id, String email, int anoNascimento){
        super(nome, id, email, calcDescontoIndividual(anoNascimento));
        this.anoNascimento = anoNascimento;
    }

    //Metodo
    private static double calcDescontoIndividual(int anoNascimento){
        int idade = 2026 - anoNascimento;
        if(idade < 18){
            return 0.1;
        }else if(idade >= 65){
            return 0.15;
        }
        return 0;
    }

}
