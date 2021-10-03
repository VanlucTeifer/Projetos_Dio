import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ExercicioPropostoMap1 {
  public static void main(String[] args) {
    Map<String, Integer> estados = new HashMap<>(){{
      put("PE", 9616621);
      put("AL", 3351543);
      put("CE", 9187103);
      put("RN", 3534265);
    }};
    System.out.println(estados);

    estados.put("RN", 3354165);// Questão 1
    System.out.println(estados);

    if(estados.containsKey("PB") == false){// Questão 2
      estados.put("PB", 4039277);
    }
    System.out.println(estados);

    System.out.println(estados.get("PE"));// Questão 3

    System.out.println(estados);// Questão 4

    Map<String, Integer> estadosAlfabetica = new TreeMap<>(estados);
    System.out.println(estadosAlfabetica);// Questão 5

    Integer menorPopulacao = Collections.min(estados.values());
    System.out.println(menorPopulacao);
  }
  
}
