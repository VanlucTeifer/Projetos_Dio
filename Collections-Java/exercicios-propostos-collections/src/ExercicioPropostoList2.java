import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExercicioPropostoList2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<String> perguntas = new ArrayList<>();

    perguntas.add("Telefonou para a vítima?");
    perguntas.add("Esteve no local do crime?");
    perguntas.add("Mora perto da vítima?");
    perguntas.add("Devia para a vítima?");
    perguntas.add("Já trabalhou com a vítima?");

    Iterator<String> iterator = perguntas.iterator();
    String resposta = "";
    int culpado = 0;
    while(iterator.hasNext()){
      System.out.println(iterator.next());
      resposta = scanner.nextLine();
      if(resposta.equals("s")) culpado++;
    }
    switch(culpado){
      case 5:
        System.out.println("Assassina(o)");
        break;
      case 4:
      case 3:
        System.out.println("Cúmplice");
        break;
      case 2:
        System.out.println("Suspeita");
        break;
      default:
        System.out.println("Inocente");
    }
    scanner.close();
  }
  
}
