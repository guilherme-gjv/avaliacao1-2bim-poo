import java.util.Scanner;

public class Livro {
  private String titulo, autor, editora, area, codigo;
  private float preco;
  private boolean disponivel = false;

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

  public String getTitulo() {
    return titulo;
  }

  public void setDisponivel(boolean disponivel) {
    this.disponivel = disponivel;
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

  public float getPreco() {
    return preco;
  }
}