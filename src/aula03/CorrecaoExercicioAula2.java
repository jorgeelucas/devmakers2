package aula03;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class CorrecaoExercicioAula2 {

    public static void main(String[] args) {

        /**
         *
         * Solucao do Arthur
         *
         * 2. A partir da data atual, calcule e imprima uma compra de R$ 64.000,00
         * parcelado em 48x, imprima o valor e a data de cada parcela usando a nova API de datas do Java.
         * Obs.: com uma nova regra;
         * Caso a data do pagamento seja no final de semana, a data do pagamento deve ser postergada para
         * a primeira segunda feira subsequente, porém sem alterar a data dos próximos pagamentos!
         * */


        var dataAtual = LocalDate.now();

        BigDecimal valorCompra = new BigDecimal("64000");
        BigDecimal parcelas = new BigDecimal("48");
        BigDecimal valorParcelas = valorCompra.divide(parcelas, 2, RoundingMode.HALF_EVEN);

        for (int i = 1; i < 49; i++) {
            LocalDate dataPagamentoParcela = dataAtual.plusMonths(i);

            //if (dataPagamentoParcela.getDayOfWeek().getValue() >= 6)
            if (dataPagamentoParcela.getDayOfWeek().equals(DayOfWeek.SATURDAY)
                || dataPagamentoParcela.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {

                dataPagamentoParcela = dataAtual.plusMonths(i)
                        .with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            }

            System.out.println(
                    i
                    + ": valor="
                    + valorParcelas
                    + ": "
                    + dataPagamentoParcela.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            );
        }


    }
}
