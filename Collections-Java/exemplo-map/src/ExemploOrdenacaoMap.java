import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Set;
public class ExemploOrdenacaoMap {
  public static void main(String[] args) {
    /* Dadas as seguintes informmações sobre os livros e seus autores,
       crie um dicionário e ordene este dicionário exibindo:
       (Nome Autor - Nome Livro)

       Autor = Hawking, Stephen - Livro = nome: Uma Breve História do Tempo, páginas: 256
       Autor = Duhigg, Charles - Livro = nome: O Poder do Hábito, páginas: 408
       Autor = Harari, Yuval Noah - Livro = nome: 21 Lições Para o Século 21, páginas: 432
    */
    System.out.println("--\tOrdem Aleatória\t--");
    Map<String, Livro> livros = new HashMap<>(){{
      put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
      put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
      put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
    }};
    for(Map.Entry<String, Livro> livro: livros.entrySet()){
      System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
    }

    System.out.println("--\tOrdem de Inserção\t--");
    Map<String,Livro> livrosLhm = new LinkedHashMap<>(){{
      put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
      put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
      put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
    }};
    for(Map.Entry<String, Livro> livro: livrosLhm.entrySet()){
      System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
    }

    System.out.println("--\tOrdem Alfabetica Autores\t--");
    Map<String,Livro> livrosTm = new TreeMap<>(livrosLhm){{
      put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
      put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
      put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
    }};
    for(Map.Entry<String, Livro> livro: livrosTm.entrySet()){
      System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
    }

    System.out.println("--\tOrdem Alfabética Nome dos Livros\t--");
    Set<Map.Entry<String, Livro>> livrosSet = new TreeSet<>(new ComparatorNome());
    livrosSet.addAll(livros.entrySet());
    for(Map.Entry<String, Livro> livro: livrosSet){
      System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
    }
  }
}

class Livro{
  private String nome;
  private Integer paginas;
  
  public Livro(String nome, Integer paginas) {
    this.nome = nome;
    this.paginas = paginas;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getPaginas() {
    return paginas;
  }

  public void setPaginas(Integer paginas) {
    this.paginas = paginas;
  }

  @Override
  public String toString() {
    return "[nome=" + nome + ", paginas=" + paginas + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((paginas == null) ? 0 : paginas.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Livro other = (Livro) obj;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (paginas == null) {
      if (other.paginas != null)
        return false;
    } else if (!paginas.equals(other.paginas))
      return false;
    return true;
  }
}

class ComparatorNome implements Comparator<Map.Entry<String,Livro>>{

  @Override
  public int compare(Entry<String, Livro> l1, Entry<String, Livro> l2) {
    return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
  }

}
