package aula01;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
//import java.time.

public class Principal {

    public static void main(String[] args) {
        // NOVA API DE DATAS DO JAVA

        /**
        Date agora = new Date();
        Long milisegundos = agora.getTime();
        int mes = agora.getMonth();

        System.out.println(milisegundos);
        System.out.println("Mes: " + mes);

        agora.setTime(19828283);

        Calendar calendar = Calendar.getInstance();
         */

        // NOVA API DE DATAS DO JAVA
        // JAVA 8 | 1.8

        // LocalDate, LocalTime e LocalDateTime

        LocalDate dataAgora =         LocalDate.now();
        LocalTime horaAgora =         LocalTime.now();
        LocalDateTime dataHoraAgora = LocalDateTime.now();

        System.out.println("Data: " + dataAgora);
//        System.out.println("Hora: " + horaAgora);
//        System.out.println("dataHoraAgora: " + dataHoraAgora);

        LocalDate dataAmanha = dataAgora.plusDays(1);

        LocalDate amanha = LocalDate.now().plusDays(1);

        System.out.println("Data: " + dataAgora);

        LocalDate dataNascimento = LocalDate.of(2000, 4, 12);

        System.out.println("Data nascimento: " + dataNascimento);

        LocalTime horaNascimento = LocalTime.of(20, 28);

        System.out.println("Hora do nascimento: " + horaNascimento);

        LocalDateTime dataNascimentoCompleta = LocalDateTime.of(dataNascimento, horaNascimento);
        LocalDateTime dataNascimentoCompletaOutro = LocalDateTime.of(2000, 4, 12, 20, 28, 34);

        System.out.println("Data nascimento completa: " + dataNascimentoCompleta);
        System.out.println("Data nascimento completa outro: " + dataNascimentoCompletaOutro);


    }

}
