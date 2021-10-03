import java.util.*;

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

    if(!estados.containsKey("PB")){// Questão 2
      estados.put("PB", 4039277);
    }
    System.out.println(estados);

    System.out.println(estados.get("PE"));// Questão 3

    System.out.println(estados);// Questão 4

    Map<String, Integer> estadosAlfabetica = new TreeMap<>(estados);
    System.out.println(estadosAlfabetica);// Questão 5

    Integer menorPopulacao = Collections.min(estados.values());
    System.out.println(menorPopulacao);// Questão 6
    
    Integer maiorPopulacao = Collections.max(estados.values());
    System.out.println(maiorPopulacao);// Questão 7
  
    Iterator<Integer> iterator = estados.values().iterator();
      Integer soma = 0;
      while(iterator.hasNext()) soma += iterator.next();
    System.out.println("Soma da população: " + soma); // Questão 8
  
    System.out.println("Media da popuação: " + soma/estados.size());
  
    Iterator<Integer> iterator2 = estados.values().iterator();
    while(iterator2.hasNext()){
      if(iterator2.next() <= 4000000) iterator2.remove();// Questão 9
    }
    System.out.println(estados);
    estados.clear();// Questão 10
    System.out.println(estados.isEmpty());// Questão 11
  }
  
}
