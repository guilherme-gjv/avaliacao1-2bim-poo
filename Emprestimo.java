import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Emprestimo {
  private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
  Date dataEmprestimo;
  Date dataDevolucao;
  String emprestimo, cpf;
  Scanner ler1 = new Scanner(System.in);
  Scanner ler2 = new Scanner(System.in);
  Livro livro;
  Advogado advogado;
  String datafinal, titulo;
  String nomeAdvogado;

  public void exibir() {
    System.out.println("\n------Exibindo empréstimo------\n");
    System.out.println("Titulo do livro emprestado: " + titulo);
    System.out.println("Data do empréstimo: " + datafinal);
    System.out.println("Nome do advogado que solicitou o empréstimo: " + nomeAdvogado);
  }

  public Emprestimo(Advogado advogado, Livro livro) {
    System.out.println("Informe a data do empréstimo(formato dd/MM/yyyy):");
    emprestimo = ler2.nextLine();
    nomeAdvogado = advogado.getNome();

    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    try {
      dataEmprestimo = df.parse(emprestimo);
      datafinal = formato.format(dataEmprestimo);
      System.out.println("Deu certo, a data é: " + datafinal);
      livro.setDisponivel(false);
    } catch (Exception e) {
      System.out.println("Deu erro");
      e.printStackTrace();
    }
    System.out.println("\n------Empréstimo realizado com sucesso--------");
    titulo = livro.getTitulo();

  }

  public void devolucao(Livro livro) {
    if (dataEmprestimo != null) {
      Scanner ler = new Scanner(System.in);
      System.out.println("\n----Devolvendo o Livro----");
      System.out.println("Informe a data de devolução(formato dd/MM/yyyy): ");
      String devolucao = ler.nextLine();
      DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
      try {
        dataDevolucao = df.parse(devolucao);
        System.out.println("Deu certo, a data é" + formato.format(dataDevolucao));
      } catch (Exception ex) {
        System.out.println("Deu errado");
        ex.printStackTrace();
      }

      long diff = dataDevolucao.getTime() - dataEmprestimo.getTime();
      TimeUnit time = TimeUnit.DAYS;
      long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
      long auxiliar = diffrence;
      System.out.println("A diferenca é: " + diffrence);

      float novopreco = 0;
      if (auxiliar > 10) {
        while (auxiliar > 10) {
          novopreco = novopreco + calcular(livro.getPreco());
          auxiliar--;
        }
        System.out.println("Livro devolvido em " + diffrence + " dias, o preço a se pagar pelo livro é: " + novopreco);
        livro.setDisponivel(true);
        ;
      } else {
        System.out
            .println("Livro devolvido em " + diffrence + " dias, o preço a se pagar pelo livro é: " + livro.getPreco());
        livro.setDisponivel(true);
      }
    }

  }

  public float calcular(float preco) {

    preco = preco + preco * 10 / 100;

    return preco;
  }

}
