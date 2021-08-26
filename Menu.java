import java.util.Scanner;

public class Menu {

    private Scanner ler = new Scanner(System.in);
    private Livro[] livro;
    private Advogado[] advogado;
    private int codigo_li = 0;// codigo livro
    private int codigo_ad = 0;// codigo advogado
    // após cada registro, o código aumenta +1 e não pode ser repetido!

    Menu() {
        // o ciclo só para quando a variavel escolha de exibirMenu() for 0
        //livro[100] = new Livro();
        //advogado[30] = new Advogado();
        int i = 1;
        do {
            exibirMenu();
        } while (i == 1);
    }

    public void exibirMenu() {
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
                System.out.println("1. Ver todos os livros emprestados.\n2. Escolher uma área específica.");
                escolha = ler.nextInt();
                switch (escolha) {
                    case 1:
                        exibirLivrosEmprestados();
                        break;
                    case 2:
                        System.out.println("Qual área você deseja?");
                        String selectedArea = ler.nextLine();
                        exibirLivrosEmprestados(selectedArea);
                        break;
                }
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
    private void exibirAdLiEm() {
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

    private void emprestimo() {
        System.out.println("Qual o codigo do livro que voce quer fazer empréstimo?");
        int i = ler.nextInt();
        livro[i].emprestimo();
    }

    private void devolver() {
        // se for o caso, exibir o valor a pagar
        System.out.println("Qual livro voce quer devolver?");
        int escolha = 1;
        while (escolha == 1) {
            int i = ler.nextInt();
            livro[i].devolucao();
            System.out.println("Deseja registrar outro? 1. Sim/ 2. Não");
            escolha = ler.nextInt();
        }
    }

    // trocar o departamento do advogado
    private void trocarDepAdvogado() {
        System.out.println("Digite o código do advogado que você\nquer trocar de Departamento");
        int i = ler.nextInt();
        advogado[i].switchDepartamento();
    }

    private void registro() {
        int escolha = 1;
        while (escolha == 1) {
            System.out.println("----Registrar----\n1. Advogado\n2. Livro");
            escolha = ler.nextInt();

            switch(escolha ) {
            case 1:
                advogado[codigo_ad] = new Advogado();
                codigo_ad++;
            break;
            case 2:
                livro[codigo_li] = new Livro();
                codigo_li++;
                break;
            }
            System.out.println("Deseja registrar outro? 1. Sim/ 2. Nao");
            escolha = ler.nextInt();
        }
    }

    // Exibir os títulos dos livros que estão emprestados de uma área específica
    // (solicitar o nome da área)
    private void exibirLivrosEmprestados(String selectedArea) {

        for (int i = 0; i <= 100; i++) {
            if (livro[i].getArea().equalsIgnoreCase(selectedArea)) {
                if (livro[i].status() == true) {
                    livro[i].exibirTitulo();
                }
            }
        }
    }

    private void exibirLivrosEmprestados() {

        for (int i = 0; i <= 100; i++) {
            if (livro[i].status() == false) {
                livro[i].exibirTitulo();
            }

        }
    }

}
