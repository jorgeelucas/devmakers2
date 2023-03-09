package aula05;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.DoubleSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Principal2 {

    public static void main(String[] args) {

        // Streams de primitivos

        // int, short, byte e char
        IntStream.of(1,2,3,4,5);

        // Long
        LongStream.of(2L);

        // double, float
        DoubleStream.of(2.0);


        // operacoes

        IntStream.range(1, 10);

        long sum = LongStream.range(1, 100)
                .sum();

        System.out.println(sum);

        var pessoas = List.of(
                new PessoaExercicio("joao", 15),
                new PessoaExercicio("maria", 40),
                new PessoaExercicio("carlos", 34),
                new PessoaExercicio("icaro", 25));

        DoubleStream doubleStream = pessoas.stream()
                .mapToDouble(PessoaExercicio::idade);

        DoubleSummaryStatistics statistics = doubleStream.summaryStatistics();

        System.out.println("Media das idades: " + statistics.getAverage());

        System.out.println("Soma das idades: " + statistics.getSum());

        System.out.println("Menor idade: " + statistics.getMin());

        // boxed()

        IntStream intStream = IntStream.rangeClosed(0, 9);

        Stream<Integer> boxed = intStream.boxed();

        // mapToObj()

        IntStream idadesIntStream = IntStream.of(15, 40);

        List<PessoaExercicio> pessoaExercicios = idadesIntStream.mapToObj(Principal2::buscarPorIdade)
                .toList();

        System.out.println(pessoaExercicios);

        // Optional de primitivos

        // OptionalDouble
        // OptionalInt
        // OptionalLong

        OptionalLong optionalLong = LongStream.range(0, 10).max();

        // Supplier
        // DoubleSupplier
        // LongSupplier

        System.out.println(optionalLong.getAsLong());

        IntStream ints = IntStream.rangeClosed(0, 10);
        int interval = rangeInterval(ints);

        System.out.println("Interval: " + interval);
    }

    private static int rangeInterval(IntStream ints) {
        IntSummaryStatistics statistics = ints.summaryStatistics();
        if (statistics.getCount() > 0) {
            return statistics.getMax() - statistics.getMin();
        }
        return 0;
    }

    private static PessoaExercicio buscarPorIdade(int idade) {
        return List.of(new PessoaExercicio("joao", 15),
                new PessoaExercicio("maria", 40),
                new PessoaExercicio("carlos", 34),
                new PessoaExercicio("icaro", 25))
                .stream()
                .filter(pessoaExercicio -> pessoaExercicio.idade() == idade)
                .findFirst()
                .get();
    }

}
