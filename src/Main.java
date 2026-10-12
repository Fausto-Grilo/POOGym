import java.util.Scanner;

//Alteração Teste

class Main{

    static void registar_socio(Scanner scan) {
        //Destinguir entre socio individual e empresa
        System.out.println("1- Socio Individual");
        System.out.println("2- Socio Empresa");
        int choise = scan.nextInt();
        if(choise == 1){
            //Recolher Dados
            System.out.println("Insira o nome do socio individual:");
            String nome = scan.next();
            System.out.println("Insira o id do socio individual:");
            int id = scan.nextInt();
            System.out.println("Insira o email do socio individual:");
            String email = scan.next();
            System.out.println("Insira o ano de nascimento do socio individual:");
            int anoNascimento = scan.nextInt();

            //Registar socio individual
            SocioIndividual socioIndividual = new SocioIndividual(nome, id, email, anoNascimento);
        }
        if(choise == 2){
            //Recolher Dados
            
            System.out.println("Insira o nome da empresa:");
            String nome = scan.next();
            System.out.println("Insira o NIF da empresa:");
            int nif = scan.nextInt();
            System.out.println("Insira o id do socio empresa:");
            int id = scan.nextInt();
            System.out.println("Insira o email do socio empresa:");
            String email = scan.next();

            //Registar socio empresa
            SocioEmpresa socioEmpresa = new SocioEmpresa(nome, id, email, nif);
        }
    }

    static void registar_instrutor(Scanner scan) {
        // Receber dados do usuario
        System.out.println("Insira o nome do instrutor:");
        String nome = scan.next();
        System.out.println("Insira o genero do instrutor:");
        String genero = scan.next();
        System.out.println("Insira a formação do instrutor:");
        String formacao = scan.next();

        //Criar objeto instrutor
        Instrutor instrutor = new Instrutor(nome, genero, formacao);
    }

    static void registar_atividade(Scanner scan) {
        
    }

    static void listar_socios() {
        
    }

    static void listar_ativadades() {
        
    }

    static void criar_marcacao() {
        
    }

    static void listar_marcacao() {
        
    }

    static void resumir_ativadade() {
        
    }

    static void listar_atividade_popular() {
        
    }

    static void mostrar_valor_socio(){

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Main Loop
        while (true) {
            System.out.println("1 - Registrar um novo sócio");
            System.out.println("2 - Registrar um novo intrutor");
            System.out.println("3 - Registrar uma nova atividade");
            System.out.println("4 - Listar sócios");
            System.out.println("5 - Listar atividades");
            System.out.println("6 - Criar marcação");
            System.out.println("7 - Listar marcações");
            System.out.println("8 - Resumir ativadade");
            System.out.println("9 - Listar atividade mais popular");
            System.out.println("10 - Mostrar o valor de um sócio");
            System.out.println("11 - Sair");

            int choise = scan.nextInt();

            //Adicionar Sanatização


            switch (choise) {
                case 1:
                    registar_socio(scan);
                    break;
                case 2:
                    registar_instrutor(scan);
                    break;
                case 3:
                    registar_atividade(scan);
                    break;
                case 4:
                    listar_socios();
                    break;
                case 5:
                    listar_ativadades();
                    break;
                case 6:
                    criar_marcacao();
                    break;
                case 7:
                    listar_marcacao();
                    break;
                case 8:
                    resumir_ativadade();
                    break;
                case 9:
                    listar_atividade_popular();
                    break;
                case 10:
                    mostrar_valor_socio();
                    break;
                case 11:
                    scan.close();
                    return;
                default:
                    System.out.println("Escolha Inválida");
            }
        }
    }
}