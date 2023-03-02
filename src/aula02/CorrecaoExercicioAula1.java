package aula02;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class CorrecaoExercicioAula1 {

    public static void main(String[] args) {

        /**
         * A partir da data atual, calcule e imprima uma compra de R$ 64.000,00
         * parcelado em 48x. Imprima o valor e a data de cada parcela usando a nova API de datas do Java.
         * */

        /**
        - Solucao do wesley

        final String PRECO_TOTAL = "64000";
        final String NUMERO_PARCELAS = "48";

        LocalDate agora = LocalDate.now();

        var valorTotal = new BigDecimal(PRECO_TOTAL).divide(BigDecimal.ONE, 2, RoundingMode.FLOOR);

        System.out.println("Valor total a ser pago: R$ " + valorTotal);

        var nrParcelasBD = new BigDecimal(NUMERO_PARCELAS);

        BigDecimal valorParcela = valorTotal.divide(nrParcelasBD, 2, RoundingMode.FLOOR);

        for (int i = 1; i <= Integer.parseInt(NUMERO_PARCELAS); i++) {

            String mensagem = "%02d° Parcela de R$ %s a ser paga dia: %s"
                    .formatted(i, valorParcela, agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            System.out.println(mensagem);

            agora = agora.plusMonths(1);
        }
         */

        /**
        - Solucao Bethania
        LocalDate dataAtual = LocalDate.now();

        BigDecimal valor = new BigDecimal("64000");
        BigDecimal parcela = new BigDecimal("48");

        BigDecimal valorParcela = valor.divide(parcela, 2, RoundingMode.UP);

        Integer contador = 1;

        while (contador<=48) {
            System.out.println("_____");
            System.out.println("Parcela = " + contador);
            System.out.println("Valor = " + valorParcela);
            parcela = parcela.subtract(BigDecimal.ONE);
            valor = valor.subtract(valorParcela);

            if (valor.intValue() > 0) {
                System.out.println("Valor restante: " + valor);
            }

            System.out.println("Data de pagamento: " + dataAtual.plusMonths(contador));
            contador++;
            System.out.println("_____");
        }
         */

        // solucao arthur
        var valorCompra = new BigDecimal("64000");
        var valorParcela = valorCompra.divide(new BigDecimal("48"), 2, RoundingMode.HALF_EVEN);

        LocalDate dataParcela = LocalDate.now();

        for (int i = 1; i < 49; i++) {
            System.out.println(i + " parcela: R$" + valorParcela + " em " + dataParcela.plusMonths(i));
        }

    }

}
