package aula05;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CorrecaoAula4 {

    public static void main(String[] args) {
        var pessoas = List.of(new PessoaExercicio("joao", 21),
                new PessoaExercicio("marcelo", 17),
                new PessoaExercicio("maria", 33),
                new PessoaExercicio("marcela", 43),
                new PessoaExercicio("caio", 11),
                new PessoaExercicio("Icaro", 19),
                new PessoaExercicio("Alberto", 19),
                new PessoaExercicio("joana", 15));

        List<String> nomesMaioresDeIdade = pessoas.stream()
                .filter(pessoa -> pessoa.idade() > 18)
                .sorted(Comparator.comparing(PessoaExercicio::idade)
                        .thenComparing(PessoaExercicio::nome))
                .map(PessoaExercicio::nome)
                .limit(3)
                //.collect(Collectors.toList());
                .toList(); // lista imutavel - java 17

        //nomesMaioresDeIdade.removeIf(nome -> nome.startsWith("j"));

        System.out.println(nomesMaioresDeIdade);
    }

}


record PessoaExercicio(String nome, int idade) {
}
