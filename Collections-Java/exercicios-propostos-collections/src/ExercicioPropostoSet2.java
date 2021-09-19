import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExercicioPropostoSet2 {
  public static void main(String[] args) {
    Set<LinguagensProgramacao> linguagens = new LinkedHashSet<>(){{
      add(new LinguagensProgramacao("C", 1972, "CodeBlocks"));
      add(new LinguagensProgramacao("Java", 1995, "NetBeans"));
      add(new LinguagensProgramacao("C++", 1985, "Visual Studio"));
    }};
    System.out.println(linguagens); // Questão 1

    Set<LinguagensProgramacao> linguagens2 = new TreeSet<>(linguagens);
    System.out.println(linguagens2); // Questão 2

    Set<LinguagensProgramacao> linguagens3 = new TreeSet<>(new CompareIde());
    linguagens3.addAll(linguagens);
    System.out.println(linguagens3);// Questão 3

    Set<LinguagensProgramacao> linguagens4 = new TreeSet<>(new CompareAnoNome());
    linguagens4.addAll(linguagens);
    System.out.println(linguagens4);// Questão 4

    Set<LinguagensProgramacao> linguagens5 = new TreeSet<>(new CompareNomeAnoIde());
    linguagens5.addAll(linguagens);
    System.out.println(linguagens5);// Questão 5

    for(LinguagensProgramacao linguagem : linguagens) // Imprime todas uma abaixo da outra
    System.out.println("Nome: " + linguagem.getNome() + " - " + 
                       "Ano: " + linguagem.getAno() + " - " + 
                       "IDE: " + linguagem.getIde());
  }
}

class LinguagensProgramacao implements Comparable<LinguagensProgramacao>{
  private String nome;
  private Integer ano;
  private String ide;
  
  public LinguagensProgramacao(String nome, Integer ano, String ide) {
    this.nome = nome;
    this.ano = ano;
    this.ide = ide;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getAno() {
    return ano;
  }

  public void setAno(Integer ano) {
    this.ano = ano;
  }

  public String getIde() {
    return ide;
  }

  public void setIde(String ide) {
    this.ide = ide;
  }

  @Override
  public String toString() {
    return "[ano=" + ano + ", ide=" + ide + ", nome=" + nome + "]";
  }

  @Override
  public int compareTo(LinguagensProgramacao lp) {
    int nome = this.getNome().compareToIgnoreCase(lp.getNome());
    if(nome != 0) return nome;
    
    return this.getNome().compareToIgnoreCase(lp.getNome());
  }
}

class CompareIde implements Comparator<LinguagensProgramacao>{

  @Override
  public int compare(LinguagensProgramacao o1, LinguagensProgramacao o2) {
    int nome = o1.getIde().compareToIgnoreCase(o2.getIde());
    if(nome != 0) return nome;
    
    return o1.getIde().compareToIgnoreCase(o2.getIde());
  }

}

class CompareAnoNome implements Comparator<LinguagensProgramacao>{

  @Override
  public int compare(LinguagensProgramacao o1, LinguagensProgramacao o2) {
    int ano = o1.getAno().compareTo(o2.getAno());
    if(ano != 0) return ano;
    return o1.getNome().compareTo(o2.getNome());
  }

}

class CompareNomeAnoIde implements Comparator<LinguagensProgramacao>{

  @Override
  public int compare(LinguagensProgramacao o1, LinguagensProgramacao o2) {
    int nome = o1.getNome().compareTo(o2.getNome());
    if(nome != 0) return nome;

    int ano = o1.getAno().compareTo(o2.getAno());
    if(ano != 0) return ano;

    return o1.getIde().compareTo(o2.getIde());
  }

}