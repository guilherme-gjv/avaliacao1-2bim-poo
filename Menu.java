import java.util.Scanner;

public class Menu {
    private int i, j, w, contador = -1;
    private Scanner ler1 = new Scanner(System.in);
    private Scanner ler2 = new Scanner(System.in);
    private Livro livro[];
    private Advogado advogado[];
    private Emprestimo emprestimo[] = new Emprestimo[1000];
    private String dado, cpf;

    /*
     * Construtor para informar quantos livros/advogados vão ter no sistema e exibir
     * o menu do gerenciamento.
     */
    public Menu() {
        System.out.println("\nInforme a quantidade de livros que deseja cadastrar: ");
        i = ler1.nextInt();
        livro = new Livro[i];
        for (int i = 0; i < livro.length; i++) {
            livro[i] = new Livro();
        }
        System.out.println("\nInforme a quantidade de advogados que deseja cadastrar: ");
        j = ler2.nextInt();
        advogado = new Advogado[j];
        for (int i = 0; i < advogado.length; i++) {
            advogado[i] = new Advogado();
        }
        int cont = 1;
        do {
            exibirMenu();
        } while (cont != 0);
    }

    // Método para exibir o menu
    private void exibirMenu() {
        int escolha;
        System.out.println("\n-----Escritório Advogados S.A.------\n");
        System.out.println("> Menu de Gerenciamento da Empresa\nDigite...");
        System.out.println("1. Exibir Advogados, Livros e Empréstimos.");
        System.out.println("2. Solicitar empréstimo de um livro");
        System.out.println("3. Devolver livro");
        System.out.println("4. Trocar Advogado de Departamento");
        System.out.println("5. Exibir livros emprestados de uma determinada área.");
        System.out.println("0. Sair.");
        escolha = ler1.nextInt();

        switch (escolha) {
            case 1:
                exibirAdLiEm();
                break;

            case 2:
                emprestimo();
                break;

            case 3:
                devolver();
                break;

            case 4:
                trocarDepAdvogado();
                break;

            case 5:
                exibirLivrosEmprestados();
                break;

            case 0:
                System.out.println("-----SAINDO DO SISTEMA-----");
                System.exit(1);
                break;
        }

    }

    // Método para exibir Advogados, Livros, Empréstimos
    private void exibirAdLiEm() {
        for (int i = 0; i < advogado.length; i++) {
            advogado[i].exibir();
        }
        for (int i = 0; i < livro.length; i++) {
            livro[i].exibir();

        }
        if (emprestimo != null) {
            for (int i = 0; i < emprestimo.length; i++) {
                if (emprestimo[i] != null) {
                    emprestimo[i].exibir();
                } else {
                    break;
                }

            }
        } else {
            System.out.println("--Não há empréstimos!--");
        }

    }

    // Método para solicitar emprestimo de um livro
    private void emprestimo() {
        Scanner ler = new Scanner(System.in);
        contador++;
        System.out.println("Informe o código ou titulo do livro a solicitar empréstimo: ");
        dado = ler.nextLine();
        for (int j = 0; j < livro.length; j++) {

            if ((dado.equalsIgnoreCase(livro[j].getCodigo()) || dado.equalsIgnoreCase(livro[j].getTitulo()))
                    && livro[j].getDisponivel()) {
                System.out.println("Informe o cpf do advogado a solicitar empréstimo: ");
                cpf = ler.nextLine();

                for (int k = 0; k < advogado.length; k++) {
                    if (cpf.equalsIgnoreCase(advogado[k].getCpf())) {
                        for (w = 0; w < emprestimo.length; w++) {
                            if (emprestimo[w] == null) {
                                emprestimo[w] = new Emprestimo(advogado[k], livro[j]);
                                break;
                            }
                        }
                    }
                    if (emprestimo[w] != null) {
                        break;
                    }
                }
                if (emprestimo[w] != null) {
                    break;
                }
            }
            if ((dado.equalsIgnoreCase(livro[j].getCodigo()) || dado.equalsIgnoreCase(livro[j].getTitulo()))
                    && !livro[j].getDisponivel()) {
                System.out.println("\nErro: livro não disponível!");
                break;
            }
        }
        if (emprestimo[contador] == null) {
            System.out.println("\nErro ao solicitar empréstimo! ");
        }
    }

    // Método para devolver um livro.
    private void devolver() {
        Scanner ler = new Scanner(System.in);
        System.out.println("\nInforme o código ou titulo do livro a ser devolvido: ");
        dado = ler.nextLine();
        for (int j = 0; j < livro.length; j++) {
            if ((dado.equalsIgnoreCase(livro[j].getCodigo()) || dado.equalsIgnoreCase(livro[j].getTitulo()))
                    && !livro[j].getDisponivel()) {
                emprestimo[j].devolucao(livro[j]);
                break;
            }
            if ((dado.equalsIgnoreCase(livro[j].getCodigo()) || dado.equalsIgnoreCase(livro[j].getTitulo()))
                    && livro[j].getDisponivel()) {
                System.out.println("\nError: Não foi possível realizar a devolução!\n");
            }
        }

    }

    // Método para trocar advogado de departamento
    private void trocarDepAdvogado() {
        Scanner ler = new Scanner(System.in);
        System.out.println("\nInforme o nome do advogado a ser transferido de departamento: ");
        String nome = ler.nextLine();
        for (int i = 0; i < advogado.length; i++) {
            if (nome.equalsIgnoreCase(advogado[i].getNome())) {
                advogado[i].mudarDepartamento(advogado[i].getNomeDep());
                break;
            }
        }
    }

    // Método para exibir livros emprestados de uma determinada área.
    private void exibirLivrosEmprestados() {
        Scanner ler = new Scanner(System.in);
        System.out.println("\nInforme o nome da área na qual se deseja saber os livros que foram emprestados: ");
        String area = ler.nextLine();
        for (int i = 0; i < livro.length; i++) {
            if (area.equalsIgnoreCase(livro[i].getArea()) && livro[i].getDisponivel() == false) {
                System.out.println("\n--" + livro[i].getTitulo() + "--");
            }
        }
    }
}
