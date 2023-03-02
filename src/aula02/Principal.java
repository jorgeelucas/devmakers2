package aula02;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Principal {

    public static void main(String[] args) {


        // DATAS COM FUSO HORARIO

        // OffsetDateTime
        OffsetDateTime offsetDateTime =
                OffsetDateTime.of(2023, 3, 1, 9, 0, 0, 0, ZoneOffset.of("-05:00"));
        System.out.println(offsetDateTime);

        // UTC
        LocalDateTime localDateTime = LocalDateTime.parse("2023-03-01T20:10");

        ZoneId fusoAC = ZoneId.of("Brazil/Acre");
        ZoneId fusoSP = ZoneId.of("America/Sao_Paulo");
        ZoneId fusoLisboa = ZoneId.of("Europe/Lisbon");

        ZonedDateTime agoraFusoAC = ZonedDateTime.of(localDateTime, fusoAC);

        System.out.println(agoraFusoAC);

        var partida = ZonedDateTime.of(2023, 3, 1, 10, 10, 0, 0, ZoneId.of("America/New_York"));
        var chegada = ZonedDateTime.of(2023, 3, 1, 18, 10, 0, 0, ZoneId.of("America/Sao_Paulo"));

        System.out.println("Partida: " + partida);
        System.out.println("Chegada: " + chegada.withZoneSameInstant(ZoneId.of("America/New_York")));

        var horaAtual = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        var horaConvertida = horaAtual.withZoneSameInstant(ZoneId.of("Europe/Lisbon"));

        System.out.println("Hora atual: " + horaAtual);
        System.out.println("Hora convertida: " + horaConvertida);


        // INSTANT

        // 1/1/1970

        // classes que marcam um ponto

        // INSTANT, OFFSETDATETIME, ZONEDDATETIME

        // LOCALDATE, LOCALTIME E LOCALDATETIME

        LocalDate dataAgora = LocalDate.now();

        // with

        LocalDate novaData = dataAgora
                .withYear(2024)
                .withMonth(1);

        System.out.println(novaData);

        LocalTime horaFechada = LocalTime.now()
                .truncatedTo(ChronoUnit.HOURS);

        System.out.println(horaFechada);

    }

}
