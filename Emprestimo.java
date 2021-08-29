import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Emprestimo {
  private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
  private Date dataEmprestimo;
  private Date dataDevolucao;
  private String emprestimo, datafinal, titulo, nomeAdvogado;
  private Scanner ler1 = new Scanner(System.in);
  private String codigo;
  private Livro livro;
  private boolean devolvido;

  // Construtor que solicitará empréstimo.
  public Emprestimo(Advogado advogado, Livro livro) {
    System.out.println("Informe a data do empréstimo(formato dd/MM/yyyy):");
    emprestimo = ler1.nextLine();
    nomeAdvogado = advogado.getNome();
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    try {
      dataEmprestimo = df.parse(emprestimo);
      datafinal = formato.format(dataEmprestimo);
      System.out.println("Deu certo, a data do empréstimo é: " + datafinal);
      livro.setDisponivel(false);
    } catch (Exception e) {
      System.out.println("----Houve algum erro com a data----");
      e.printStackTrace();
    }
    System.out.println("\n------Empréstimo realizado com sucesso--------");
    titulo = livro.getTitulo();

  }

  // Método para exibir dados do empréstimo.
  public void exibir() {
    System.out.println("\n------Exibindo empréstimo------\n");
    System.out.println("Titulo do livro emprestado: " + titulo);
    System.out.println("Data do empréstimo: " + datafinal);
    System.out.println("Nome do advogado que solicitou o empréstimo: " + nomeAdvogado);
    System.out.println("\n-----------------------------------\n");
  }

  // Método para devolucao do livro.
  public void devolucao(Livro livro) {
    if (dataEmprestimo != null) {
      Scanner ler = new Scanner(System.in);
      System.out.println("\n----Devolvendo o Livro----");
      System.out.println("Informe a data de devolução(formato dd/MM/yyyy): ");
      String devolucao = ler.nextLine();
      DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
      try {
        dataDevolucao = df.parse(devolucao);
        long diff = dataDevolucao.getTime() - dataEmprestimo.getTime();
        TimeUnit time = TimeUnit.DAYS;
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
        long auxiliar = diffrence;
        float novopreco = 0;
        System.out.println("Deu certo, a data da devolução é: " + formato.format(dataDevolucao));
        if (auxiliar > 10) {
          while (auxiliar > 10) {
            novopreco = novopreco + calcular(livro.getPreco());
            auxiliar--;
          }
          System.out
              .println("Livro devolvido em " + diffrence + " dias, o preço a se pagar pelo livro é: " + novopreco);
          livro.setDisponivel(true);
          ;
        } else {
          System.out.println(
              "Livro devolvido em " + diffrence + " dias, o preço a se pagar pelo livro é: " + livro.getPreco());
          livro.setDisponivel(true);
        }

        devolvido = true;
      } catch (Exception ex) {
        System.out.println("Houve algum erro com a data.");
        ex.printStackTrace();
      }

    }

  }

  // Método para calcular o preço do empréstimo após a devolução.
  public float calcular(float preco) {

    preco = preco + preco * 10 / 100;

    return preco;
  }

  // -----MÉTODOS GET -----------
  public Date getDataEmprestimo() {
    return dataEmprestimo;
  }

  public boolean getDevolvido() {
    return devolvido;
  }

}
