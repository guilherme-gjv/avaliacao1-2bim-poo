import java.util.Scanner;

public class Advogado {

    private Scanner ler1 = new Scanner(System.in);
    private Scanner ler2 = new Scanner(System.in);
    private String nome, data_admitido, cpf, telefone, departament;
    Livro livro;
    String nomeDep[] = { "Criminal", "Trabalhista", "Civil", "Consumidor" };
    String responsavel[] = { "Márcio", "Maria", "José", "Fábio" };
    int escolha;
    int quantidade_processos[] = { 15, 20, 25, 30 };
    Departamento departamento[] = new Departamento[4];

    // nome, CPF, telefone, data que foi admitido e o departamento que atua

    Advogado() {
        getDados();
    }

    private void getDados() {
        System.out.println("Nome do advogado: ");
        nome = ler1.nextLine();
        System.out.println("Número do CPF: ");
        cpf = ler2.nextLine();
        System.out.println("Número do telefone: ");
        telefone = ler1.nextLine();
        System.out.println("Data que foi admitido: ");
        data_admitido = ler2.nextLine();
        saberDepartamento();

    }

    public String getNome() {
        return nome;
    }

    public void switchDepartamento() {
        saberDepartamento();
    }

    private void saberDepartamento() {
        for (int i = 0; i < departamento.length; i++) {
            departamento[i] = new Departamento(nomeDep[i], responsavel[i], quantidade_processos[i]);
        }
        do {
            System.out.println("Informe o departamento do advogado. Digite:");
            System.out.println("\n[1]" + departamento[0].nome);
            System.out.println("\n[2]" + departamento[1].nome);
            System.out.println("\n[3]" + departamento[2].nome);
            System.out.println("\n[4]" + departamento[3].nome);
            escolha = ler1.nextInt();
            if (escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4) {
                System.out.println("\n---Opção inválida---");
            } else {
                departament = departamento[escolha - 1].nome;
            }
        } while (escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4);

    }

    // pode ser usado tanto no construtor quanto para trocar o departamento
    public void exibir() {
        System.out.println("Exibindo dados do Advogado");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Telefone: " + telefone);
        System.out.println("Data de admissão: " + data_admitido);
        System.out.println("Departamento em que atua: " + departament);
    }

    public void solicitarEmprestimo() {
        livro.emprestimo();
    }
}
