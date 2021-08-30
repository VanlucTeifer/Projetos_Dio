import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
public class ExemploMap {
    public static void main(String[] args) throws Exception {
        /*Dado os modelos dos carros e seus respectivos consumos na estrada, faça:
          modelo = gol - consumo = 14.4km/l
          modelo = uno - consumo = 15.6km/l
          modelo = mobi - consumo = 16.1km/l
          modelo = hb20 - consumo = 14.5km/l
          modelo = kwid - consumo = 15.6km/l
        */

        //Formas de iniciar o Map
        // Map carrosPopulares2020 = new HashMap(); //Antes do Java 5
        // Map<String, Double> carrosPopulares = new HashMap<>(); //Generics (JDK 5) - Diamond Operator(JDK 7)
        // HashMap<String, Double> carrosPopulares = new HashMap<>();
        // Map<String, Double> carrosPopulares2020 = 
        // Map.of("gol", 14.4, "uno", 15.6, "mobi", 16.1, "hb20", 14.5, "kwid" 15.6);

        System.out.println("Crie um dicionário e relacione os modelos e seus respectivos consumos");
        Map<String,Double> carros = new HashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carros);

        System.out.println("Substitua o consumo do gol por 15.2 km/l");
        carros.put("gol", 15.2);
        System.out.println(carros);

        System.out.println("Confira se o modelo tucson está no dicionário: " + carros.containsKey("tucson"));

        System.out.println("Exiba o consumo do uno: " + carros.get("uno"));

        // System.out.println("Exiba o terceiro modelo adicionado: "); //MAp, igual o Set, não permite busca por posição

        System.out.println("Exiba os modelos: " + carros.keySet()); // ou Set<String> modelos = carros.keySet();

        System.out.println("Exiba os consumos dos carros: " + carros.values()); //ou Collection<Double> consumos = carros.values();

        System.out.println("Exiba o modelo mais economico e seu consumo");
        Double consumoMaisEficiente = Collections.max(carros.values());
        Set<Map.Entry<String,Double>> entries = carros.entrySet();
        String modeloMaisEficiente = "";

        for(Map.Entry<String,Double> entry: entries){
            if(entry.getValue().equals(consumoMaisEficiente)){
                modeloMaisEficiente = entry.getKey();
                System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
            } 
        }

        System.out.println("Exiba o modelo menos economico e seu consumo");
        Double consummoMenosEficiente = Collections.min(carros.values());
        String modeloMenosEficiente = "";

        for(Map.Entry<String,Double> entry : carros.entrySet()){
            if(entry.getValue().equals(consummoMenosEficiente)){
            modeloMenosEficiente = entry.getKey();
            System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consummoMenosEficiente);
            }
        }

        
        Iterator<Double> iterator = carros.values().iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Exiba a soma dos consumos: " + soma);

        System.out.println("Exiba a média do consumo deste dicionário de carros: " + (soma/carros.size()));

        System.out.println("Remova os modelos com consumo igul a 15.6km/l");
        Iterator<Double> iterator2 = carros.values().iterator();
        while(iterator2.hasNext()){
            if(iterator2.next().equals(15.6)) iterator2.remove();    
        }
        System.out.println(carros);

        System.out.println("Exiba todos os carros na ordem em que foram informados");
        Map<String, Double> carrosLhm = new LinkedHashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosLhm);

        System.out.println("Exiba o dicionário ordenado pelo modelo(key)");
        Map<String,Double> carrosTm = new TreeMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosTm.toString());

        System.out.println("Apague o dicionario de carros");
        carros.clear();

        System.out.println("Confira se o dicionário está vazio: " + carros.isEmpty());
    }
}
