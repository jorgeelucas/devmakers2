package aula03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) {


        // PROGRAMAÇAO FUNCIONAL

        // DECLARATIVA vs IMPERATIVA

        /** declarativa */
//        var numeros = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
//
//        numeros.removeIf(numero -> numero % 2 != 0);
//
//        System.out.println(numeros);

        /** funcoes lambdas */

        var todosAlunos = new ArrayList<>(List.of(new Aluno("jorge", 3.5),
                new Aluno("maria", 5.5),
                new Aluno("rodrigo", 4.9),
                new Aluno("ago", 6.0),
                new Aluno("hiago", 6.0),
                new Aluno("guilherme", 7.0)));

        //Filtro filtro = new FiltrarReprovados();
        //Filtro filtro = new FiltrarAprovados();

        //todosAlunos.removeIf((a) -> a.nota()<=5);

        //todosAlunos.forEach((x) -> System.out.println(x.nota()));

        List<Aluno> aprovados = todosAlunos.stream()
                .filter((a) -> a.nota() >= 5)
                //.toList();
                .collect(Collectors.toList());

        System.out.println(aprovados);

        //aprovados.sort((aluno1, aluno2) -> aluno1.nota().compareTo(aluno2.nota())));

        aprovados.sort(Comparator
                .comparing(Aluno::nota)
                .reversed()
                .thenComparing(Aluno::nome));


        System.out.println(aprovados);
        //Comparator

    }
}
