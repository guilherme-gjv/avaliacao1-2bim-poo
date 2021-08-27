import java.util.Scanner;

public class Menu {
    int i, j;
    Scanner ler1 = new Scanner(System.in);
    Scanner ler2 = new Scanner(System.in);
    Livro livro[];
    Advogado advogado[];
    Emprestimo emprestimo[] = new Emprestimo[1000];
    String dado, cpf;
    int contador = -1;

    Menu() {
        // o ciclo só para quando a variavel escolha de exibirMenu() for 0
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

    void exibirMenu() {
        int escolha;
        System.out.println("\n-----Escritório Advogados S.A.------\n");
        System.out.println(">Gerenciamento de Livros\nDigite...");
        System.out.println("1. Exibir Advogados, Livros e Empréstimos.");
        System.out.println("2. Solicitar empréstimo");
        System.out.println("3. Devolver");
        System.out.println("4. Trocar Departamento de um Advogado");
        System.out.println("5. Exibir livros emprestados.");
        System.out.println("0. Sair.");

        escolha = ler1.nextInt();
        // provisorio

        switch (escolha) {
            case 1:
                exibirAdLiEm();
                break;

            case 2:
                emprestimo2();
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

    // Exibir Advogados, Livros, Empréstimos
    void exibirAdLiEm() {
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

    int w;

    void emprestimo2() {
        Scanner ler = new Scanner(System.in);

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

            }
            if (!livro[j].getDisponivel()) {
                System.out.println("\nO livro não está disponível para empréstimos\n");
            }
            if (!dado.equalsIgnoreCase(livro[j].getCodigo()) || !dado.equalsIgnoreCase(livro[j].getTitulo())) {
                System.out.println("\nError: Não foi possível realizar o empréstimo do livro!\n");
            }
            if (emprestimo[w] != null) {
                break;
            }
        }
    }

    void devolver() {
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

    // trocar o departamento do advogado
    void trocarDepAdvogado() {
        advogado[j].switchDepartamento();
    }

    // Exibir os títulos dos livros que estão emprestados de uma área específica
    // (solicitar o nome da área)
    void exibirLivrosEmprestados() {

    }
}
