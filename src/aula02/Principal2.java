package aula02;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Principal2 {

    public static void main(String[] args) throws InterruptedException {


        // PERIOD, DURATION

        var primeiraData = LocalDate.of(2000, 1, 1);
        var segundaData = LocalDate.now();

        Period period = Period.between(primeiraData, segundaData);

        System.out.println("anos: "+ period.getYears());
        System.out.println("meses: "+ period.getMonths());
        System.out.println("dias: "+ period.getDays());


        // DURATION

        LocalTime antes = LocalTime.of(21, 0, 10);
        LocalTime depois = LocalTime.now();

        var antesldt = LocalDateTime.of(2023, 2, 28, 20, 16,0,0);
        var agoraldt = LocalDateTime.now();

        Duration duracao = Duration.between(antesldt, agoraldt);
        System.out.println(duracao.toHours());

        // INSTANT

        Instant inicio = Instant.now();
        long inicioMillis = System.currentTimeMillis();
        // BLOCO DE CODIGO
        Thread.sleep(2000);
        long fimMillis = System.currentTimeMillis();
        Instant fim = Instant.now();

        Duration duracao1 = Duration.between(inicio, fim);
        long duracaoEmSegundos = duracao1.toMinutes();
        System.out.println("Duracao em minutos: " + duracaoEmSegundos);
        System.out.println("Duracao em millisegundos: " + (fimMillis-inicioMillis));

        var primeiro = LocalDate.of(2000, 3, 1);
        var segundo = LocalDate.of(2000, 3, 2);

    }
}
