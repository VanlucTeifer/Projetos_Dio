import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExemploSet {
    public static void main(String[] args) throws Exception {
        System.out.println("Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:"); 
        // Set notas = new HashSet(); // Antes do Java 5
        // HashSet<Double> = new HashSet<>();
        // Set<Double> notas = new HashSet<>(); // Generics (JDK 5) - Diamond Operator (JDK 7)
        /*Set<Double> notas = Set.of(7.0, 8.5, 9.3, 5d, 7d, 0d, 3.6);
        notas.add(1d);
        notas.remove(5d);
        System.out.println(notas);*/

        System.out.println("Crie um conjunto e adicione as notas");
        Set<Double> notas = new HashSet<>(Arrays.asList(7.0, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas.toString());

        // System.out.println("Exiba a posição da nota 5: "); //Não é possivel trabalhar com posição no Set

        // System.out.println("Adiciona "); //Não é possível trabalhar com posição no Set

        // System.out.println("Substitua a nota 5 pela nota 6"); //Não é possível substituir as notas

        System.out.println("Confira se a nota 5 está no conjunto: " + notas.contains(5d));

        // System.out.println("Exiba a terceira nota adicionada"); //Não é possivel pois não tem o metodo get

        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        System.out.println("Exiba a maior nota: " + Collections.max(notas));
        
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exiba a soma do valores: " + soma);

        System.out.println("Exiba a média das notas: " + (soma/notas.size()));

        System.out.println("Remova a nota 0");
        notas.remove(0d);
        System.out.println(notas);

        // System.out.println("Remova a nota da posição 0"); //Set não trabalha com posição

        System.out.println("Remova as notas menores que 7 e exiba a lista");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()) {
            Double next = iterator1.next();
            if(next < 7) iterator1.remove();
        }
        System.out.println(notas);

        System.out.println("Exiba todas as notas na ordem em que foram informadas");
        Set<Double> notas2 = new LinkedHashSet<>();//LinkedashSet não permite repetição
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        // notas2.add(7d); //Não permite repetição
        notas2.add(0d);
        notas2.add(3.6);
        System.out.println(notas2);

        System.out.println("Exba todas as notas na ordem crescente");
        Set<Double> notas3 = new TreeSet<>(notas2); //notas2 sé é permitido por possuir Comparable na classe
        System.out.println(notas3);

        System.out.println("Apague todo o conjunto");
        notas.clear();

        System.out.println("Confira se o conjunto está vazio: " + notas.isEmpty());
        System.out.println("Confira se o conjunto 2 está vazio: " + notas2.isEmpty());
        System.out.println("Confira se o conjunto 3 está vazio: " + notas3.isEmpty());
    }
}
