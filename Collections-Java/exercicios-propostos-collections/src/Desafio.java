import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Desafio {
  public static void main (String[] args) {
    int lados = 6;
    int rolagem;
    List<Integer> valor = new ArrayList<>();
    for (int i = 1; i <= 100; i++){
      rolagem = (int)(Math.random()*lados)+1;
      valor.add(rolagem);
    }
    Iterator<Integer> iterator = valor.iterator();
    Integer soma1 = 0;
    Integer soma2 = 0;
    Integer soma3 = 0;
    Integer soma4 = 0;
    Integer soma5 = 0;
    Integer soma6 = 0;
    
    while(iterator.hasNext()){
      Integer next = iterator.next();
      if(next == 1) {
        soma1++;
      }else if(next == 2){
        soma2++;
      }else if(next == 3) {
        soma3++;
      }else if(next == 4){
        soma4++;
      }else if(next == 5){
        soma5++;
      }else if(next == 6) {
        soma6++;
      }
    }
    System.out.println("Total de número 1: " + soma1);
    System.out.println("Total de número 2: " + soma2);
    System.out.println("Total de número 3: " + soma3);
    System.out.println("Total de número 4: " + soma4);
    System.out.println("Total de número 5: " + soma5);
    System.out.println("Total de número 6: " + soma6);
    System.out.println("Total de rolagens: " + (soma1+soma2+soma3+soma4+soma5+soma6));
  }
}
