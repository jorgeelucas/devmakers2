package aula05;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CorrecaoAula5 {

    public static void main(String[] args) {


        // Rodolfo

        // Dado uma lista de inteiros, encontre a soma de todos os numeros da lista;

        List<Integer> inteiros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> listaDeNumeros = new ArrayList<>(inteiros);

        IntSummaryStatistics stats = listaDeNumeros
                .stream()
                .collect(Collectors.summarizingInt(valor -> valor));

        System.out.println("A soma dos valores é: " + stats.getSum());

        Optional<Integer> resultadoOptional = listaDeNumeros
                .stream()
                .reduce(Integer::sum);

        System.out.println("Resultado é: " + resultadoOptional.get());

        // Dado uma lista de pessoas, agrupe os nomes por idade;

        // Diego
        var pessoas = List.of(new Pessoa5("joao", 23),
                new Pessoa5("maria", 40),
                new Pessoa5("enzo", 17),
                new Pessoa5("ricardo", 33),
                new Pessoa5("carlos", 33),
                new Pessoa5("gael", 17));

        Map<Integer, List<Pessoa5>> agrupaPessoas = pessoas
                .stream()
                .collect(Collectors.groupingBy(Pessoa5::idade));

        System.out.println("Agrupamento de pessoas: " + agrupaPessoas);


        //thomas
        Map<Integer, String> agrupaNomesPessoas = pessoas
                .stream()
                .collect(Collectors.toMap(
                        pessoa -> pessoa.idade(),
                        pessoa -> pessoa.nome(),
                        (a, b) -> a + "," + b
                ));

        System.out.println("Agrupamento de nomes de pessoas: " + agrupaNomesPessoas);


        // vitor

        var funcionarios = List.of(new Funcionario("joao", Funcionario.Departamento.RECURSO_HUMANO, new BigDecimal(1350.0)),
                new Funcionario("maria", Funcionario.Departamento.RECURSO_HUMANO, new BigDecimal(1200.0)),
                new Funcionario("caio", Funcionario.Departamento.LIMPEZA, new BigDecimal(1100.0)),
                new Funcionario("bruno", Funcionario.Departamento.LIMPEZA, new BigDecimal(1150.0)),
                new Funcionario("joana", Funcionario.Departamento.ENGENHARIA, new BigDecimal(2000.0)),
                new Funcionario("icaro", Funcionario.Departamento.ENGENHARIA, new BigDecimal(1800.0)),
                new Funcionario("ivana", Funcionario.Departamento.ENGENHARIA, new BigDecimal(2200.0)));


        Stream<Funcionario> funcionarioStream = funcionarios
                .stream()
                .filter(funcionario -> funcionario.departamento().equals("ENG"));

//        double media = funcionarios
//                .stream()
//                .filter(funcionario -> funcionario.departamento().equals("ENG"))
//                .mapToDouble(Funcionario::salario)
//                .summaryStatistics()
//                .getAverage();
//
//        System.out.println("Media: " + media);

        // ENG=2000, LIMP=1275, RH=1125

        Map<Funcionario.Departamento, Double> collect = funcionarios
                .stream()
                .collect(Collectors.groupingBy(Funcionario::departamento,
                        Collectors.averagingDouble(funcionario -> funcionario.salario().doubleValue())));

//        funcionarios
//                .stream()
//                        .collect(Collectors.toMap(
//                                Funcionario::departamento,
//                                funcionario -> funcionario.salario(),
//                                (x, y) -> x.add(y) / 2
//                        ))

        System.out.println("Media por departamento: " + collect);

        // felipe

        var transacoes = List.of(new Transacao("felipe", 4, true),
                new Transacao("laura", 7, true),
                new Transacao("felipe", 10, true),
                new Transacao("laura", 7, false),
                new Transacao("laura", 7, true),
                new Transacao("laura", 7, false),
                new Transacao("laura", 7, false),
                new Transacao("robertinho", 20, true));


        Map<String, Integer> collect1 = transacoes
                .stream()
                .filter(Transacao::verdadeiro)
                .collect(Collectors.toMap(
                        Transacao::nomePessoa,
                        transacao -> 1,
                        (x, y) -> ++x
                ));

        System.out.println("Collect1: " + collect1);

        var novaLista = transacoes
                .stream()
                .collect(Collectors.toMap(
                        Transacao::nomePessoa,
                        transacao -> 1,
                        (x, y) -> ++x
                ));

        System.out.println("Nova lista: " + novaLista);
    }

}

record Transacao (String nomePessoa, Integer qtd, boolean verdadeiro){}

record Funcionario(String nome, Departamento departamento, BigDecimal salario){

    public enum Departamento {
        LIMPEZA, RECURSO_HUMANO, ENGENHARIA
    }
}


record Pessoa5(String nome, int idade){}