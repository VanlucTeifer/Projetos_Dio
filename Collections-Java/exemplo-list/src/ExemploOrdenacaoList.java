import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {
  public static void main(String[] args) {
    List<Gato> meusGatos = new ArrayList<>(){{ //Outra forma de adicionar elementos em uma Lista
      add(new Gato("Jon", 18, "Preto"));
      add(new Gato("Simba", 6, "Tigrado"));
      add(new Gato("Jon", 12, "Amarelo"));
    }};
    System.out.println("--\tOrdem de Inserção\t--");
    System.out.println(meusGatos);

    System.out.println("--\tOrdem aleatória\t--");
    Collections.shuffle(meusGatos);
    System.out.println(meusGatos);

    System.out.println("--\tOrdem natural (nome)\t--");
    Collections.sort(meusGatos);
    System.out.println(meusGatos);

    System.out.println("--\tOrdem Idade\t--");
    // Collections.sort(meusGatos, new ComparatorIdade());
    meusGatos.sort(new ComparatorIdade());
    System.out.println(meusGatos);

    System.out.println("--\tOrdem Cor\t--");
    // Collections.sort(meusGatos, new ComparatorCor());
    meusGatos.sort(new ComparatorCor());
    System.out.println(meusGatos);

    System.out.println("--\tOrdem Nome/Cor/Idade\t--");
    // Collections.sort(meusGatos, new ComparatorNomeCorIdade());
    meusGatos.sort(new ComparatorNomeCorIdade());
    System.out.println(meusGatos);
  }
}

class Gato implements Comparable<Gato>{ //Criação da classe Gato para ser implementada na lista
private String nome;
private Integer idade;
private String cor;

//Construtor
public Gato(String nome, Integer idade, String cor) { //Construtor da classe Gato
  this.nome = nome;
  this.idade = idade;
  this.cor = cor;
}
//Métodos Getters e Setters
public String getNome() {
  return nome;
}

public void setNome(String nome) {
  this.nome = nome;
}

public Integer getIdade() {
  return idade;
}

public void setIdade(Integer idade) {
  this.idade = idade;
}

public String getCor() {
  return cor;
}

public void setCor(String cor) {
  this.cor = cor;
}
//Métodos Especiais
@Override
public String toString() {
  return "[cor=" + cor + ", idade=" + idade + ", nome=" + nome + "]";
}

@Override
public int compareTo(Gato gato) {
  return this.getNome().compareToIgnoreCase(gato.getNome());
}
}

class ComparatorIdade implements Comparator<Gato>{ //Classe para comprar os elementos da lista pelo atributo nome 
                                                   //e implementa a interface Comparator

  @Override                                        //Sobrescreve o método compare do Comparator
  public int compare(Gato g1, Gato g2) {
    return Integer.compare(g1.getIdade(), g2.getIdade()); //Retorna a comparação dos objetos g1 e g2, retornando 1, 0 ou -1
  }

}

class ComparatorCor implements Comparator<Gato>{ //Classe para comprar os elementos da lista pelo atributo cor 
                                                 //e implementa a interface Comparator

  @Override                                      //Sobrescreve o método compare do Comparator
  public int compare(Gato g1, Gato g2) {
    return g1.getCor().compareToIgnoreCase(g2.getCor()); //Retorna a comparação dos objetos g1 e g2, retornando 1,0 ou -1
  }

}

class ComparatorNomeCorIdade implements Comparator<Gato>{ //Classe para comprar os elementos da lista pelo atributo cor 
                                                          //e implementa a interface Comparator

  @Override                                               //Sobrescreve o método compare do Comparator
  public int compare(Gato g1, Gato g2) {
    int nome = g1.getNome().compareToIgnoreCase(g2.getNome()); //Variáve local que armazena a comparação dos objetos g1 e g2 por nome
    if(nome != 0) return nome;                                 //Verifica se o objeto for diferente de 0 e retorna o valor da variável
                                                               //caso seja falso passa para a outra verificação
    int cor = g1.getCor().compareToIgnoreCase(g2.getCor());    // Variavel local que armazena a comparação dos objetos g1 e g2 por cor
    if(cor != 0) return cor;
                                                               //caso seja falso passa para a outra verificação    
    return Integer.compare(g1.getIdade(), g2.getIdade());      //Retorna a comparação dos objetos g1 e g2 por idade
  }

}