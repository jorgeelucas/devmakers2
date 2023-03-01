package aula01;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Principal2 {

    public static void main(String[] args) {

        // METODOS AUXILIARES

        LocalDate agora = LocalDate.now();

        LocalDate after3weeks = agora.plusWeeks(3);

        System.out.println(after3weeks);

        after3weeks = after3weeks.plusDays(3);

        System.out.println(after3weeks);

        LocalTime horaAgora = LocalTime.now();

        LocalTime agoraMais4 = horaAgora.plusHours(4);

        System.out.println(horaAgora);
        System.out.println(agoraMais4);

        LocalTime agoramenos5 = horaAgora.minusHours(5);

        System.out.println(agoramenos5);

        /**
         * < 0 : hora agora é antes
         * 0   : horaAgora é igual
         * > 0 : horaAgora é depois
         * */
        int i = horaAgora.compareTo(agoramenos5);

        boolean after = horaAgora.isAfter(agoramenos5);

        LocalTime dezHoras = LocalTime.of(10, 0);
        LocalTime dezHoras2 = LocalTime.of(10, 0);
        LocalTime dezHorasMais3 = dezHoras.plusHours(3);

        boolean before = dezHoras.isBefore(dezHorasMais3);

        boolean ehIgual = dezHoras.equals(dezHoras2);

        boolean leapYear = LocalDate.now().isLeapYear();

        System.out.println("ano bissexto: " + leapYear);

        System.out.println("after: " + after);
        System.out.println("before: " + before);
        System.out.println("igual: " + ehIgual);

        DayOfWeek dayOfWeek = LocalDate
                .of(2023, 2, 20)
                .getDayOfWeek();

        int nrDia = dayOfWeek.getValue();

        System.out.println(nrDia);

        // CONVERTENDO STRING EM DATAS


//        String dataNascimento = "2000-02-20";
        String dataNascimento = "15/03/2000";

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/M/yyyy");

        LocalDate nas = LocalDate.parse(dataNascimento, pattern);

        //String formatted = "%02d/%02d/%d".formatted(15, 11, 2000);

        String dataFormatada = nas.format(pattern);

        System.out.println("parse: nascimento: " + dataFormatada);


        String horaPadrao = "22:10";

        LocalTime hora = LocalTime.parse(horaPadrao);
        System.out.println("hora: " + hora);

        // YYYY-MM-DDTHH:mm:ss
        String dataHoraPadrao = "2000-03-15T22:10:15";

//        String dataHoraObtida = "2023-01-22 09:55 AM";
//        DateTimeFormatter pattern1 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
//        LocalDateTime parse = LocalDateTime.parse(dataHoraObtida, pattern1);
//        System.out.println("AM/PM: " + parse);

        LocalDateTime dateTime = LocalDateTime.parse(dataHoraPadrao);

        BigDecimal divide = BigDecimal.TEN.divide(BigDecimal.ONE, 5);
        System.out.println(divide);


    }

}
