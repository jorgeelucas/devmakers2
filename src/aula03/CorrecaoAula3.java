package aula03;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CorrecaoAula3 {

    public static void main(String[] args) {

        var data = getDataComSupplier(() -> LocalDate.now().plusDays(3));

        System.out.println(data);

        Supplier<LocalDate> fornecedor = LocalDate::now;

        Double numeroDobrado = tratar(2D, (num) -> num * num);
        System.out.println(numeroDobrado);


        List<String> numeros = List.of("um", "dois", "tres", "quatro");

        Consumer<String> impressor = (numero) -> System.out.println(numero);

        Predicate<Integer> isPar = (numero) -> numero % 2 == 0;
        Predicate<Integer> isMenorQue10 = (numero) -> numero < 10;

        Predicate<Integer> isParOuMaiorQue10 = isPar.and(isMenorQue10).negate();

        List<Integer> integers = List.of(1, 2, 8, 7, 12, 14, 4).stream()
                .filter(isParOuMaiorQue10)
                .toList();

        System.out.println(integers);

        numeros.forEach(impressor);

    }

    public static Double tratar(Double numero, Function<Double, Double> dobrar) {
        // log
        return dobrar.apply(numero);
    }

    public static LocalDate getDataComSupplier(Supplier<LocalDate> fornecedor) {
        var data = fornecedor.get();

        if (LocalDate.now().isAfter(data)) {
            throw new RuntimeException("Data vencida");
        }
        return data;
    }

}
