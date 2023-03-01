package aula01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CorrecaoExercicioAula01 {

    public static void main(String[] args) {

        //String data = "2023-12-25";
        String data = "25/12/2023";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate localDate = LocalDate.parse(data, formatter);

        System.out.println(localDate);

        String hora = "22:10";

        LocalTime localTime = LocalTime.parse(hora);

        System.out.println(localTime);

        //String dataHora = "2023-12-25T22:10";
        String dataHora = "25/12/2023 22:10:15";

        LocalDateTime localDateTime =
                LocalDateTime.parse(dataHora, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        System.out.println(localDateTime);


    }

}
