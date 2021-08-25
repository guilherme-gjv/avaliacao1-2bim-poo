import java.util.Scanner;

public class Menu {
    int i, j;
    Scanner ler1 = new Scanner(System.in);
    Scanner ler2 = new Scanner(System.in);
    Livro livro[];
    Advogado advogado[];
    String dado;

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
            livro[i].exibirEmprestimo();
        }

    }

    void emprestimo() {
        Scanner ler = new Scanner(System.in);
        for (int i = 0; i < livro.length; i++) {

            System.out.println("Informe o código ou titulo do livro a solicitar empréstimo: ");
            dado = ler.nextLine();

            if (dado.equalsIgnoreCase(livro[i].getCodigo())
                    || dado.equalsIgnoreCase(livro[i].getTitulo()) && livro[i].getDisponivel() == true) {
                livro[i].emprestimo();
                break;
            } else if (!livro[i].getDisponivel()) {
                System.out.println("\nErro: LIVRO NÃO DISPONÍVEL!\n");
            }
        }
    }

    void devolver() {
        // se for o caso, exibir o valor a pagar
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
