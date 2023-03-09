package aula05;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal3 {

    public static void main(String[] args) {

        Stream<String> alimentosStream = Stream.of("feijao", "arroz", "agua", "carne", "banana");

        //Set<String> collect = alimentosStream.collect(Collectors.toSet());

        // joining()

        // feijao, arroz, agua

        //String alimentosString = alimentosStream.collect(Collectors.joining(", "));

        //System.out.println(alimentosString);

        // averagingInt(), averagingLong() e averagingDoble()

//        double average = alimentosStream
//                .mapToInt(alimento -> alimento.length())
//                .average()
//                .getAsDouble();

//        double average = alimentosStream
//                .collect(Collectors.averagingInt(String::length));

        //System.out.println("Media de letras das palavras: " + average);

//        Set<String> collect = alimentosStream
//                .filter(alimento -> alimento.startsWith("a"))
//                .collect(Collectors.toCollection(TreeSet::new));
//
//        System.out.println(collect);

        // transformando em map

        // feijao, arroz, agua e arroz

        // key-valor
        // feijao=6, arroz=5, agua=4

//        Map<Integer, String> collect = alimentosStream.collect(Collectors.toMap(
//                String::length,
//                Function.identity()));
//
//        System.out.println(collect);

        // feijao, arroz, agua e arroz

//        Map<Integer, String> collect = alimentosStream.collect(Collectors.toMap(
//                String::length,
//                Function.identity(),
//                (a, b) -> a + ", " + b));

        TreeMap<Integer, String> collect = alimentosStream.collect(Collectors.toMap(
                String::length,
                Function.identity(),
                (a, b) -> a + ", " + b,
                () -> new TreeMap<>()));


        System.out.println(collect);


    }

}
