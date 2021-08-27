import java.util.Scanner;

public class Departamento {
    String nome, responsavel;
    int quantidade_processos;
    Scanner ler = new Scanner(System.in);

    Departamento(String nome, String responsavel, int quantidade_processos) {
        this.nome = nome;
        this.responsavel = responsavel;
        this.quantidade_processos = quantidade_processos;
    }

    Departamento() {
        System.out.println("Informe os dados do Departamento");
        System.out.println("Nome: ");
        nome = ler.nextLine();
        System.out.println("Responsável: ");
        responsavel = ler.nextLine();
        System.out.println("Quantidade de Processos: ");
        quantidade_processos = ler.nextInt();

    }

    void exibir() {
        System.out.println("\n-----Dados do Departamento-----\n");
        System.out.println("Nome do departamento: " + nome);
        System.out.println("Responsavel: " + responsavel);
        System.out.println("Quantidade de Processos> " + quantidade_processos);
        System.out.println("\n----------------------------------\n");
    }
}
