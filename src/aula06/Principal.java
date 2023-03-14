package aula06;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) throws IOException {

        // Coletores usando agrupamentos, partições e mapeamentos

        // groupingBy()

        // map.get(13).size();


        var pessoas = List.of(new Pessoa6("joao", 23),
                new Pessoa6("maria", 40),
                new Pessoa6("enzo", 17),
                new Pessoa6("ricardo", 17),
                new Pessoa6("carlos", 33),
                new Pessoa6("gael", 17));

        Map<Integer, Set<Pessoa6>> agrupaPessoas = pessoas
                .stream()
                .filter(pessoa6 -> pessoa6.idade() != null)
                .collect(Collectors.groupingBy(
                        Pessoa6::idade,
                        TreeMap::new,
                        Collectors.toCollection(HashSet::new)));

        System.out.println("Agrupamento de pessoas: " + agrupaPessoas);


        Map<Integer, Long> collect =  pessoas
                .stream()
                .filter(pessoa6 -> pessoa6.idade() != null)
                .collect(Collectors.groupingBy(
                        Pessoa6::idade,
                        Collectors.counting()
                )); // 17=2, 23=1, 40=1, 33=1


        Map<Integer, Optional<Character>> collect2 = pessoas.stream()
                        .collect(Collectors.groupingBy(
                                Pessoa6::idade,
                                Collectors.mapping(
                                        pessoa6 -> pessoa6.nome().charAt(0),
                                        Collectors.maxBy(Character::compareTo)
                                )
                        ));



        Map<Integer, Optional<Pessoa6>> collect3 = pessoas
                .stream()
                .filter(pessoa6 -> pessoa6.idade() != null)
                .collect(Collectors.groupingBy(
                        Pessoa6::idade,
                        Collectors.maxBy(Comparator.comparing(Pessoa6::nome))
                ));


        System.out.println(collect3);

        // Map<Boolean, List<Pessoa6>>

        // true = Pessoa6.ricardo, Pessoa6.enzo
        // false = Pessoa6.carlos


        Map<Boolean, List<Pessoa6>> particionamento = pessoas.stream()
                .collect(Collectors.partitioningBy(
                        pessoa6 -> pessoa6.idade() >= 18
                ));

        Map<Boolean, Set<Pessoa6>> particionamentoSet = pessoas.stream()
                .collect(Collectors.partitioningBy(
                        pessoa6 -> pessoa6.idade() >= 18,
                        Collectors.toSet()
                ));

        Map<Boolean, Long> particionamentoMap = pessoas.stream()
                .collect(Collectors.partitioningBy(
                        pessoa6 -> pessoa6.idade() >= 18,
                        Collectors.counting()
                ));

        System.out.println(particionamentoMap);

    }

}

record Pessoa6(String nome, Integer idade){}