
import java.util.Scanner;

public class Advogado {

    private Scanner ler1 = new Scanner(System.in);
    private Scanner ler2 = new Scanner(System.in);
    private String nome, data_admitido, cpf, telefone, departament;
    private String nomeDep[] = { "Criminal", "Trabalhista", "Civil", "Consumidor" };
    private String responsavel[] = { "Márcio", "Maria", "José", "Fábio" };
    private int escolha;
    private int quantidade_processos[] = { 15, 20, 25, 30 };
    private Departamento departamento[] = new Departamento[4];

    public Advogado() {
        cadastro();
    }

    // Método para cadastro dos advogados
    private void cadastro() {
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

    // Método para saber o departamento em que o advogado trabalha
    private void saberDepartamento() {
        for (int i = 0; i < departamento.length; i++) {
            departamento[i] = new Departamento(nomeDep[i], responsavel[i], quantidade_processos[i]);
        }
        do {
            System.out.println("Informe o departamento do advogado. Digite:");
            System.out.println("\n[1]" + departamento[0].getNome());
            System.out.println("\n[2]" + departamento[1].getNome());
            System.out.println("\n[3]" + departamento[2].getNome());
            System.out.println("\n[4]" + departamento[3].getNome());
            escolha = ler1.nextInt();
            if (escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4) {
                System.out.println("\n---Opção inválida---");
            } else {
                departament = departamento[escolha - 1].getNome();
            }
        } while (escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4);

    }

    // Método para exibir os dados do advogado
    public void exibir() {
        System.out.println("\n------Exibindo dados do Advogado-------\n");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Telefone: " + telefone);
        System.out.println("Data de admissão: " + data_admitido);
        System.out.println("Departamento em que atua: " + departament);
    }

    // Método para mudar o advogado de departamento
    public void mudarDepartamento(String[] nomeDep) {
        do {
            System.out.println("Informe o departamento a transferir o advogado. Digite:");
            System.out.println("\n[1]" + departamento[0].getNome());
            System.out.println("\n[2]" + departamento[1].getNome());
            System.out.println("\n[3]" + departamento[2].getNome());
            System.out.println("\n[4]" + departamento[3].getNome());
            escolha = ler1.nextInt();

            if (escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4) {
                System.out.println("\n---Opção inválida---");
                break;
            }
            if (nomeDep[escolha - 1] == departament) {
                System.out.println("\nNão é possível transferir o advogado para o departamento "
                        + departamento[escolha - 1].getNome() + ", motivo: este é o departamento atual do advogado. ");
            }
            if (nomeDep[escolha - 1] != departament && (escolha == 1 || escolha == 2 || escolha == 3 || escolha == 4)) {
                departament = departamento[escolha - 1].getNome();
                System.out.println("\nDepartamento mudado para " + departament);
            }
        } while (escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4 && nomeDep[escolha - 1] == departament);
    }

    // ----------MÉTODOS GET-----------
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String[] getNomeDep() {
        return nomeDep;
    }
}
