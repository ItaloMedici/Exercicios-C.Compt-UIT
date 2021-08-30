package aula2.exercicios.boleto;

import java.util.Date;
// Lib customizada
import utils.FormatterUtil;

public class Main {
    public static void main(String[] args) {
        Boleto b = new Boleto(new Date(), 2500d, 500d, "Italo");

        System.out.println(""
            + "\nValor Bruto: " + FormatterUtil.formatarEmReais(b.getValor())
            + "\nValor Desconto: " + FormatterUtil.formatarEmReais(b.getDesconto())
            + "\nValor líquido: " + FormatterUtil.formatarEmReais(b.getValorLiquido())
            + "\nData Vencimento: " + FormatterUtil.dataEmStr(b.getVencimento())
        );
        System.out.println("O Boleto esta: " + (b.isPago() ? "Pago" : "Aberto"));
        b.pagar();
        System.out.println("Pagando....\nO Boleto esta: " + (b.isPago() ? "Pago" : "Aberto"));
    }
}
