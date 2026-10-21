import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Gere o menu principal e as operações do sistema de gestão
 * de sócios, atividades e marcações.
 *
 * @author Fausto Henriques
 * @author Rodrigo Correia
 */


class Main {

    /** Contador utilizado para atribuir IDs aos sócios. */
    static int idCount = 0;

    // Lógica

    /**
     * Lê um texto e verifica se está preenchido e se corresponde
     * ao formato indicado.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @param mensagem mensagem apresentada ao utilizador
     * @param regex formato que o texto deve cumprir, ou null
     * @return texto introduzido pelo utilizador
     */
    static private String lerTexto(Scanner scan, String mensagem, String regex) {
        while (true) {
            System.out.println(mensagem);

            String texto = scan.nextLine().trim();

            if (!texto.isEmpty()) {
                if (regex == null) {
                    return texto;
                }

                if (texto.matches(regex)) {
                    return texto;
                } else {
                    System.out.println(
                            "O texto não está no formato correto. Tente novamente.");
                }
            } else {
                System.out.println(
                        "O texto não pode estar vazio. Tente novamente.");
            }
        }
    }

    /**
     * Lê um NIF e verifica se contém exatamente nove algarismos.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @return NIF introduzido
     */
    static private String lerNIF(Scanner scan) {
        while (true) {
            System.out.println("Insira o NIF:");

            String nif = scan.nextLine().trim();

            if (nif.matches("[0-9]{9}")) {
                return nif;
            }

            System.out.println(
                    "O NIF deve conter exatamente 9 algarismos. Tente novamente.");
        }
    }

    /**
     * Lê um número inteiro e verifica se respeita o valor mínimo.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @param mensagem mensagem apresentada ao utilizador
     * @param minimo valor mínimo permitido
     * @return número inteiro introduzido
     */
    static private int lerInteiro(Scanner scan, String mensagem, int minimo) {
        while (true) {
            System.out.println(mensagem);

            String entrada = scan.nextLine().trim();

            try {
                int valor = Integer.parseInt(entrada);

                if (valor >= minimo) {
                    return valor;
                }

                System.out.println(
                        "O valor mínimo permitido é " + minimo + ". Tente novamente.");

            } catch (NumberFormatException e) {
                System.out.println(
                        "Insira um número inteiro válido. Tente novamente.");
            }
        }
    }

    /**
     * Lê uma data e hora e verifica se os valores são válidos.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @return data e hora introduzidas
     */
    static private Tempo lerData(Scanner scan) {
        while (true) {
            System.out.println("Insira a data (YYYY-MM-DD HH:mm):");

            String raw = scan.nextLine().trim();

            if (!raw.matches("[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}")) {
                System.out.println(
                        "Formato inválido. Exemplo: 2026-10-19 14:30. Tente novamente.");
                continue;
            }

            String[] dados = raw.split(" ");

            String[] data = dados[0].split("-");
            String[] horas = dados[1].split(":");

            try {
                int ano = Integer.parseInt(data[0]);
                int mes = Integer.parseInt(data[1]);
                int dia = Integer.parseInt(data[2]);
                int hora = Integer.parseInt(horas[0]);
                int minuto = Integer.parseInt(horas[1]);

                // Valida a data e a hora.
                LocalDateTime.of(ano, mes, dia, hora, minuto);

                return new Tempo(ano, mes, dia, hora, minuto);

            } catch (NumberFormatException | DateTimeException e) {
                System.out.println("Data ou hora inválida. Tente novamente.");
            }
        }
    }

    /**
     * Permite escolher um instrutor da lista disponível.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @param instrutores lista de instrutores registados
     * @return instrutor escolhido, ou null se não existirem instrutores
     */
    static private Instrutor selecionarInstrutor(Scanner scan, ArrayList<Instrutor> instrutores) {

        if (instrutores.isEmpty()) {
            System.err.println("Não existem instrutores registados.");
            return null;
        }

        while (true) {
            System.out.println("Lista de Instrutores:");

            for (int i = 0; i < instrutores.size(); i++) {
                System.out.println(i + " - " + instrutores.get(i).getNome());
            }

            int escolha = lerInteiro(scan, "Escolha um Instrutor:", 0);

            if (escolha < instrutores.size()) {
                return instrutores.get(escolha);
            }

            System.out.println("Escolha um instrutor válido.");
        }
    }

    /**
     * Permite escolher um sócio individual da lista disponível.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @param sociosIndividual lista de sócios individuais
     * @return sócio escolhido, ou null se a lista estiver vazia
     */
    static private SocioIndividual selecionarSocioIndividual(Scanner scan, ArrayList<SocioIndividual> sociosIndividual) {

        if (sociosIndividual.isEmpty()) {
            System.err.println("Não existem socios individuais registados.");
            return null;
        }

        while (true) {
            System.out.println("Lista de Sócios Individuais:");

            for (int i = 0; i < sociosIndividual.size(); i++) {
                System.out.println(
                        i + " - " + sociosIndividual.get(i).getNome());
            }

            int escolha = lerInteiro(
                    scan, "Escolha um Sócio Individual:", 0);

            if (escolha < sociosIndividual.size()) {
                return sociosIndividual.get(escolha);
            }

            System.out.println("Escolha um sócio válido.");
        }
    }

    /**
     * Permite escolher um sócio empresa da lista disponível.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @param sociosEmpresa lista de sócios empresa
     * @return sócio escolhido, ou null se a lista estiver vazia
     */
    static private SocioEmpresa selecionarSocioEmpresa(Scanner scan, ArrayList<SocioEmpresa> sociosEmpresa) {

        if (sociosEmpresa.isEmpty()) {
            System.err.println("Não existem socios empresa registados.");
            return null;
        }

        while (true) {
            System.out.println("Lista de Sócios Empresa:");

            for (int i = 0; i < sociosEmpresa.size(); i++) {
                System.out.println(
                        i + " - " + sociosEmpresa.get(i).getNome());
            }

            int escolha = lerInteiro(
                    scan, "Escolha um Sócio Empresa:", 0);

            if (escolha < sociosEmpresa.size()) {
                return sociosEmpresa.get(escolha);
            }

            System.out.println("Escolha um sócio válido.");
        }
    }

    /**
     * Permite escolher o tipo de sócio e selecionar um sócio registado.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @param sociosIndividual lista de sócios individuais
     * @param sociosEmpresa lista de sócios empresa
     * @return sócio escolhido, ou null se o utilizador voltar atrás
     */
    static private Socio selecionarSocio(Scanner scan, ArrayList<SocioIndividual> sociosIndividual, ArrayList<SocioEmpresa> sociosEmpresa) {

        while (true) {
            System.out.println("1- Sócio Individual");
            System.out.println("2- Socio Empresa");
            System.out.println("3- Back");

            int choice = lerInteiro(scan, "Escolha", 1);

            switch (choice) {
                case 1:
                    Socio sI = selecionarSocioIndividual(
                            scan, sociosIndividual);
                    if (sI != null) {
                        return sI;
                    }

                case 2:
                    Socio sE = selecionarSocioEmpresa(
                            scan, sociosEmpresa);
                    if (sE != null) {
                        return sE;
                    }
                    continue;

                case 3:
                    return null;

                default:
                    continue;
            }
        }
    }

    /**
     * Apresenta as modalidades disponíveis e permite escolher uma.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @return modalidade escolhida
     */
    static private ModalidadeEnum modalidadeEnum(Scanner scan) {
        while (true) {
            System.out.println("Lista de Modalidades:");

            ModalidadeEnum values[] = ModalidadeEnum.values();

            for (int i = 0; i < values.length; i++) {
                System.out.println(i + " - " + values[i]);
            }

            int choice = lerInteiro(scan, "Escolha uma modalidade:", 0);

            if (choice <= values.length && choice >= 0) {
                return values[choice];
            }
        }
    }

    /**
     * Apresenta os níveis disponíveis e permite escolher um.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @return nível escolhido
     */
    static private NivelEnum nivelEnum(Scanner scan) {
        while (true) {
            System.out.println("Lista de Niveis:");

            NivelEnum values[] = NivelEnum.values();

            for (int i = 0; i < values.length; i++) {
                System.out.println(i + " - " + values[i]);
            }

            int choice = lerInteiro(scan, "Escolha um Nivel: ", 0);

            if (choice <= values.length && choice >= 0) {
                return values[choice];
            }
        }
    }

    /**
     * Permite escolher uma aula de grupo da lista disponível.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @param aulasGrupo lista de aulas de grupo registadas
     * @return aula escolhida, ou null se a lista estiver vazia
     */
    static private AulaGrupo selecionarAulaGrupo(Scanner scan, ArrayList<AulaGrupo> aulasGrupo, ArrayList<Marcacao> marcacoes) {

        if (aulasGrupo.isEmpty()) {
            System.err.println("Não existem aulas de grupo registadas.");
            return null;
        }

        while (true) {
            System.out.println("Lista de Aulas de Grupo:");

            for (int i = 0; i < aulasGrupo.size(); i++) {
                System.out.println(
                        i + " - " + aulasGrupo.get(i).getNome());
            }

            int escolha = lerInteiro(
                    scan, "Escolha uma Aula de Grupo:", 0);

            if (escolha < aulasGrupo.size()) {
                if(!isAGFull(marcacoes, aulasGrupo.get(escolha))){
                    return aulasGrupo.get(escolha);
                }else{
                    System.err.println("Aula cheia, escolha outra");
                    return null;
                }
            }else {
                System.err.println("Escolha uma aula válida.");
            }
        }
    }

    /**
     * Permite escolher uma sessão de Personal Training da lista disponível.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @param sessoesPersonalTrainer lista de sessões registadas
     * @return sessão escolhida, ou null se a lista estiver vazia
     */
    static private SessaoPersonalTrainer selecionarSessaoPersonalTrainer(Scanner scan, ArrayList<SessaoPersonalTrainer> sessoesPersonalTrainer, ArrayList<Marcacao> marcacoes) {

        if (sessoesPersonalTrainer.isEmpty()) {
            System.err.println("Não existem sessões de PT registadas.");
            return null;
        }

        while (true) {
            System.out.println("Lista de Sessões de Personal Training:");

            for (int i = 0; i < sessoesPersonalTrainer.size(); i++) {
                System.out.println(
                        i + " - " + sessoesPersonalTrainer.get(i).getNome());
            }

            int escolha = lerInteiro(
                    scan, "Escolha uma Sessão de Personal Training:", 0);

            if (escolha < sessoesPersonalTrainer.size()) {
                if(!isSPTFull(marcacoes, sessoesPersonalTrainer.get(escolha))){
                    return sessoesPersonalTrainer.get(escolha);
                }else{
                    System.err.println("Sessão cheia, escolha outra");
                    return null;
                }
            }else {
                System.err.println("Escolha uma sessão válida.");
            }

            System.out.println("Escolha uma sessão válida.");
        }
    }

    /**
     * Permite escolher o tipo de atividade e selecionar uma atividade registada.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @param aulasGrupo lista de aulas de grupo
     * @param sessoesPersonalTrainer lista de sessões de Personal Training
     * @return atividade escolhida, ou null se o utilizador voltar atrás
     */


    static private Atividade selecionarAtividade(Scanner scan, ArrayList<AulaGrupo> aulasGrupo, ArrayList<SessaoPersonalTrainer> sessoesPersonalTrainer, ArrayList<Marcacao> marcacoes) {

        while (true) {
            System.out.println("1- Aula de Grupo");
            System.out.println("2- Sessão Personal Training");
            System.out.println("3- Back");

            int choice = lerInteiro(scan, "Escolha", 1);

            switch (choice) {
                case 1:
                    Atividade aG = selecionarAulaGrupo(scan, aulasGrupo, marcacoes);
                    if (aG != null) {
                        return aG;
                    }
                    continue;

                case 2:
                    Atividade sPT = selecionarSessaoPersonalTrainer(
                            scan, sessoesPersonalTrainer, marcacoes);
                    if (sPT != null) {
                        return sPT;
                    }
                    continue;

                case 3:
                    return null;

                default:
                    continue;
            }
        }
    }

    /**
     * Verifica se o sócio já tem uma marcação que coincide com o horário
     * da atividade escolhida.
     *
     * @param socio sócio que pretende fazer a marcação
     * @param marcacoes lista de marcações existentes
     * @param tempo data e hora da nova atividade
     * @param duracao duração da nova atividade em minutos
     * @return true se não existir sobreposição, false caso contrário
     */
    static private boolean verificarSobrePosicoes(Socio socio, ArrayList<Marcacao> marcacoes, Tempo tempo, int duracao) {

        for (Marcacao marcacao : marcacoes) {
            if (marcacao.getSocio().equals(socio)) {

                Tempo dataExistente = marcacao.getAtividade().getDate();

                if (dataExistente.getSimpleDate().equals(tempo.getSimpleDate())) {

                    int inicioExistente = dataExistente.getMinutes();

                    int fimExistente = inicioExistente
                            + marcacao.getAtividade().getDuracao();

                    int inicioNovo = tempo.getMinutes();
                    int fimNovo = inicioNovo + duracao;

                    if (inicioNovo < fimExistente && fimNovo > inicioExistente) {
                        System.err.println("\nSobreposição de atividades.\n");
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     * Verifica se o instrutor já tem uma atividade que coincide com o horário
     * da atividade escolhida.
     *
     * @param instrutor sócio que pretende fazer a marcação
     * @param aulasGrupo lista de aulas de grupo existentes
     * @param sessoesPersonalTrainer lista de sessões de PT existentes
     * @param tempo data e hora da nova atividade
     * @param duracao duração da nova atividade em minutos
     * @return true se não existir sobreposição, false caso contrário
     */
    static private boolean verificarSobrePosicoesInstrutor(Instrutor instrutor, ArrayList<AulaGrupo> aulasGrupo, ArrayList<SessaoPersonalTrainer> sessoesPersonalTrainer, Tempo tempo, int duracao) {

        ArrayList<Atividade> atividades = new ArrayList<>();
        atividades.addAll(aulasGrupo);
        atividades.addAll(sessoesPersonalTrainer);

        for (Atividade atividade : atividades) {
            if (atividade.getInstrutor().equals(instrutor)) {

                Tempo dataExistente = atividade.getDate();

                //Se no mesmo dia
                if (dataExistente.getSimpleDate().equals(tempo.getSimpleDate())) {

                    int inicioExistente = dataExistente.getMinutes();

                    int fimExistente = inicioExistente
                            + atividade.getDuracao();

                    int inicioNovo = tempo.getMinutes();
                    int fimNovo = inicioNovo + duracao;

                    if (inicioNovo < fimExistente && fimNovo > inicioExistente) {
                        System.err.println("\nSobreposição de atividades.\n");
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     * Verifica se a aula já está cheia
     *
     * @param marcacoes lista de marcações existentes
     * @param aulaGrupo aula que queremos verificar
     * @return true se estiver cheia, false ainda houver vagas
     */
    static private boolean isAGFull(ArrayList<Marcacao> marcacoes, AulaGrupo aulaGrupo){

        int totalMarcacoes = 0;

        for(Marcacao marcacao: marcacoes){
            if(marcacao.getAtividade() == aulaGrupo){
                totalMarcacoes++;
            }
        }

        return totalMarcacoes >= aulaGrupo.getMaxCap();
    }


    /**
     * Verifica se a sessão de PT já está cheia
     *
     * @param marcacoes lista de marcações existentes
     * @param sessaoPersonalTrainer sessão que queremos verificar
     * @return true se estiver cheia, false ainda houver vaga
     */
    static private boolean isSPTFull(ArrayList<Marcacao> marcacoes, SessaoPersonalTrainer sessaoPersonalTrainer){

        for(Marcacao marcacao: marcacoes){
            if(marcacao.getAtividade() == sessaoPersonalTrainer){
                return true;
            }
        }

        return false;
    }

    // Registos

    /**
     * Recolhe os dados necessários e regista um sócio individual.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @return novo sócio individual
     */
    static private SocioIndividual registar_socio_individual(Scanner scan) {
        // Recolher dados
        String nome = lerTexto(scan, "Insira o nome: ", null);

        int id = idCount;
        idCount += 1;

        String email = lerTexto(
                scan,
                "Insira o email (ex: nome@gmail.com): ",
                "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

        int anoNascimento = lerInteiro(
                scan, "Insira o ano de nascimento: ", 1900);

        // Registar sócio individual
        return new SocioIndividual(nome, id, email, anoNascimento);
    }

    /**
     * Recolhe os dados necessários e regista um sócio empresa.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @return novo sócio empresa
     */
    static private SocioEmpresa registar_socio_empresa(Scanner scan) {
        // Recolher dados
        String nome = lerTexto(scan, "Insira o nome: ", null);

        int id = idCount;
        idCount += 1;

        String nif = lerNIF(scan);

        String email = lerTexto(scan, "Insira o email: ", null);

        int anoNascimento = lerInteiro(
                scan, "Insira o ano de nascimento: ", 1900);

        // Registar sócio empresa
        return new SocioEmpresa(nome, id, email, nif);
    }

    /**
     * Recolhe os dados necessários e regista um instrutor.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @return novo instrutor
     */
    static private Instrutor registar_instrutor(Scanner scan) {
        // Receber dados
        String nome = lerTexto(scan, "Insira o Nome:", null);

        String genero = lerTexto(scan, "Insira o Género", null);

        String formacao = lerTexto(scan, "Insira a Formação:", null);

        // Criar objeto instrutor
        return new Instrutor(nome, genero, formacao);
    }

    /**
     * Recolhe os dados e regista uma nova aula de grupo.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @param instrutores lista de instrutores disponíveis
     * @param aulasGrupo lista de aulas de grupo existentes
     * @param sessoesPersonalTrainer lista de sessões de PT existentes
     * @return nova aula de grupo, ou null se não for escolhido um instrutor, ou se o instrutor escolhido não estiver disponivel
     */
    static private AulaGrupo registar_aula_de_grupo(Scanner scan, ArrayList<Instrutor> instrutores, ArrayList<AulaGrupo> aulasGrupo, ArrayList<SessaoPersonalTrainer> sessoesPersonalTrainer) {

        String nome = lerTexto(scan, "Insira o nome da Aula:", null);

        Tempo data = lerData(scan);

        int duracao = lerInteiro(
                scan, "Insira a duração (minutos):", 1);

        int preco = lerInteiro(
                scan, "Insira o preço (€):", 0);

        Instrutor instrutor = selecionarInstrutor(scan, instrutores);

        if (instrutor == null) {
            return null;
        }

        if (!verificarSobrePosicoesInstrutor(instrutor, aulasGrupo, sessoesPersonalTrainer, data, duracao)){
            System.err.println("Escolha outro instrutor.");
            return null;
        }



        ModalidadeEnum modalidade = modalidadeEnum(scan);

        int maxCap = lerInteiro(
                scan, "Insira a capacidade máxima: ", 1);

        return new AulaGrupo(
                nome, instrutor, data, duracao, preco, modalidade, maxCap);
    }

    /**
     * Recolhe os dados e regista uma sessão de Personal Training.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @param instrutores lista de instrutores disponíveis
     * @param aulasGrupo lista de aulas de grupo existentes
     * @param sessoesPersonalTrainer lista de sessões de PT existentes
     * @return nova sessão, ou null se não for escolhido um instrutor, ou se o instrutor escolhido não estiver disponivel
     */
    static private SessaoPersonalTrainer registar_sessao_personal(Scanner scan, ArrayList<Instrutor> instrutores, ArrayList<AulaGrupo> aulasGrupo, ArrayList<SessaoPersonalTrainer> sessoesPersonalTrainer) {

        String nome = lerTexto(scan, "Insira o nome da Sessão:", null);

        Tempo data = lerData(scan);

        int duracao = lerInteiro(
                scan, "Insira a duração (minutos):", 1);

        int preco = lerInteiro(
                scan, "Insira o preço (€):", 0);

        Instrutor instrutor = selecionarInstrutor(scan, instrutores);

        if (instrutor == null) {
            return null;
        }

        if (!verificarSobrePosicoesInstrutor(instrutor, aulasGrupo, sessoesPersonalTrainer, data, duracao)){
            System.err.println("Escolha outro instrutor.");
            return null;
        }

        NivelEnum nivel = nivelEnum(scan);

        return new SessaoPersonalTrainer(
                nome, instrutor, data, duracao, preco, nivel);
    }

    /**
     * Mostra os sócios individuais e os sócios empresa registados.
     *
     * @param sociosEmpresa lista de sócios empresa
     * @param socioIndividuals lista de sócios individuais
     */
    static private void listar_socios(ArrayList<SocioEmpresa> sociosEmpresa, ArrayList<SocioIndividual> socioIndividuals) {

        if (socioIndividuals.isEmpty() && sociosEmpresa.isEmpty()) {
            System.err.println("Não existem sócios registados");
            return;
        }

        if (!socioIndividuals.isEmpty()) {
            System.out.println("\nSócios Individuais\n");

            for (int i = 0; i < socioIndividuals.size(); i++) {
                socioIndividuals.get(i).showData();
            }
        }

        if (!sociosEmpresa.isEmpty()) {
            System.out.println("\nSócios Empresas\n");

            for (int i = 0; i < sociosEmpresa.size(); i++) {
                sociosEmpresa.get(i).showData();
            }
        }
    }

    /**
     * Mostra as aulas de grupo e as sessões de Personal Training registadas.
     *
     * @param aulasGrupo lista de aulas de grupo
     * @param sessoesPersonalTrainer lista de sessões de Personal Training
     */
    static private void listar_ativadades(ArrayList<AulaGrupo> aulasGrupo, ArrayList<SessaoPersonalTrainer> sessoesPersonalTrainer) {

        if (aulasGrupo.isEmpty() && sessoesPersonalTrainer.isEmpty()) {
            System.err.println("Não Existe Atividades Registadas");
            return;
        }

        if (!aulasGrupo.isEmpty()) {
            System.out.println("\nAulas de Grupo\n");

            for (int i = 0; i < aulasGrupo.size(); i++) {
                aulasGrupo.get(i).showData();
            }
        }

        if (!sessoesPersonalTrainer.isEmpty()) {
            System.out.println("\nSessões de Personal Trainer\n");

            for (int i = 0; i < sessoesPersonalTrainer.size(); i++) {
                sessoesPersonalTrainer.get(i).showData();
            }
        }
    }

    /**
     * Cria uma marcação depois de selecionar um sócio e uma atividade.
     * Antes de a criar, verifica se existe sobreposição de horários.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @param marcacoes lista de marcações existentes
     * @param sociosIndividual lista de sócios individuais
     * @param sociosEmpresa lista de sócios empresa
     * @param aulasGrupo lista de aulas de grupo
     * @param sessoesPersonalTrainer lista de sessões de Personal Training
     * @return nova marcação, ou null se a operação for cancelada
     */
    static private Marcacao criar_marcacao(Scanner scan, ArrayList<Marcacao> marcacoes, ArrayList<SocioIndividual> sociosIndividual, ArrayList<SocioEmpresa> sociosEmpresa, ArrayList<AulaGrupo> aulasGrupo, ArrayList<SessaoPersonalTrainer> sessoesPersonalTrainer) {

        // Selecionar sócio
        System.out.println("Escolha um sócio");

        Socio socio = selecionarSocio(
                scan, sociosIndividual, sociosEmpresa);

        // Verificar se foi selecionado um sócio
        if (socio == null) {
            System.err.println("Erro: nenhum sócio selecionado.");
            return null;
        }

        // Selecionar atividade e verificar sobreposições
        Atividade atividade;

        while (true) {
            System.out.println("Escolha uma atividade");

            atividade = selecionarAtividade(scan, aulasGrupo, sessoesPersonalTrainer, marcacoes);

            if (atividade == null) {
                return null;
            }

            boolean semSobreposicao = verificarSobrePosicoes(socio, marcacoes, atividade.getDate(), atividade.getDuracao());





            if (semSobreposicao) {
                break;
            }


            System.err.println("Escolha outra atividade ou horário.");
        }

        return new Marcacao(socio, atividade);
    }

    /**
     * Mostra todas as marcações existentes.
     *
     * @param marcacoes lista de marcações registadas
     */
    static private void listar_marcacao(ArrayList<Marcacao> marcacoes) {
        if (marcacoes.isEmpty()) {
            System.err.println("Não Existe Marcações");
            return;
        }

        for (int i = 0; i < marcacoes.size(); i++) {
            if (marcacoes.get(i) == null) {
                continue;
            }

            System.out.print(marcacoes.get(i).toString());
        }
    }

    /**
     * Apresenta o número de sócios e atividades registados.
     *
     * @param sociosIndividual lista de sócios individuais
     * @param socioEmpresas lista de sócios empresa
     * @param aulasGrupo lista de aulas de grupo
     * @param sessoesPersonalTrainer lista de sessões de Personal Training
     */
    static private void resumir_ativadade(ArrayList<SocioIndividual> sociosIndividual, ArrayList<SocioEmpresa> socioEmpresas, ArrayList<AulaGrupo> aulasGrupo, ArrayList<SessaoPersonalTrainer> sessoesPersonalTrainer) {

        System.out.println("\nSócios Individuais: " + sociosIndividual.size());
        System.out.println("Sócios Empresa: " + socioEmpresas.size());
        System.out.println("Aulas de Grupo: " + aulasGrupo.size());
        System.out.println(
                "Sessões de Personal Training: "
                        + sessoesPersonalTrainer.size() + '\n');
    }

    /**
     * Identifica e apresenta a atividade com mais marcações.
     *
     * @param marcacoes lista de marcações registadas
     */
    static private void listar_atividade_popular(ArrayList<Marcacao> marcacoes) {
        if (marcacoes.isEmpty()) {
            System.err.println("\nNão existem marcações registadas.\n");
            return;
        }

        Atividade maisPopular = null;
        int maximo = 0;

        for (Marcacao marcacao : marcacoes) {
            if (marcacao == null) {
                continue;
            }

            Atividade atividade = marcacao.getAtividade();
            int contagem = 0;

            for (Marcacao outra : marcacoes) {
                if (outra == null) {
                    continue;
                }

                if (outra.getAtividade().equals(atividade)) {
                    contagem++;
                }
            }

            if (contagem > maximo) {
                maximo = contagem;
                maisPopular = atividade;
            }
        }

        if (maisPopular != null) {
            System.out.println(
                    "\n\nAtividade mais popular: " + maisPopular.getNome());
            System.out.println("Número de marcações: " + maximo + "\n\n");
        }
    }

    /**
     * Calcula quanto um sócio gastou e poupou no total das suas marcações.
     *
     * @param scan leitor de dados introduzidos pelo utilizador
     * @param marcacoes lista de marcações registadas
     */
    static private void mostrar_valor_socio(Scanner scan, ArrayList<Marcacao> marcacoes) {

        int id = lerInteiro(scan, "Insira o ID do sócio", 0);

        double valorTotal = 0;
        double valorPoupado = 0;

        if (id < idCount) {
            for (Marcacao marcacao : marcacoes) {
                if (marcacao.getSocio().id == id) {
                    valorTotal += marcacao.getCustoFinal();
                    valorPoupado += marcacao.getValorPoupado();
                }
            }

            System.out.println(
                    "\nValor Gasto: " + valorTotal
                            + "\nValor Poupado: " + valorPoupado + "\n");
        } else {
            System.err.println("\nID invalido\n");
        }
    }

    /**
     * Inicia o programa, prepara as listas e apresenta o menu principal.
     **/
    static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int idCount = 0;

        ArrayList<SocioEmpresa> sociosEmpresa = new ArrayList<>();
        ArrayList<SocioIndividual> sociosIndividual = new ArrayList<>();
        ArrayList<Instrutor> instrutors = new ArrayList<>();
        ArrayList<AulaGrupo> aulasGrupo = new ArrayList<>();
        ArrayList<SessaoPersonalTrainer> sessoesPersonalTrainer = new ArrayList<>();
        ArrayList<Marcacao> marcacoes = new ArrayList<>();

        // Menu principal
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

            int choice = lerInteiro(scan, "Escolha: ", 1);

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

                    int c = lerInteiro(scan, "Escolha: ", 1);

                    switch (c) {
                        case 1:
                            AulaGrupo a = registar_aula_de_grupo(
                                    scan, instrutors, aulasGrupo, sessoesPersonalTrainer);
                            if (a != null) {
                                aulasGrupo.add(a);
                            }
                            break;

                        case 2:
                            SessaoPersonalTrainer s =
                                    registar_sessao_personal(scan, instrutors, aulasGrupo, sessoesPersonalTrainer);
                            if (s != null) {
                                sessoesPersonalTrainer.add(s);
                            }
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
                    Marcacao m = criar_marcacao(
                            scan,
                            marcacoes,
                            sociosIndividual,
                            sociosEmpresa,
                            aulasGrupo,
                            sessoesPersonalTrainer);

                    if (m != null) {
                        marcacoes.add(m);
                    }
                    break;

                case 8:
                    listar_marcacao(marcacoes);
                    break;

                case 9:
                    resumir_ativadade(
                            sociosIndividual,
                            sociosEmpresa,
                            aulasGrupo,
                            sessoesPersonalTrainer);
                    break;

                case 10:
                    listar_atividade_popular(marcacoes);
                    break;

                case 11:
                    mostrar_valor_socio(scan, marcacoes);
                    break;

                case 12:
                    scan.close();
                    return;

                default:
                    System.out.println("Escolha Inválida");
            }
        }
    }

    // Duvidas a tirar
    // 1. separação de logica do Main
    // 2. exclarecer a função listar_atividade_popular

}

