import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Ginasio {

    private ArrayList<SocioEmpresa> sociosEmpresa;
    private ArrayList<SocioIndividual> sociosIndividual;
    private ArrayList<Instrutor> instrutores;
    private ArrayList<AulaGrupo> aulasGrupo;
    private ArrayList<SessaoPersonalTrainer> sessoesPersonalTrainer;
    private ArrayList<Marcacao> marcacoes;
    private Scanner scan;

    /** Contador utilizado para atribuir IDs aos sócios. */
    private int idCount = 0;

    /**
     * Construtor da Classe
     */

    public Ginasio() {
        sociosEmpresa = new ArrayList<>();
        sociosIndividual = new ArrayList<>();
        instrutores = new ArrayList<>();
        aulasGrupo = new ArrayList<>();
        sessoesPersonalTrainer = new ArrayList<>();
        marcacoes = new ArrayList<>();
        scan = new Scanner(System.in);

        carregarDadosDemo();
    }

    // Lógica

    /**
     * Cria os dados de demonstração exigidos para a Fase 1.
     * Os dados são criados em memória; não são lidos nem escritos em ficheiros.
     */
    private void carregarDadosDemo() {

        sociosIndividual.add(new SocioIndividual("Ana Silva", idCount++, "ana.silva@example.com", 1999));
        sociosIndividual.add(new SocioIndividual("João Pereira", idCount++, "joao.pereira@example.com", 2010));
        sociosIndividual.add(new SocioIndividual("Maria Costa", idCount++, "maria.costa@example.com", 1958));

        sociosEmpresa.add(new SocioEmpresa("Zé Pedro", idCount++, "contacto@horizonte.example", "501234567"));
        sociosEmpresa.add(new SocioEmpresa("Maria Irene", idCount++, "geral@atlantico.example", "509876543"));
        sociosEmpresa.add(new SocioEmpresa("Pedro Mendes", idCount++, "info@pinhal.example", "502345678"));

        Instrutor instrutorAna = new Instrutor("Ana Martins", "Feminino", "Licenciatura em Desporto; Yoga");
        Instrutor instrutorBruno = new Instrutor("Bruno Costa", "Masculino", "Personal Training; CrossFit");
        Instrutor instrutorCarla = new Instrutor("Carla Santos", "Feminino", "Spinning; Zumba");
        Instrutor instrutorDiogo = new Instrutor("Diogo Rocha", "Masculino", "Treino funcional; Musculação");
        instrutores.add(instrutorAna);
        instrutores.add(instrutorBruno);
        instrutores.add(instrutorCarla);
        instrutores.add(instrutorDiogo);

        // Quatro aulas de grupo com os preços definidos no enunciado.
        aulasGrupo.add(new AulaGrupo("Yoga de manhã", instrutorAna, new Tempo(2026, 10, 26, 9, 0), 60, ModalidadeEnum.Yoga, 10));
        aulasGrupo.add(new AulaGrupo("Spinning de manhã", instrutorAna, new Tempo(2026, 10, 26, 10, 30), 45, ModalidadeEnum.Spinning, 12));
        aulasGrupo.add(new AulaGrupo("Zumba de manhã", instrutorCarla, new Tempo(2026, 10, 27, 9, 0), 60, ModalidadeEnum.Zumba, 12));
        aulasGrupo.add(new AulaGrupo("CrossFit de manhã", instrutorBruno, new Tempo(2026, 10, 27, 10, 30), 60, ModalidadeEnum.CrossFit, 8));

        // Quatro sessões de PT com os preços definidos no enunciado.
        sessoesPersonalTrainer.add(new SessaoPersonalTrainer("PT Iniciação A", instrutorBruno, new Tempo(2026, 10, 28, 9, 0), 45, NivelEnum.Iniciação));
        sessoesPersonalTrainer.add(new SessaoPersonalTrainer("PT Intermédio A", instrutorCarla, new Tempo(2026, 10, 28, 10, 0), 60, NivelEnum.Intermédio));
        sessoesPersonalTrainer.add(new SessaoPersonalTrainer("PT Avançado A", instrutorDiogo, new Tempo(2026, 10, 29, 9, 0), 60, NivelEnum.Avançado));
        sessoesPersonalTrainer.add(new SessaoPersonalTrainer("PT Iniciação B", instrutorAna, new Tempo(2026, 10, 29, 10, 30), 45, NivelEnum.Iniciação));

        // Seis marcações iniciais para demonstrar descontos e listagens.
        marcacoes.add(new Marcacao(sociosIndividual.get(0), aulasGrupo.get(0)));
        marcacoes.add(new Marcacao(sociosIndividual.get(1), aulasGrupo.get(1)));
        marcacoes.add(new Marcacao(sociosIndividual.get(2), aulasGrupo.get(2)));
        marcacoes.add(new Marcacao(sociosEmpresa.get(0), aulasGrupo.get(3)));
        marcacoes.add(new Marcacao(sociosEmpresa.get(1), sessoesPersonalTrainer.get(0)));
        marcacoes.add(new Marcacao(sociosEmpresa.get(2), sessoesPersonalTrainer.get(1)));
    }

    /**
     * Lê um texto e verifica se está preenchido e se corresponde ao formato indicado.
     *
     * @param mensagem mensagem apresentada ao utilizador
     * @param regex formato que o texto deve cumprir, ou null
     * @return texto introduzido pelo utilizador
     */
    private String lerTexto(String mensagem, String regex) {
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
                    System.out.println("O texto não está no formato correto. Tente novamente.");
                }
            } else {
                System.out.println("O texto não pode estar vazio. Tente novamente.");
            }
        }
    }

    /**
     * Lê um número inteiro e verifica se respeita o valor mínimo.
     *
     * @param mensagem mensagem apresentada ao utilizador
     * @param minimo valor mínimo permitido
     * @return número inteiro introduzido
     */
    private int lerInteiro(String mensagem, int minimo) {
        while (true) {
            System.out.println(mensagem);

            String entrada = scan.nextLine().trim();

            try {
                int valor = Integer.parseInt(entrada);

                if (valor >= minimo) {
                    return valor;
                }

                System.out.println("O valor mínimo permitido é " + minimo + ". Tente novamente.");

            } catch (NumberFormatException e) {
                System.out.println("Insira um número inteiro válido. Tente novamente.");
            }
        }
    }

    /**
     * Lê uma data e hora e verifica se os valores são válidos.
     *
     * @return data e hora introduzidas
     */
    private Tempo lerData() {
        while (true) {
            System.out.println("Insira a data (YYYY-MM-DD HH:mm):");

            String raw = scan.nextLine().trim();

            if (!raw.matches("[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}")) {
                System.out.println("Formato inválido. Exemplo: 2026-10-19 14:30. Tente novamente.");
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
     * @return instrutor escolhido, ou null se não existirem instrutores
     */
    private Instrutor selecionarInstrutor() {

        if (instrutores.isEmpty()) {
            System.err.println("Não existem instrutores registados.");
            return null;
        }

        while (true) {
            System.out.println("Lista de Instrutores:");

            for (int i = 0; i < instrutores.size(); i++) {
                System.out.println(i + " - " + instrutores.get(i).getNome());
            }

            int escolha = lerInteiro("Escolha um Instrutor:", 0);

            if (escolha < instrutores.size()) {
                return instrutores.get(escolha);
            }

            System.out.println("Escolha um instrutor válido.");
        }
    }

    /**
     * Permite escolher um sócio individual da lista disponível.
     *
     * @return sócio escolhido, ou null se a lista estiver vazia
     */
    private SocioIndividual selecionarSocioIndividual() {

        if (sociosIndividual.isEmpty()) {
            System.err.println("Não existem socios individuais registados.");
            return null;
        }

        while (true) {
            System.out.println("Lista de Sócios Individuais:");

            for (int i = 0; i < sociosIndividual.size(); i++) {
                System.out.println(i + " - " + sociosIndividual.get(i).getNome());
            }

            int escolha = lerInteiro("Escolha um Sócio Individual:", 0);

            if (escolha < sociosIndividual.size()) {
                return sociosIndividual.get(escolha);
            }

            System.out.println("Escolha um sócio válido.");
        }
    }

    /**
     * Permite escolher um sócio empresa da lista disponível.
     *
     * @return sócio escolhido, ou null se a lista estiver vazia
     */
    private SocioEmpresa selecionarSocioEmpresa() {

        if (sociosEmpresa.isEmpty()) {
            System.err.println("Não existem socios empresa registados.");
            return null;
        }

        while (true) {
            System.out.println("Lista de Sócios Empresa:");

            for (int i = 0; i < sociosEmpresa.size(); i++) {
                System.out.println(i + " - " + sociosEmpresa.get(i).getNome());
            }

            int escolha = lerInteiro("Escolha um Sócio Empresa:", 0);

            if (escolha < sociosEmpresa.size()) {
                return sociosEmpresa.get(escolha);
            }

            System.out.println("Escolha um sócio válido.");
        }
    }

    /**
     * Permite escolher o tipo de sócio e selecionar um sócio registado.
     *
     * @return sócio escolhido, ou null se o utilizador voltar atrás
     */
    private Socio selecionarSocio() {

        while (true) {
            System.out.println("1- Sócio Individual");
            System.out.println("2- Socio Empresa");
            System.out.println("3- Back");

            int choice = lerInteiro("Escolha", 1);

            switch (choice) {
                case 1: {
                    SocioIndividual socioIndividual = selecionarSocioIndividual();
                    if (socioIndividual != null) {
                        return socioIndividual;
                    }
                    continue;
                }

                case 2: {
                    SocioEmpresa socioEmpresa = selecionarSocioEmpresa();
                    if (socioEmpresa != null) {
                        return socioEmpresa;
                    }
                    continue;
                }

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
     * @return modalidade escolhida
     */
    private ModalidadeEnum selecionarModalidade() {
        while (true) {
            System.out.println("Lista de Modalidades:");

            ModalidadeEnum values[] = ModalidadeEnum.values();

            for (int i = 0; i < values.length; i++) {
                System.out.println(i + " - " + values[i]);
            }

            int choice = lerInteiro("Escolha uma modalidade:", 0);

            if (choice >= 0 && choice < values.length) {
                return values[choice];
            }
            System.out.println("Escolha inválida. Selecione um dos índices apresentados.");
        }
    }

    /**
     * Apresenta os níveis disponíveis e permite escolher um.
     *
     * @return nível escolhido
     */
    private NivelEnum selecionarNivel() {
        while (true) {
            System.out.println("Lista de Niveis:");

            NivelEnum values[] = NivelEnum.values();

            for (int i = 0; i < values.length; i++) {
                System.out.println(i + " - " + values[i]);
            }

            int choice = lerInteiro("Escolha um Nivel: ", 0);

            if (choice >= 0 && choice < values.length) {
                return values[choice];
            }
            System.out.println("Escolha inválida. Selecione um dos índices apresentados.");
        }
    }

    /**
     * Permite escolher uma aula de grupo da lista disponível.
     *
     * @return aula escolhida, ou null se a lista estiver vazia ou cheia
     */
    private AulaGrupo selecionarAulaGrupo() {

        if (aulasGrupo.isEmpty()) {
            System.err.println("Não existem aulas de grupo registadas.");
            return null;
        }

        while (true) {
            System.out.println("Lista de Aulas de Grupo:");

            for (int i = 0; i < aulasGrupo.size(); i++) {
                System.out.println(i + " - " + aulasGrupo.get(i).getNome());
            }

            int escolha = lerInteiro("Escolha uma Aula de Grupo:", 0);

            if (escolha < aulasGrupo.size()) {
                if (!isAGFull(aulasGrupo.get(escolha))) {
                    return aulasGrupo.get(escolha);
                } else {
                    System.err.println("Aula cheia, escolha outra");
                    return null;
                }
            } else {
                System.err.println("Escolha uma aula válida.");
            }
        }
    }

    /**
     * Permite escolher uma sessão de Personal Training da lista disponível.
     *
     * @return sessão escolhida, ou null se a lista estiver vazia ou cheia
     */
    private SessaoPersonalTrainer selecionarSessaoPT() {

        if (sessoesPersonalTrainer.isEmpty()) {
            System.err.println("Não existem sessões de PT registadas.");
            return null;
        }

        while (true) {
            System.out.println("Lista de Sessões de Personal Training:");

            for (int i = 0; i < sessoesPersonalTrainer.size(); i++) {
                System.out.println(i + " - " + sessoesPersonalTrainer.get(i).getNome());
            }

            int escolha = lerInteiro("Escolha uma Sessão de Personal Training:", 0);

            if (escolha < sessoesPersonalTrainer.size()) {
                if (!isSPTFull(sessoesPersonalTrainer.get(escolha))) {
                    return sessoesPersonalTrainer.get(escolha);
                } else {
                    System.err.println("Sessão cheia, escolha outra");
                    return null;
                }
            } else {
                System.err.println("Escolha uma sessão válida.");
            }

            System.out.println("Escolha uma sessão válida.");
        }
    }

    /**
     * Permite escolher o tipo de atividade e selecionar uma atividade registada.
     *
     * @return atividade escolhida, ou null se o utilizador voltar atrás
     */
    private Atividade selecionarAtividade() {

        while (true) {
            System.out.println("1- Aula de Grupo");
            System.out.println("2- Sessão Personal Training");
            System.out.println("3- Back");

            int choice = lerInteiro("Escolha", 1);

            switch (choice) {
                case 1:
                    Atividade aG = selecionarAulaGrupo();
                    if (aG != null) {
                        return aG;
                    }
                    continue;

                case 2:
                    Atividade sPT = selecionarSessaoPT();
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
     * Verifica se o sócio já tem uma marcação que coincide com o horário da atividade escolhida.
     *
     * @param socio sócio que pretende fazer a marcação
     * @param tempo data e hora da nova atividade
     * @param duracao duração da nova atividade em minutos
     * @return true se não existir sobreposição, false caso contrário
     */
    private boolean verificarSobrePosicoes(Socio socio, Tempo tempo, int duracao) {

        for (Marcacao marcacao : marcacoes) {
            if (marcacao.getSocio().equals(socio)) {

                Tempo dataExistente = marcacao.getAtividade().getDate();

                if (dataExistente.getSimpleDate().equals(tempo.getSimpleDate())) {

                    int inicioExistente = dataExistente.getMinutes();

                    int fimExistente = inicioExistente + marcacao.getAtividade().getDuracao();

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
     * Verifica se o instrutor já tem uma atividade que coincide com o horário da atividade escolhida.
     *
     * @param instrutor instrutor que pretende lecionar a atividade
     * @param tempo data e hora da nova atividade
     * @param duracao duração da nova atividade em minutos
     * @return true se não existir sobreposição, false caso contrário
     */
    private boolean verificarSobrePosicoesInstrutor(Instrutor instrutor, Tempo tempo, int duracao) {

        ArrayList<Atividade> atividades = new ArrayList<>();
        atividades.addAll(aulasGrupo);
        atividades.addAll(sessoesPersonalTrainer);

        for (Atividade atividade : atividades) {
            if (atividade.getInstrutor().equals(instrutor)) {

                Tempo dataExistente = atividade.getDate();

                // Se no mesmo dia
                if (dataExistente.getSimpleDate().equals(tempo.getSimpleDate())) {

                    int inicioExistente = dataExistente.getMinutes();

                    int fimExistente = inicioExistente + atividade.getDuracao();

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
     * Verifica se a aula já está cheia.
     *
     * @param aulaGrupo aula que queremos verificar
     * @return true se estiver cheia, false se ainda houver vagas
     */
    private boolean isAGFull(AulaGrupo aulaGrupo) {

        int totalMarcacoes = 0;

        for (Marcacao marcacao : marcacoes) {
            if (marcacao.getAtividade() == aulaGrupo) {
                totalMarcacoes++;
            }
        }

        return totalMarcacoes >= aulaGrupo.getMaxCap();
    }

    /**
     * Verifica se a sessão de PT já está cheia.
     *
     * @param sessaoPersonalTrainer sessão que queremos verificar
     * @return true se estiver cheia, false se ainda houver vaga
     */
    private boolean isSPTFull(SessaoPersonalTrainer sessaoPersonalTrainer) {

        for (Marcacao marcacao : marcacoes) {
            if (marcacao.getAtividade() == sessaoPersonalTrainer) {
                return true;
            }
        }

        return false;
    }

    // Registos

    /**
     * Recolhe os dados necessários e regista um sócio individual.
     *
     * @return true se o registo foi efetuado com sucesso
     */
    public boolean registarSocioIndividual() {
        // Recolher dados
        String nome = lerTexto("Insira o nome: ", null);

        int id = idCount;
        idCount += 1;

        String email = lerTexto(
                "Insira o email (ex: nome@gmail.com): ",
                "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

        int anoNascimento;
        do {
            anoNascimento = lerInteiro("Insira o ano de nascimento: ", 1900);
            if (anoNascimento > Year.now().getValue()) {
                System.out.println("O ano de nascimento não pode ser futuro.");
            }
        } while (anoNascimento > Year.now().getValue());

        // Registar sócio individual
        sociosIndividual.add(new SocioIndividual(nome, id, email, anoNascimento));
        return true;
    }

    /**
     * Recolhe os dados necessários e regista um sócio empresa.
     *
     * @return true se o registo foi efetuado com sucesso
     */
    public boolean registarSocioEmpresa() {
        // Recolher dados
        String nome = lerTexto("Insira o nome: ", null);

        int id = idCount;
        idCount += 1;

        String nif = lerTexto("Insira o NIF: ", "[0-9]{9}");

        String email = lerTexto(
                "Insira o email (ex: nome@gmail.com): ",
                "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

        // Registar sócio empresa
        sociosEmpresa.add(new SocioEmpresa(nome, id, email, nif));
        return true;
    }

    /**
     * Recolhe os dados necessários e regista um instrutor.
     *
     * @return true se o registo foi efetuado com sucesso
     */
    public boolean registarInstrutor() {
        // Receber dados
        String nome = lerTexto("Insira o Nome:", null);

        String genero = lerTexto("Insira o Género", null);

        String formacao = lerTexto("Insira a Formação:", null);

        // Criar objeto instrutor
        instrutores.add(new Instrutor(nome, genero, formacao));
        return true;
    }

    /**
     * Recolhe os dados e regista uma nova aula de grupo.
     *
     * @return true se registada com sucesso, false caso contrário (ex: instrutor indisponível)
     */
    public boolean registarAulaDeGrupo() {

        String nome = lerTexto("Insira o nome da Aula:", null);

        Tempo data = lerData();

        int duracao = lerInteiro("Insira a duração (minutos):", 1);

        Instrutor instrutor = selecionarInstrutor();

        if (instrutor == null) {
            return false;
        }

        if (!verificarSobrePosicoesInstrutor(instrutor, data, duracao)) {
            System.err.println("Escolha outro instrutor.");
            return false;
        }

        ModalidadeEnum modalidade = selecionarModalidade();

        int maxCap = lerInteiro("Insira a capacidade máxima: ", 1);

        aulasGrupo.add(new AulaGrupo(
                nome, instrutor, data, duracao, modalidade, maxCap));

        return true;
    }

    /**
     * Recolhe os dados e regista uma sessão de Personal Training.
     *
     * @return true se registada com sucesso, false caso contrário (ex: instrutor indisponível)
     */
    public boolean registarSessaoPersonal() {

        String nome = lerTexto("Insira o nome da Sessão:", null);

        Tempo data = lerData();

        int duracao = lerInteiro("Insira a duração (minutos):", 1);

        Instrutor instrutor = selecionarInstrutor();

        if (instrutor == null) {
            return false;
        }

        if (!verificarSobrePosicoesInstrutor(instrutor, data, duracao)) {
            System.err.println("Escolha outro instrutor.");
            return false;
        }

        NivelEnum nivel = selecionarNivel();

        sessoesPersonalTrainer.add(new SessaoPersonalTrainer(
                nome, instrutor, data, duracao, nivel));

        return true;
    }

    /**
     * Mostra os sócios individuais e os sócios empresa registados.
     */
    public void listarSocios() {

        if (sociosIndividual.isEmpty() && sociosEmpresa.isEmpty()) {
            System.err.println("Não existem sócios registados");
            return;
        }

        if (!sociosIndividual.isEmpty()) {
            System.out.println("\nSócios Individuais\n");

            for (int i = 0; i < sociosIndividual.size(); i++) {
                sociosIndividual.get(i).showData();
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
     */
    public void listarAtividades() {

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
     * @return true se marcação criada com sucesso, false se erro durante a marcação
     */
    public boolean criarMarcacao() {

        // Selecionar sócio
        System.out.println("Escolha um sócio");

        Socio socio = selecionarSocio();

        // Verificar se foi selecionado um sócio
        if (socio == null) {
            System.err.println("Erro: nenhum sócio selecionado.");
            return false;
        }

        // Selecionar atividade e verificar sobreposições
        Atividade atividade;

        while (true) {
            System.out.println("Escolha uma atividade");

            atividade = selecionarAtividade();

            if (atividade == null) {
                return false;
            }

            boolean semSobreposicao = verificarSobrePosicoes(socio, atividade.getDate(), atividade.getDuracao());

            if (semSobreposicao) {
                break;
            }

            System.err.println("Escolha outra atividade ou horário.");
        }

        marcacoes.add(new Marcacao(socio, atividade));
        return true;
    }

    /**
     * Mostra todas as marcações existentes e o respetivo total faturado.
     */
    public void listarMarcacao() {
        if (marcacoes.isEmpty()) {
            System.err.println("Não Existe Marcações");
            return;
        }

        double totalFaturado = 0.0;
        for (Marcacao marcacao : marcacoes) {
            if (marcacao == null) {
                continue;
            }

            System.out.print(marcacao);
            totalFaturado += marcacao.getCustoFinal();
        }
        System.out.printf("Total faturado: %.2f €%n%n", totalFaturado);
    }

    /**
     * Apresenta o número de sócios e atividades registados.
     */
    public void resumirAtivadade() {

        System.out.println("\nSócios Individuais: " + sociosIndividual.size());
        System.out.println("Sócios Empresa: " + sociosEmpresa.size());
        System.out.println("Aulas de Grupo: " + aulasGrupo.size());
        System.out.println(
                "Sessões de Personal Training: "
                        + sessoesPersonalTrainer.size() + '\n');
    }

    /**
     * Identifica e apresenta a atividade com mais marcações.
     */
    public void listarAtividadePopular() {
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
     */
    public void mostrarValorSocio() {

        int id = lerInteiro("Insira o ID do sócio", 0);

        double valorTotal = 0;
        double valorPoupado = 0;

        if (id < idCount) {
            for (Marcacao marcacao : marcacoes) {
                if (marcacao.getSocio().getId() == id) {
                    valorTotal += marcacao.getCustoFinal();
                    valorPoupado += marcacao.getValorPoupado();
                }
            }

            System.out.printf("%nValor gasto: %.2f €%nValor poupado: %.2f €%n%n",
                    valorTotal, valorPoupado);
        } else {
            System.err.println("\nID invalido\n");
        }
    }

    /**
     * Encerra o scanner.
     */
    public void close() {
        scan.close();
    }
}