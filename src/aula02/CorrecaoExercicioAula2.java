package aula02;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class CorrecaoExercicioAula2 {

    public static void main(String[] args) {

        var dataNascimento = LocalDate.of(2000, 1, 12);

        System.out.println(dataNascimento.getDayOfWeek());

        DayOfWeek primeiroDiaDq = dataNascimento
                .with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek();

        System.out.println(primeiroDiaDq);

        DayOfWeek primeiroDiaAno = dataNascimento
                .with(TemporalAdjusters.firstDayOfYear()).getDayOfWeek();

        System.out.println(primeiroDiaAno);

    }

}
