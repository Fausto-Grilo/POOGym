import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.Year;

/**
 * Gere o menu principal e as operações do sistema de gestão
 * de sócios, atividades e marcações.
 *
 * @author Fausto Henriques
 * @author Rodrigo Correia
 */


public class Main {

    /**
     * Lê um número inteiro e verifica se respeita o valor mínimo.
     *
     * @param scan scanner
     * @param mensagem mensagem apresentada ao utilizador
     * @param minimo valor mínimo permitido
     * @return número inteiro introduzido
     */
    private static int lerInteiro(Scanner scan, String mensagem, int minimo) {
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
     * Inicia o programa, prepara as listas e apresenta o menu principal.
     *
     * @param args argumentos da linha de comandos (não utilizados)
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Ginasio gym = new Ginasio();

        // Menu principal
        while (true) {
            System.out.println("1 - Registar um novo sócio individual");
            System.out.println("2 - Registar um novo sócio empresa");
            System.out.println("3 - Registar um novo instrutor");
            System.out.println("4 - Registar uma nova atividade");
            System.out.println("5 - Listar sócios");
            System.out.println("6 - Listar atividades");
            System.out.println("7 - Criar marcação");
            System.out.println("8 - Listar marcações");
            System.out.println("9 - Resumo de sócios e atividades");
            System.out.println("10 - Mostrar atividade mais popular");
            System.out.println("11 - Mostrar valores de um sócio");
            System.out.println("12 - Sair");

            int choice = lerInteiro(scan, "Escolha: ", 1);

            switch (choice) {
                case 1:
                    gym.registar_socio_individual();
                    break;

                case 2:
                    gym.registar_socio_empresa();
                    break;

                case 3:
                    gym.registar_instrutor();
                    break;

                case 4:
                    System.out.println("1 - Registar aula de grupo");
                    System.out.println("2 - Registar sessão personal trainer");

                    int c = lerInteiro(scan, "Escolha: ", 1);

                    switch (c) {
                        case 1:
                            gym.registar_aula_de_grupo();
                            break;

                        case 2:
                            gym.registar_sessao_personal();
                            break;

                        default:
                            break;
                    }
                    break;

                case 5:
                    gym.listar_socios();
                    break;

                case 6:
                    gym.listar_ativadades();
                    break;

                case 7:
                    gym.criar_marcacao();
                    break;

                case 8:
                    gym.listar_marcacao();
                    break;

                case 9:
                    gym.resumir_ativadade();
                    break;

                case 10:
                    gym.listar_atividade_popular();
                    break;

                case 11:
                    gym.mostrar_valor_socio();
                    break;

                case 12:
                    gym.close();
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

