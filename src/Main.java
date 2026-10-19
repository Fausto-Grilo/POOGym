import java.io.PrintStream;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

//Alteração Teste

class Main{

    //Lógica
    static String lerTexto(Scanner scan, String mensagem) {

        while (true) {
            System.out.println(mensagem);

            String texto = scan.nextLine().trim();

            if (!texto.isEmpty()) {
                return texto;
            }

            System.out.println("O texto não pode estar vazio.");
        }
    }

    static int lerInteiro(Scanner scan, String mensagem, int minimo) {

        while (true) {
            System.out.println(mensagem);

            String entrada = scan.nextLine().trim();

            try {
                int valor = Integer.parseInt(entrada);

                if (valor >= minimo) {
                    return valor;
                }

                System.out.println(
                        "O valor mínimo permitido é " + minimo + ".");

            } catch (Error e) {
                System.out.println("Insira um número inteiro válido.");
            }
        }
    }

    static Tempo lerData(Scanner scan) {

        while (true) {
            System.out.println(
                    "Insira a data (YYYY-MM-DD-hh-mm):");

            String raw = scan.nextLine().trim();

            // Verifica o formato da data.
            if (!raw.matches(
                    "[0-9]{4}-[0-9]{2}-[0-9]{2}-[0-9]{2}-[0-9]{2}")) {

                System.out.println(
                        "Formato inválido. Exemplo: 2026-10-19-14-30");

                continue;
            }

            String[] partes = raw.split("-");

            try {
                int ano = Integer.parseInt(partes[0]);
                int mes = Integer.parseInt(partes[1]);
                int dia = Integer.parseInt(partes[2]);
                int hora = Integer.parseInt(partes[3]);
                int minuto = Integer.parseInt(partes[4]);

                // Valida também se a data e a hora existem.
                LocalDateTime.of(ano, mes, dia, hora, minuto);

                return new Tempo(ano, mes, dia, hora, minuto);

            } catch (Error error){
                System.err.println("Data ou hora inválida. Tente novamente.");
            }
        }
    }

    static Instrutor selecionarInstrutor(Scanner scan, ArrayList<Instrutor> instrutores) {
        if (instrutores.isEmpty()) {

            System.err.println("Não existem instrutores registados.");
        }

        while (true) {
            System.out.println("Lista de Instrutores:");

            for (int i = 0; i < instrutores.size(); i++) {
                System.out.println(
                        i + " - " + instrutores.get(i).get_nome());
            }

            int escolha = lerInteiro(
                    scan, "Escolha um Instrutor:", 0);

            if (escolha < instrutores.size()) {
                return instrutores.get(escolha);
            }

            System.out.println("Escolha um instrutor válido.");
        }
    }

    static ModalidadeEnum modalidadeEnum(Scanner scan){
        while (true) {
            System.out.println("Lista de Modalidades:");


            ModalidadeEnum values[] = ModalidadeEnum.values();

            for(int i = 0; i < values.length; i++) {
                System.out.println( i + " - " + values[i]);
            }

            System.out.println("Escolha uma Modalidade:");
            int choice = scan.nextInt();

            if(choice <= values.length && choice>=0){
                return values[choice];
            }
        }
    }

    static NivelEnum nivelEnum(Scanner scan){
        while (true) {
            System.out.println("Lista de Niveis:");


            NivelEnum values[] = NivelEnum.values();

            for(int i = 0; i < values.length; i++) {
                System.out.println( i + " - " + values[i]);
            }

            System.out.println("Escolha um Nivel:");
            int choice = scan.nextInt();

            if(choice <= values.length && choice>=0){
                return values[choice];
            }
        }
    }



    // Registos

    static SocioIndividual registar_socio_individual(Scanner scan) {
        //Recolher Dados
        String nome = lerTexto(scan, "Insira o nome: ");

        int id = lerInteiro(scan, "Escolha um id: ", 0);

        String email = lerTexto(scan, "Insira o email: ");

        int anoNascimento = lerInteiro(scan, "Insira o ano de nascimento: ", 1900);

        //Registar socio individual
        return new SocioIndividual(nome, id, email, anoNascimento);
    }

    static SocioEmpresa registar_socio_empresa(Scanner scan) {
        //Recolher Dados
        String nome = lerTexto(scan, "Insira o nome: ");

        int nif = lerInteiro(scan, "Insira o NIF: ", 0);

        String email = lerTexto(scan, "Insira o email: ");

        int anoNascimento = lerInteiro(scan, "Insira o ano de nascimento: ", 1900);

        //Registar socio empresa
        return new SocioEmpresa(nome, nif, email, nif);
    }

    static Instrutor registar_instrutor(Scanner scan) {


        // Receber dados
        String nome = lerTexto(scan, "Insira o Nome:");

        String genero = lerTexto(scan, "Insira o Género");

        String formacao = lerTexto(scan, "Insira a Formação:");

        //Criar objeto instrutor
        return new Instrutor(nome, genero, formacao);
    }

    static AulaGrupo registar_aula_de_grupo(Scanner scan, ArrayList<Instrutor> instrutores) {

        String nome = lerTexto(scan, "Insira o nome da Aula:");

        Tempo data = lerData(scan);

        int duracao = lerInteiro(scan, "Insira a duração (minutos):", 1);

        int preco = lerInteiro(scan, "Insira o preço (€):", 0);

        Instrutor instrutor = selecionarInstrutor(scan, instrutores);

        ModalidadeEnum modalidade = modalidadeEnum(scan);

        int maxCap = lerInteiro(scan, "Insira a capacidade máxima: ", 1);

        return new AulaGrupo(
                nome, instrutor, data, duracao, preco, modalidade, maxCap);

    }

    static SessaoPersonalTrainer registar_sessao_personal(Scanner scan, ArrayList<Instrutor> instrutores) {

        String nome = lerTexto(scan, "Insira o nome da Sessão:");

        Tempo data = lerData(scan);

        int duracao = lerInteiro(scan, "Insira a duração (minutos):", 1);

        int preco = lerInteiro(scan, "Insira o preço (€):", 0);

        Instrutor instrutor = selecionarInstrutor(scan, instrutores);

        NivelEnum nivel = nivelEnum(scan);

        return new SessaoPersonalTrainer(
                nome, instrutor, data, duracao, preco, nivel);

    }

    static void listar_socios(ArrayList<SocioEmpresa> sociosEmpresa, ArrayList<SocioIndividual> socioIndividuals) {
        System.out.println("\nSócios Individuais\n");
        for(int i = 0; i < socioIndividuals.size(); i++){
            socioIndividuals.get(i).showData();
        }

        System.out.println("\nSócios Empresas\n");
        for(int i = 0; i< sociosEmpresa.size(); i++){
            sociosEmpresa.get(i).showData();
        }
    }

    static void listar_ativadades(ArrayList<AulaGrupo> aulasGrupo, ArrayList<SessaoPersonalTrainer> sessoesPersonalTrainer) {

        System.out.println("\nAulas de Grupo\n");

        for(int i = 0; i < aulasGrupo.size(); i++){
            aulasGrupo.get(i).showData();
        }

        System.out.println("\nSessões de Personal Trainer\n");

        for(int i = 0; i < sessoesPersonalTrainer.size(); i++){
            sessoesPersonalTrainer.get(i).showData();
        }
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
        ArrayList<AulaGrupo> aulasGrupo = new ArrayList<>();
        ArrayList<SessaoPersonalTrainer> sessoesPersonalTrainer = new ArrayList<>();



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

            int choice = scan.nextInt();

            switch (choice) {
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
                    System.out.println("1 - Registrar aula de grupo");
                    System.out.println("2 - Registrar sessão personal trainer");

                    int c = scan.nextInt();
                    switch (c){
                        case 1:
                            aulasGrupo.add(registar_aula_de_grupo(scan, instrutors));
                            break;
                        case 2:
                            sessoesPersonalTrainer.add(registar_sessao_personal(scan, instrutors));
                            break;
                        default:
                            break;
                    }
                    break;
                case 5:
                    listar_socios(sociosEmpresa, sociosIndividual);
                    break;
                case 6:
                    listar_ativadades(aulasGrupo, sessoesPersonalTrainer);
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