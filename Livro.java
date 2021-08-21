import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Livro {
  private String titulo, autor, editora, area;
  private float preco;
  private String codigo;
  private boolean disponivel;
  private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
  Date dataEmprestimo;
  Date dataDevolucao;

  public Livro() {
    cadastro();
  }

  public void exibir() {
    System.out.println("\n---Exibindo informações do livro---\n");
    System.out.println("Titulo: " + titulo);
    System.out.println("Autor: " + autor);
    System.out.println("Editora: " + editora);
    System.out.println("Área do livro: " + area);
    System.out.println("Preço: " + preco);
    System.out.println("Código: " + codigo);
    System.out.println("\n-----------------------------------\n");
  }

  public void cadastro() {
    Scanner ler1 = new Scanner(System.in);
    Scanner ler2 = new Scanner(System.in);
    System.out.println("\n----Sistema de Cadastro de Livro -------\n");
    System.out.println("Informe o titulo do livro: ");
    titulo = ler1.nextLine();
    System.out.println("Informe o autor do livro: ");
    autor = ler2.nextLine();
    System.out.println("Informe a editora do livro: ");
    editora = ler1.nextLine();
    System.out.println("Informe a área do livro: ");
    area = ler2.nextLine();
    System.out.println("Informe o preço do livro: ");
    preco = ler1.nextFloat();
    System.out.println("Por fim, atribua um código ao livro: ");
    codigo = ler2.nextLine();
    System.out.println("\n------LIVRO CADASTRADO NO SISTEMA------\n");
    disponivel = true;
    status(disponivel);
  }

  public boolean status(boolean disponivel) {
    return disponivel;
  }

  public void emprestimo() {
    Scanner ler = new Scanner(System.in);
    System.out.println("\n----Fazendo empréstimo do livro-----");
    System.out.println("Informe a data do empréstimo(formato dd/MM/yyyy): ");
    String emprestimo = ler.nextLine();
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    try {
      dataEmprestimo = df.parse(emprestimo);
      System.out.println("Deu certo, a data é: " + formato.format(dataEmprestimo));
    } catch (Exception ex) {
      System.out.println("Deu erro");
      ex.printStackTrace();
    }

    System.out.println("\n------Empréstimo realizado com sucesso--------");
    disponivel = false;
    status(disponivel);
  }

  public void devolucao() {
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
      System.out.println("A diferenca é: " + diffrence);

      if (diffrence > 10) {
        System.out
            .println("Livro devolvido em " + diffrence + " dias, o preço a se pagar pelo livro é: " + calcular(preco));
        ;
      } else {
        System.out.println("Livro devolvido em " + diffrence + " dias, o preço a se pagar pelo livro é: " + preco);
      }
    }
    
  }

  public float calcular(float preco) {
    preco = this.preco + (this.preco * (10 / 100));

    return preco;
  }
  
}