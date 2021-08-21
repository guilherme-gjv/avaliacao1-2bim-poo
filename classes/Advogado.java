package classes;

import java.util.Scanner;

public class Advogado {

    // nome, CPF, telefone, data que foi admitido e o departamento que atua
    Advogado() {
        getDados();
    }

    Scanner ler = new Scanner(System.in);
    String nome, data_admitido;
    int cpf, telefone;
    Departamento departamento;

    void getDados() {
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

    void switchDepartamento() {
        getDepartamento();
    }

    void getDepartamento() {
        System.out.println("Digite o Departamento: ");
        departamento = new Departamento();
    }

    // pode ser usado tanto no construtor quanto para trocar o departamento
    void exibir() {
        System.out.println("Exibindo dados do Advogado");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Telefone: " + telefone);
        System.out.println("Data de admissão: " + data_admitido);
        System.out.println("Departamento: " + departamento);
    }
}
