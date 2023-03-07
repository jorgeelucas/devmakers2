package aula04;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Principal {
    public static void main(String[] args) {

        // STREAMS INFINITAS

//        Stream.generate(LocalTime::now)
//                .forEach(System.out::println);

//        Stream.iterate(1, n -> n + 2)
//                .forEach(System.out::println);


        // STREAMS FINITAS

//        Stream.iterate(2,
//                        (num) -> num <= 100,
//                        (num) -> num + 2)
//                .forEach(System.out::println);

        // criando stream vazia
        // Stream<String> streamVazia = Stream.empty();

        // stream com um unico elemento
        // Stream<Integer> streamDeUmElemento = Stream.of(1);

        // stream de varios elementos
        // Stream<Integer> numerosStream = Stream.of(1,2,3,4,5,6,7,8,9);

        //List<Integer> listaNumeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

//        List<Integer> numerosPares = lista
//                .stream()
//                .filter((num) -> num % 2 == 0)
//                .toList();
//
//        System.out.println(numerosPares);


        // metodo terminal count

//        List<Integer> lista = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
//
//        long qtd = lista.stream()
//                .count();
//
//        System.out.println(qtd);

        // consumindo e reutilizando a stream

//        var nomes = List.of("jorge", "maria", "joao", "mario");
//
//        Stream<String> streamNomes = nomes.stream();
//
//
//        long qtd = streamNomes.count();
//
//        nomes.stream().forEach(System.out::println);

        // Optional

        //String txt = null;
//        String txt = "jorge";
//
//        Optional<Integer> optional = Optional.ofNullable(txt)
//                .map(String::length);
//
//        if (optional.isPresent()) {
//            Integer length = optional.get();
//            System.out.println(length);
//        }
//
//        Endereco endereco = new Endereco();
//        endereco.rua = "alagoas";
//
//        Pessoa dono = new Pessoa();
//        dono.endereco = endereco;
//        dono.nome = "Joao";
//
//        Carro carro = new Carro();
//        carro.dono = dono;
//        carro.modelo = "hb2";

        //String end = carro.dono.endereco.rua;
        //System.out.println(end);

//        Optional<String> optionalS = Optional.of(carro)
//                .map(x -> x.dono)
//                .map(x -> x.endereco)
//                .map(x -> x.rua);
//
//        if (optionalS.isPresent()) {
//            String enderecoDono = optionalS.get();
//            System.out.println(enderecoDono);
//        }

        // findFirst() && findAny()
        Carro amarok = new Carro("amarok");
        amarok.dono = new Pessoa("jorge");
        amarok.preco = 245000.00;

        Carro gol = new Carro("gol");
        gol.dono = new Pessoa("jorge");
        gol.preco = 85000.00;
        var carros = List.of(new Carro("audi q3"),
                new Carro("audi a5"),
                amarok,
                gol,
                new Carro("BMW m3"));

        Optional<Carro> first = carros.stream().findFirst();
        //Optional<Carro> any = carros.stream().findAny();

        if (first.isPresent()) {
            Carro primeiro = first.get();
            System.out.println(primeiro.modelo);
        }

        // allMatch(Predicate), anyMatch(Predicate) e noneMatch(Predicate)

        Predicate<Carro> isCarroTemDono = carro -> carro.dono != null;

        boolean isTodosOsCarrosTemDono = carros.stream().allMatch(isCarroTemDono);
        System.out.println("Todos os carros tem dono? " + isTodosOsCarrosTemDono);

        boolean isAlgumCarroTemDono = carros.stream().anyMatch(isCarroTemDono);
        System.out.println("Algum carro tem dono? " + isAlgumCarroTemDono);

        boolean isNenhumCarroTemDono = carros.stream().noneMatch(isCarroTemDono);
        System.out.println("Nenhum carro tem dono? " + isNenhumCarroTemDono);

        // forEach(Consumer)

        // reduce()

        List<Integer> numeros = List.of(2, 4, 6);

        double total = carros.stream()
                .map(carro -> carro.preco)
                .reduce(0.0, (n1, n2) -> Double.sum(n1, n2));
                //.reduce(0.0, Double::sum);

        System.out.println("Total : " + total);

        Integer reduzido = numeros.stream().reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(reduzido);

        // max(), min() | Optional

        List<Integer> numerosAleatorios = List.of(4, 2, 5, 6, 1);

        Optional<Integer> optional = numerosAleatorios.stream()
                .max((n1, n2) -> Integer.compare(n1, n2));

//        Optional<Integer> optional = numerosAleatorios.stream()
//                .min((n1, n2) -> Integer.compare(n1, n2));

        var maximo = optional.get();

        System.out.println("maximo: "+maximo);


    }

}

class Carro {
    String modelo;
    Pessoa dono;
    double preco;
    public Carro(String modelo) {
        this.modelo = modelo;
    }
    public Carro() {
    }
}

class Pessoa {
    String nome;
    Endereco endereco;
    public Pessoa(String nome) {
        this.nome = nome;
    }
    public Pessoa() {
    }
}

class Endereco {
    String rua;
}