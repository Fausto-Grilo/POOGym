import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

//Alteração Teste

class Main{

    static SocioIndividual registar_socio_individual(Scanner scan) {
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
        return socioIndividual;
    }

    static SocioEmpresa registar_socio_empresa(Scanner scan) {
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
        return  socioEmpresa;
    }

    static Instrutor registar_instrutor(Scanner scan) {
        // Receber dados do usuario
        System.out.println("Insira o nome do instrutor:");
        String nome = scan.next();
        System.out.println("Insira o genero do instrutor:");
        String genero = scan.next();
        System.out.println("Insira a formação do instrutor:");
        String formacao = scan.next();

        //Criar objeto instrutor
        Instrutor instrutor = new Instrutor(nome, genero, formacao);
        return instrutor;
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

        ArrayList<SocioEmpresa> sociosEmpresa = new ArrayList<>();
        ArrayList<SocioIndividual> sociosIndividual = new ArrayList<>();
        ArrayList<Instrutor> instrutors = new ArrayList<>();



        //Main Loop
        while (true) {
            System.out.println("1 - Registrar um novo sócio individual");
            System.out.println("2 - Registrar um novo sócio empresa");
            System.out.println("3 - Registrar um novo intrutor");
            System.out.println("4 - Registrar uma nova atividade");
            System.out.println("5 - Listar sócios");
            System.out.println("6 - Listar atividades");
            System.out.println("7 - Criar marcação");
            System.out.println("8 - Listar marcações");
            System.out.println("9 - Resumir ativadade");
            System.out.println("10 - Listar atividade mais popular");
            System.out.println("11 - Mostrar o valor de um sócio");
            System.out.println("12 - Sair");

            int choise = scan.nextInt();

            //Adicionar Sanatização


            switch (choise) {
                case 1:
                    sociosIndividual.add(registar_socio_individual(scan));
                    break;
                case 2:
                    sociosEmpresa.add(registar_socio_empresa(scan));
                    break;
                case 3:
                    instrutors.add(registar_instrutor(scan));
                    break;
                case 4:
                    registar_atividade(scan);
                    break;
                case 5:
                    listar_socios();
                    break;
                case 6:
                    listar_ativadades();
                    break;
                case 7:
                    criar_marcacao();
                    break;
                case 8:
                    listar_marcacao();
                    break;
                case 9:
                    resumir_ativadade();
                    break;
                case 10:
                    listar_atividade_popular();
                    break;
                case 11:
                    mostrar_valor_socio();
                    break;
                case 12:
                    scan.close();
                    return;
                default:
                    System.out.println("Escolha Inválida");
            }
        }
    }
}