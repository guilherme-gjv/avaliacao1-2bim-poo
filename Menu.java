import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private int j;
    private Scanner ler = new Scanner(System.in);
    private ArrayList<Emprestimo> emprestimo = new ArrayList<Emprestimo>();
    private ArrayList<Advogado> advogado = new ArrayList<Advogado>();
    private ArrayList<Livro> livro = new ArrayList<Livro>();
    private String dado, cpf;

    /*
     * Construtor para informar quantos livros/advogados vão ter no sistema e exibir
     * o menu do gerenciamento.
     */
    public Menu() {
        int cont = 1;
        do {
            exibirMenu();
        } while (cont != 0);
    }

    // Método para exibir o menu
    private void exibirMenu() {
        int escolha;
        System.out.println("\n-----IFAL - Instituição Federal de Advocacia Legal-----\n");
        System.out.println("> Menu de Gerenciamento da Empresa\nDigite...");
        System.out.println("1. Exibir Advogados, Livros e Empréstimos.");
        System.out.println("2. Solicitar empréstimo de um livro.");
        System.out.println("3. Devolver livro.");
        System.out.println("4. Trocar Advogado de Departamento.");
        System.out.println("5. Exibir livros emprestados de uma determinada área.");
        System.out.println("6. Registrar Advogado.");
        System.out.println("7. Registrar Livro.");
        System.out.println("0. Sair.");
        escolha = ler.nextInt();
        System.out.println("\n------------------------------------------");

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
                cadastrarAdvogado();
                break;

            case 7:
                cadastrarLivro();
                break;
            case 0:
                System.out.println("-----SAINDO DO SISTEMA-----");
                System.exit(1);
                break;
        }

    }

    // Método para exibir Advogados, Livros, Empréstimos
    private void exibirAdLiEm() {
        if (advogado.isEmpty()) {
            System.out.println("-------------------------------");
            System.out.println("--Não há advogados cadastrados--");
            System.out.println("-------------------------------\n");
        } else {
            for (int i = 0; i < advogado.size(); i++) {
                advogado.get(i).exibir();
            }
        }

        if (livro.isEmpty()) {
            System.out.println("-------------------------------");
            System.out.println("--Não há livros cadastrados--");
            System.out.println("-------------------------------\n");
        } else {
            for (int i = 0; i < livro.size(); i++) {
                livro.get(i).exibir();
            }
        }

        if (emprestimo.isEmpty()) {
            System.out.println("-------------------------------");
            System.out.println("--Não há empréstimos--");
            System.out.println("-------------------------------\n");
        } else {
            for (int i = 0; i < emprestimo.size(); i++) {
                emprestimo.get(i).exibir();
            }
        }
    }

    // Método para solicitar emprestimo de um livro
    private void emprestimo() {
        Scanner ler = new Scanner(System.in);

        if (advogado.isEmpty()) {
            System.out.println(
                    "\nError: não é possível fazer empréstimo. Motivo: Não há advogados cadastrados no sistema!");
        }
        if (livro.isEmpty()) {
            System.out
                    .println("\nError: não é possível fazer empréstimo. Motivo: Não há livros cadastrados no sistema!");
        } else {
            System.out.println("Informe o código ou titulo do livro a solicitar empréstimo: ");
            dado = ler.nextLine();
            for (int j = 0; j < livro.size(); j++) {

                if ((dado.equalsIgnoreCase(livro.get(j).getCodigo()) || dado.equalsIgnoreCase(livro.get(j).getTitulo()))
                        && livro.get(j).getDisponivel()) {
                    System.out.println("Informe o cpf do advogado a solicitar empréstimo: ");
                    cpf = ler.nextLine();

                    for (int k = 0; k < advogado.size(); k++) {
                        if (cpf.equalsIgnoreCase(advogado.get(k).getCpf())) {
                            emprestimo.add(new Emprestimo(advogado.get(j), livro.get(j)));
                        }
                    }
                }
            }
        }

    }

    // Método para devolver um livro.
    private void devolver() {
        if (emprestimo.isEmpty()) {
            System.out.println("\nError: não é possível realizar devolução. Motivo: Não foi feito nenhum empréstimo!");
        } else {
            Scanner ler = new Scanner(System.in);
            System.out.println("\nInforme o código ou titulo do livro a ser devolvido: ");
            dado = ler.nextLine();
            for (int j = 0; j < livro.size(); j++) {
                if ((dado.equalsIgnoreCase(livro.get(j).getCodigo()) || dado.equalsIgnoreCase(livro.get(j).getTitulo()))
                        && !livro.get(j).getDisponivel()) {
                    for (int i = 0; i < emprestimo.size(); i++) {
                        emprestimo.get(i).devolucao(livro.get(j));
                        if (emprestimo.get(i).getDevolvido() == true) {
                            emprestimo.remove(i);
                        }
                    }
                    break;
                }
            }
        }

    }

    // Método para cadastrar um livro
    private void cadastrarLivro() {
        livro.add(new Livro());
    }

    // Método para cadastrar um advogado
    private void cadastrarAdvogado() {
        advogado.add(new Advogado());
    }

    // Método para trocar advogado de departamento
    private void trocarDepAdvogado() {
        if (advogado.isEmpty()) {
            System.out.println(
                    "Error: Não é possível mudar advogado de departamento. Motivo: Não há advogados cadastrados no sistema!");
        } else {
            Scanner ler = new Scanner(System.in);
            System.out.println("\nInforme o nome do advogado a ser transferido de departamento: ");
            String nome = ler.nextLine();
            for (int i = 0; i < advogado.size(); i++) {
                if (nome.equalsIgnoreCase(advogado.get(i).getNome())) {
                    advogado.get(j).mudarDepartamento(advogado.get(j).getNomeDep());
                    break;
                }
            }
        }

    }

    // Método para exibir livros emprestados de uma determinada área.
    private void exibirLivrosEmprestados() {
        if (emprestimo.isEmpty()) {
            System.out.println("Error: Não há empréstimos no sistema!");
        } else {
            Scanner ler = new Scanner(System.in);
            System.out.println("\nInforme o nome da área na qual se deseja saber os livros que foram emprestados: ");
            String area = ler.nextLine();
            for (int i = 0; i < livro.size(); i++) {
                if (area.equalsIgnoreCase(livro.get(j).getArea()) && livro.get(j).getDisponivel() == false) {
                    System.out.println("\n--" + livro.get(j).getTitulo() + "--");
                }
            }
        }

    }
}
