import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class ExercicioPropostoList1 {
    public static void main(String[] args) throws Exception {
        List<Double> tempMedia = new ArrayList<>();
        tempMedia.add(28.7);
        tempMedia.add(29.9);
        tempMedia.add(30.5);
        tempMedia.add(31.0);
        tempMedia.add(30.2);
        tempMedia.add(29.6);

        Iterator<Double> iterator = tempMedia.iterator();
        Double soma = 0d;
        Double media = 0d;
        while(iterator.hasNext()){
            soma += iterator.next();
        }

        media = soma/tempMedia.size();

        Iterator<Double> iterator2 = tempMedia.iterator();
        while(iterator2.hasNext()){
            Double prox = iterator2.next();
            if(prox > media){
                switch(tempMedia.indexOf(prox)){
                case(0):
                    System.out.println("Temperatura " + tempMedia.get(0) + " acima da média no mês de Janeiro");
                    break;
                case(1):
                    System.out.println("Temperatura " + tempMedia.get(1) + " acima da média no mês de Fevereiro");
                    break;
                case(2):
                    System.out.println("Temperatura " + tempMedia.get(2) + " acima da média no mês de Março");
                    break;
                case(3):
                    System.out.println("Temperatura " + tempMedia.get(3) + " acima da média no mês de Abril");
                    break;
                case(4):
                    System.out.println("Temperatura " + tempMedia.get(4) + " acima da média no mês de Maio");
                    break;
                case(5):
                    System.out.println("Temperatura " + tempMedia.get(5) + " acima da média no mês de Junho");
                    break;
                }
            }    
        }

    }
}
