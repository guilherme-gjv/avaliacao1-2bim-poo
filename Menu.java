import java.util.Scanner;

public class Menu {

    Scanner ler = new Scanner(System.in);

    Menu() {
        //o ciclo só para quando a variavel escolha de exibirMenu() for 0
        int i = 1;
        do {
            exibirMenu();
        } while (i == 1);
    }

    void exibirMenu() {
        int escolha;
        System.out.println("\tIFAL \n---Instituição Federal de Advocacia Legal----");
        System.out.println(">Gerenciamento de Livros\nDigite...");
        System.out.println("1. Exibir Advogados, Livros e Empréstimos.");
        System.out.println("2. Empréstimo");
        System.out.println("3. Devolver");
        System.out.println("4. Trocar Departamento de um Advogado");
        System.out.println("5. Exibir livros emprestados.");
        System.out.println("0. Sair.");

        escolha = ler.nextInt();
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

    }

    void emprestimo() {

    }

    void devolver() {
        // se for o caso, exibir o valor a pagar
    }

    // trocar o departamento do advogado
    void trocarDepAdvogado() {

    }

    // Exibir os títulos dos livros que estão emprestados de uma área específica
    // (solicitar o nome da área)
    void exibirLivrosEmprestados() {

    }
}
