import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Gere as operações do sistema de gestão de sócios, atividades e marcações.
 *
 * @author Fausto Henriques
 * @author Rodrigo Correia
 */
public class Ginasio {

    private ArrayList<Socio> socios;
    private ArrayList<Instrutor> instrutores;
    private ArrayList<Atividade> atividades;
    private ArrayList<Marcacao> marcacoes;
    private Scanner scan;
    private ReadWrite readWrite = new ReadWrite();

    /** Contador utilizado para atribuir IDs aos sócios. */
    int idCount = 0;

    int sICount = 0;
    int sECount = 0;

    int aGCount = 0;
    int sPTCount = 0;



    /**
     * Construtor da Classe
     */

    public Ginasio() {
        socios = new ArrayList<>();
        instrutores = new ArrayList<>();
        atividades = new ArrayList<>();
        marcacoes = new ArrayList<>();
        scan = new Scanner(System.in);

        System.out.println(readWrite.ler(socios,instrutores,atividades, idCount, sICount, sECount, aGCount, sPTCount));
    }

    // Lógica



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
    private Socio selecionarSocio() {

        if (socios.isEmpty()) {
            System.err.println("Não existem socios registados.");
            return null;
        }

        while (true) {
            System.out.println("Lista de Sócios:");

            for (int i = 0; i < socios.size(); i++) {
                System.out.println(i + " - " + socios.get(i).getNome());
            }

            int escolha = lerInteiro("Escolha um Sócio:", 0);

            if (escolha < socios.size()) {
                return socios.get(escolha);
            }

            System.out.println("Escolha um sócio válido.");
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
    private Atividade selecionarAtividade() {

        if (atividades.isEmpty()) {
            System.err.println("Não existem aulas de grupo registadas.");
            return null;
        }

        while (true) {
            System.out.println("Lista de Ativades:");

            for (int i = 0; i < atividades.size(); i++) {
                System.out.println(i + " - " + atividades.get(i).getNome());
            }

            int escolha = lerInteiro("Escolha uma atividade:", 0);

            if (escolha < atividades.size()) {
                if (!isFull(atividades.get(escolha))) {
                    return atividades.get(escolha);
                } else {
                    System.err.println("Atividade cheia, escolha outra");
                    return null;
                }
            } else {
                System.err.println("Escolha uma atividade válida.");
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
     * @param atividade atividade que queremos verificar
     * @return true se estiver cheia, false se ainda houver vagas
     */
    private boolean isFull(Atividade atividade) {

        if(atividade instanceof AulaGrupo) {
            int totalMarcacoes = 0;

            for (Marcacao marcacao : marcacoes) {
                if (marcacao.getAtividade() == atividade) {
                    totalMarcacoes++;
                }
            }

            return totalMarcacoes >= ((AulaGrupo) atividade).getMaxCap();
        }else if(atividade instanceof SessaoPersonalTrainer){
            for (Marcacao marcacao : marcacoes) {
                if (marcacao.getAtividade() == atividade) {
                    return true;
                }
            }

            return false;
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
        socios.add(new SocioIndividual(nome, id, email, anoNascimento));
        sICount++;
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
        socios.add(new SocioEmpresa(nome, id, email, nif));
        sECount++;
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

        atividades.add(new AulaGrupo(
                nome, instrutor, data, duracao, modalidade, maxCap));
        aGCount++;
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

        atividades.add(new SessaoPersonalTrainer(
                nome, instrutor, data, duracao, nivel));
        sPTCount++;

        return true;
    }

    /**
     * Mostra os sócios individuais e os sócios empresa registados.
     */
    public void listarSocios() {

        if (socios.isEmpty() && socios.isEmpty()) {
            System.err.println("Não existem sócios registados");
            return;
        }

        for(Socio s: socios){
            s.showData();
        }
    }

    /**
     * Mostra as aulas de grupo e as sessões de Personal Training registadas.
     */
    public void listarAtividades() {

        if (atividades.isEmpty()) {
            System.err.println("Não Existe Atividades Registadas");
            return;
        }

        System.out.println("\nAulas de Grupo\n");

        for (int i = 0; i < atividades.size(); i++) {
            atividades.get(i).showData();
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




        System.out.println("Sócios Individual: " + sICount);
        System.out.println("Sócios Empresa: " + sECount);
        System.out.println("Aulas de Grupo: " + aGCount);
        System.out.println("Sessões de Personal Training: " + sPTCount + '\n');
    }

    /**
     * Identifica e apresenta a atividade com mais marcações.
     *
     * Corrigir loop
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
        //readWrite.escrever(socios, instrutores, atividades);
    }
}