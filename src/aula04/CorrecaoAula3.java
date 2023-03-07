package aula04;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.time.LocalDate;

public class CorrecaoAula3 {

    /**
     * 1. Escreva um método utilizando Predicate que recebe um número e
     * verifica se é par;
     *
     * 2. Escreva um método utilizando Function que receba um número e
     * retorne o dobro daquele número;
     *
     * 3. Escreva um método utilizando Consumer para imprimir elementos
     * de uma lista;
     *
     * 4. Escreva um método utilizando Supplier para retornar uma data
     * com o LocalDate.now();
     */

    public static void main(String[] args) {

        // 1. richard
        int num = 8;

        Predicate<Integer> par = (numero) -> numero % 2 == 0;

        if (par.test(num)) {
            System.out.println("Numero eh par");
        } else {
            System.out.println("Numero nao eh par");
        }

        // 2. Rodolfo
        double numero = 5.7;

        // ex 1
        Function<Double, Double> dobrador = (y) -> y * 2;
        System.out.println(dobrador.apply(numero));

        // ex 2
        Function<String, Integer> contadorCaracteresFunction = String::length;
        System.out.println("qtd: " + contadorCaracteresFunction.apply("jorge"));

        System.out.println(dobroDoNumero(numero, (x) -> x * 2));

        // ex 3
        dobroDoNumero(3.4, dobrador);

        // 3. Diego
        var numeros = List.of(1,2,3,4,5,6,7,8,9,10);
        Consumer<Integer> print = System.out::println;
        numeros.forEach(print);


        // 4. Felipe
        var dataAtual = pegarDataHoje(LocalDate::now);
        System.out.println(dataAtual);

    }

    public static LocalDate pegarDataHoje(Supplier<LocalDate> supplier) {
        return supplier.get();
    }

    private static double dobroDoNumero(double numero, Function<Double, Double> map) {
        double numeroDobrado = map.apply(numero);
        return numeroDobrado;
    }


}
