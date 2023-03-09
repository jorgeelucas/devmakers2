package aula05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Principal {

    public static void main(String[] args) {

        // flatMap

        Stream<Integer> umdoistres = Stream.of(1, 2, 3);
        Stream<Integer> quatrocincoseis = Stream.of(4, 5, 6);
        Stream<Integer> seteoitonome = Stream.of(7, 8, 9);

        Stream.of(umdoistres, quatrocincoseis, seteoitonome)
                .flatMap(Function.identity())
                .forEach(System.out::println);

        List<List<String>> primeira = List.of(List.of("um", "dois", "tres"), List.of("quatro", "cinco", "seis"), List.of("sete", "oito", "novo"));
        List<List<String>> segunda = List.of(List.of("dez", "onze", "doze"), List.of("treze", "quatorze", "quinze"), List.of("dezesseis", "dezessete", "dezoito"));
        List<List<String>> terceira = List.of(List.of("dezenove", "vinte", "vinte e um"), List.of("vinte e dois", "vinte e trez", "vinte e quatro"), List.of("vinte e cinco", "vinte e seis", "vinte e sete"));

        List<String> strings = Stream.of(primeira, segunda, terceira)
                .flatMap(lista -> lista.stream())
                .flatMap(Collection::stream)
                .toList();

        System.out.println("lista: " + strings);


        // distinct()
        var listaDeInteirosDistintos = Stream.of(1,2,3,5,3,4,6,2,3,1)
                .sorted()
                .distinct()
                .toList();

        // limit() | skip()

        List<Integer> integers = Stream.of(1, 2, 3, 5, 3, 4, 6, 2, 3, 1)
                .skip(1)
                .limit(3)
                .toList();

        // map(Function#apply)

        // peek(Consumer#accept)

        List<String> nomes = List.of("jorge", "maria");

        long qtd = nomes.stream()
                .filter((nome) -> true)
                .peek(__ -> System.out.println("Processando pessoas..."))
                .count();

        System.out.println("qtd: " + qtd);


        System.out.println("Integers: " + integers);

        // == -> endereco na memoria/referencia
        // equals()

        //System.out.println(listaDeInteirosDistintos);


        // pool de String

        String palavra1 = new String("jorge");
        String palavra2 = new String("jorge");

        //System.out.println("Comparando: " + (palavra1.equals(palavra2)));

        var pessoas = Stream.of(
                new Pessoa("maria", "123"),
                new Pessoa("joao", "124"),
                new Pessoa("maria", "123"),
                new Pessoa("icaro", "456"))
                .toList();

        var pessoasDistintas = pessoas.stream()
                .distinct()
                .toList();

        //pessoasDistintas.forEach(System.out::println);

    }

}

record Pessoa(String nome, String cpf) {
}
