import java.util.Scanner;

public class Menu {

    Scanner ler = new Scanner(System.in);
    Livro[] livro;
    Advogado[] advogado;
    int codigo_li = 0;// codigo livro
    int codigo_ad = 0;// codigo advogado
    // após cada registro, o código aumenta +1 e não pode ser repetido!

    Menu() {
        // o ciclo só para quando a variavel escolha de exibirMenu() for 0
        livro[100] = new Livro();
        advogado[30] = new Advogado();
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
        System.out.println("6. Registrar [Livros e Advogados]");
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
            case 6:
                registro();
                break;

            case 0:
                System.exit(1);
                break;
        }

    }

    // Exibir Advogados, Livros, Empréstimos
    void exibirAdLiEm() {
        System.out.println("---Advogados, Livros & Empréstimos---");
        int i;
        for (i = 0; i <= 30; i++) {
            System.out.println("Advogado n:" + i);
            advogado[i].exibir();
        }
        for (i = 0; i <= 30; i++) {
            System.out.println("Livro n:" + i);
            livro[i].exibir();
        }
        // falta o emprestimo
    }

    void emprestimo() {
        System.out.println("Qual o codigo do livro que voce quer fazer empréstimo?");
        int i = ler.nextInt();
        livro[i].emprestimo();
    }

    void devolver() {
        // se for o caso, exibir o valor a pagar
        System.out.println("Qual livro voce quer devolver?");
        int escolha=1;
        while(escolha == 1){
        int i = ler.nextInt();
        livro[i].devolucao();
        System.out.println("Deseja registrar outro? 1. Sim/ 2. Nao");
        escolha = ler.nextInt();
        }
    }

    // trocar o departamento do advogado
    void trocarDepAdvogado() {
        System.out.println("Digite o código do advogado que você\nquer trocar de Departamento");
        int i = ler.nextInt();
        advogado[i].switchDepartamento();
    }

    void registro() {
        int escolha = 1;
        while (escolha == 1) {
            System.out.println("----Registrar----\n1. Livro\n 2. Advogado");
            escolha = ler.nextInt();

            if (escolha == 1) {
                advogado[codigo_ad] = new Advogado();
                codigo_ad++;
            }
            if (escolha == 2) {
                livro[codigo_li] = new Livro();
                codigo_li++;
            }
            System.out.println("Deseja registrar outro? 1. Sim/ 2. Nao");
            escolha = ler.nextInt();
        }
    }

    // Exibir os títulos dos livros que estão emprestados de uma área específica
    // (solicitar o nome da área)
    void exibirLivrosEmprestados() {
        for (int i = 0; i <= 100; i++) {
            if (livro[i].status() == true) {
                livro[i].exibirTitulo();
            }
        }
    }
}
