import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ExercicioPropostoSet1 {
  public static void main(String[] args) {
    Set<String> corArcoIris = new HashSet<>();
    corArcoIris.add("Amarelo");
    corArcoIris.add("Azul");
    corArcoIris.add("Vermelho");
    corArcoIris.add("Violeta");
    corArcoIris.add("Verde");
    corArcoIris.add("Anil");
    corArcoIris.add("Laranja");

    for(String cor : corArcoIris) System.out.println(cor); //Letra a

    // ------------------------------------------------------------------------------------ //

    System.out.println("Quantidade de Cores: "+ corArcoIris.size()); //Letra B

    // ------------------------------------------------------------------------------------ //

    Set<String> corArcoIris2 = new TreeSet<>(corArcoIris);
      System.out.println(corArcoIris2); //Letra C

    // ------------------------------------------------------------------------------------ //

      Set<String> corArcoIris3 = new LinkedHashSet<>(){{
        add("Violeta");
        add("Vermelho");
        add("Verde");
        add("Laranja");
        add("Azul");
        add("Anil");
        add("Amarelo");
      }};
      System.out.println(corArcoIris3); //Letra D ou
      List<String> reverso = new ArrayList<>(corArcoIris3);
      Collections.reverse(reverso);
      System.out.println(reverso);

      // ------------------------------------------------------------------------------------ //

      for(String cores : corArcoIris){ //Letra E
        if(cores.startsWith("V")){ 
          System.out.println(cores);
        }
      }

      // ------------------------------------------------------------------------------------ //

      Iterator<String> iterator = corArcoIris.iterator(); //Letra F
      while(iterator.hasNext()){
        if(iterator.next().startsWith("V")) iterator.remove();
      }
      System.out.println(corArcoIris);

      corArcoIris.clear(); //Letra G
      corArcoIris2.clear();
      corArcoIris3.clear();

      System.out.println(corArcoIris.isEmpty()); //Letra H
      System.out.println(corArcoIris2.isEmpty());
      System.out.println(corArcoIris3.isEmpty());

  }
  
}