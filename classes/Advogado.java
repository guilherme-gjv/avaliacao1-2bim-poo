package classes;

public class Advogado {

    //nome, CPF, telefone, data que foi admitido e o departamento que atua 
    Advogado(){
        getDados();
    }

    void getDados() {
        String nome, data_admitido;
        int cpf, telefone;
        Departamento departamento;

        System.out.println("Nome do advogado: ");
        System.out.println("Número do CPF: ");
        System.out.println("Número do telefone: ");
        System.out.println("Data que foi admitido: ");
        System.out.println("Departamento: ");
    }

    void exibir() {

    }

    void getDepartamento() {

    }
    // pode ser usado tanto no construtor quanto para trocar o departamento
}
