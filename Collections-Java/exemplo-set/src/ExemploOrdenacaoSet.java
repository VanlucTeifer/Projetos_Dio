import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*Dadas as seguites informações sobre as series, crie um conjunto
      e ordene esse conjunto exibindo:
      (nome - genero - tempo de episódio)
      Série 1 = Nome: GOT, Gênero: Fantasia, Tempo de Episódio: 60
      Série 2 = Nome: Dark, Gênero: Drama, Tempo de Episódio: 60
      Série 3 = Nome: That 70's Show, Gênero: Comédia, Tempo de Episódio: 25
      */
  public class ExemploOrdenacaoSet {
  public static void main(String[] args) {
    
    System.out.println("--\tOrdem Aleatória\t--");

    Set<Serie> series = new HashSet<>(){{
      add(new Serie("GOT", "Fantasia", 60));
      add(new Serie("Dark", "Drama", 60));
      add(new Serie("That '70s Show", "Comédia", 25));
    }};
    for (Serie serie : series) {
      System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());  
    }
    System.out.println("--\tOrdem Inserção\t--");
    Set<Serie> series2 = new LinkedHashSet<>(){{
      add(new Serie("GOT", "Fantasia", 60));
      add(new Serie("Dark", "Drama", 60));
      add(new Serie("That '70s Show", "Comédia", 25));
    }};
    for (Serie serie : series2) {
      System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());  
    }

    System.out.println("--\tOrdem natural (Tempo de Episódio)\t--");
    Set<Serie> series3 = new TreeSet<>(series); //Precisa implementar a interface Comparable na classe Serie
    for (Serie serie : series3) {
      System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());  
    }

    System.out.println("--\tOrdem Nome/Genero/Tempo de Episódio\t--");
    Set<Serie> series4 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
    series4.addAll(series); //Precisa implementar a interface Comparable na classe Serie
    for (Serie serie : series4) {
      System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());  
    }

    // Para fazer
    System.out.println("--\tOrdem Gênero\t--");
    Set<Serie> series5 = new TreeSet<>(new ComparatorGenero());
    series5.addAll(series);
    for (Serie serie : series5) {
      System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());  
    }
    System.out.println("--\tOrdem TempoEpisodio\t--");
    Set<Serie> series6 = new TreeSet<>(new ComparatorTempoEpisodio());
    series6.addAll(series);
    for (Serie serie : series6) {
      System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());  
    }
  }
}

class Serie implements Comparable<Serie>{
  private String nome;
  private String genero;
  private Integer tempoEpisodio;

  public Serie(String nome, String genero, Integer tempoEpisodio) {
    this.nome = nome;
    this.genero = genero;
    this.tempoEpisodio = tempoEpisodio;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public Integer getTempoEpisodio() {
    return tempoEpisodio;
  }

  public void setTempoEpisodio(Integer tempoEpisodio) {
    this.tempoEpisodio = tempoEpisodio;
  }

  @Override
  public String toString() {
    return "[genero=" + genero + ", nome=" + nome + ", tempoEpisodio=" + tempoEpisodio + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((genero == null) ? 0 : genero.hashCode());
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((tempoEpisodio == null) ? 0 : tempoEpisodio.hashCode());
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
    Serie other = (Serie) obj;
    if (genero == null) {
      if (other.genero != null)
        return false;
    } else if (!genero.equals(other.genero))
      return false;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (tempoEpisodio == null) {
      if (other.tempoEpisodio != null)
        return false;
    } else if (!tempoEpisodio.equals(other.tempoEpisodio))
      return false;
    return true;
  }

  @Override
  public int compareTo(Serie s) {
    int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), s.getTempoEpisodio());
    if(tempoEpisodio != 0) return tempoEpisodio;
    
    return this.getGenero().compareTo(s.getGenero());
  }
}
 class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie>{

  @Override
  public int compare(Serie s1, Serie s2) {
    int nome = s1.getNome().compareTo(s2.getNome());
    if(nome != 0) return nome;
  
    int genero = s1.getGenero().compareTo(s2.getGenero());
    if(genero != 0) return genero;

  return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
 }
}

class ComparatorGenero implements Comparator<Serie>{

  @Override
  public int compare(Serie s1, Serie s2) {
    int genero = s1.getGenero().compareTo(s2.getGenero());
    if(genero != 0) return genero;

    return s1.getNome().compareTo(s2.getNome());
  }

}

class ComparatorTempoEpisodio implements Comparator<Serie>{

  @Override
  public int compare(Serie s1, Serie s2) {
    int tempo = s1.getTempoEpisodio().compareTo(s2.getTempoEpisodio());
    if(tempo != 0) return tempo;

    return s1.getNome().compareTo(s2.getNome());
  }

}