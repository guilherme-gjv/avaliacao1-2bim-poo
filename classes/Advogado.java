package classes;

import java.util.Scanner;

public class Advogado {

    // nome, CPF, telefone, data que foi admitido e o departamento que atua
    Advogado() {
        getDados();
    }

    private Scanner ler = new Scanner(System.in);
    private String nome, data_admitido;
    private int cpf, telefone;
    Departamento departamento;

    private void getDados() {
        System.out.println("Nome do advogado: ");
        nome = ler.nextLine();
        System.out.println("Número do CPF: ");
        cpf = ler.nextInt();
        System.out.println("Número do telefone: ");
        telefone = ler.nextInt();
        System.out.println("Data que foi admitido: ");
        data_admitido = ler.nextLine();
        getDepartamento();

    }

    public void switchDepartamento() {
        getDepartamento();
    }

    private void getDepartamento() {
        System.out.println("Digite o Departamento: ");
        departamento = new Departamento();
    }

    // pode ser usado tanto no construtor quanto para trocar o departamento
    public void exibir() {
        System.out.println("Exibindo dados do Advogado");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Telefone: " + telefone);
        System.out.println("Data de admissão: " + data_admitido);
        System.out.println("Departamento: " + departamento);
    }
}
