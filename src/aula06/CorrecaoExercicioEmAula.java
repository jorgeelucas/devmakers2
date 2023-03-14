package aula06;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CorrecaoExercicioEmAula {

    public static void main(String[] args) {

        // {compras=225.0, alimentação=60.0, lazer=130.0, transporte=65.0}

        // groupingBy + mapping

        Map<Transaction.Categoria, DoubleSummaryStatistics> collect = getTransacoes().stream()
                .collect(Collectors.groupingBy(
                        Transaction::cat,
                        Collectors.mapping(
                                Transaction::valor,
                                Collectors.summarizingDouble(valor -> valor)
                        )
                ));

        double average = collect.get(Transaction.Categoria.TRANSPORTE).getAverage();
        long count = collect.get(Transaction.Categoria.TRANSPORTE).getCount();
        double max = collect.get(Transaction.Categoria.TRANSPORTE).getMax();
        double sum = collect.get(Transaction.Categoria.TRANSPORTE).getSum();

        System.out.printf("Media: %.2f\n", average);
        System.out.println("Qtd: " + count);
        System.out.println("Maxima: " + max);
        System.out.println("Soma: " + sum);

        System.out.println(collect);

    }

    public static List<Transaction> getTransacoes() {
        return List.of(
                new Transaction(Transaction.Categoria.COMPRA, 100.0),
                new Transaction(Transaction.Categoria.COMPRA, 50.0),
                new Transaction(Transaction.Categoria.COMPRA, 75.0),
                new Transaction(Transaction.Categoria.ALIMENTACAO, 40.0),
                new Transaction(Transaction.Categoria.ALIMENTACAO, 20.0),
                new Transaction(Transaction.Categoria.TRANSPORTE, 30.0),
                new Transaction(Transaction.Categoria.TRANSPORTE, 15.0),
                new Transaction(Transaction.Categoria.TRANSPORTE, 20.0),
                new Transaction(Transaction.Categoria.LAZER, 80.0),
                new Transaction(Transaction.Categoria.LAZER, 50.0));
    }

}

record Transaction(Categoria cat, double valor){
    public enum Categoria {
        COMPRA, ALIMENTACAO, TRANSPORTE, LAZER
    }
}
