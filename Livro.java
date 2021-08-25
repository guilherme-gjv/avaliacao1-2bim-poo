import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Livro {
  private String titulo, autor, editora, area, dado, codigo, emprestimo;
  private float preco;
  private boolean disponivel = false;
  private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
  Date dataEmprestimo;
  Date dataDevolucao;
  Advogado advogado;

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
    codigo = gerarCodigo();
    System.out.println("O código do livro é: " + codigo);
    System.out.println("\n------LIVRO CADASTRADO NO SISTEMA------\n");
    disponivel = true;

  }

  public boolean getDisponivel() {
    return disponivel;
  }

  public void emprestimo() {
    Scanner ler = new Scanner(System.in);
    System.out.println("\n----Fazendo empréstimo do livro-----");
    System.out.println("Informe a data do empréstimo(formato dd/MM/yyyy): ");
    emprestimo = ler.nextLine();

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

  }

  public void exibirEmprestimo() {
    if (emprestimo != null && !disponivel) {
      System.out.println("Titulo do livro emprestado: " + titulo);
      System.out.println("Data do empréstimo: " + formato.format(dataEmprestimo));
      System.out.println("Nome do advogado que solicitou o empréstimo: " + advogado.getNome());
    } else {
      System.out.println("Não há empréstimos!");
    }

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

      float novopreco = 0;
      if (diffrence > 10) {
        while (diffrence > 10) {
          novopreco = novopreco + calcular(preco);
          diffrence--;
        }
        System.out.println("Livro devolvido em " + diffrence + " dias, o preço a se pagar pelo livro é: " + novopreco);
        ;
      } else {
        System.out.println("Livro devolvido em " + diffrence + " dias, o preço a se pagar pelo livro é: " + preco);
      }
      ler.close();
    }

  }

  public float calcular(float preco) {

    preco = preco + preco * 10 / 100;

    return preco;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getCodigo() {
    return codigo;
  }

  private String gerarCodigo() {
    // int qtdeMaximaCaracteres = 8;
    int qtdeMaximaCaracteres = 6;
    String[] caracteres = { "0", "1", "b", "2", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
        "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

    StringBuilder senha = new StringBuilder();

    for (int i = 0; i < qtdeMaximaCaracteres; i++) {
      int posicao = (int) (Math.random() * caracteres.length);
      senha.append(caracteres[posicao]);
    }
    return senha.toString();

  }
}