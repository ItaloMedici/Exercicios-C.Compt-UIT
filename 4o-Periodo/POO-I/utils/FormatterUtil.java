package utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Italo Médici
 */

public class FormatterUtil {
    private static final String DUAS_CASAS = "#,###0.00";
    private static final String CURRECY = "¤#,##0.00;¤-#,##0.00";
    private static final String DD_MM_YYYY = "dd/MM/yyyy";;

    public static String formatarNumero(Double numero) {
        if(numero == null) return "";

        DecimalFormat d = new DecimalFormat(DUAS_CASAS);
        return d.format(numero);
    }

    public static String formatarEmReais(Double numero) {
        if(numero == null) return "";

        DecimalFormat d = new DecimalFormat(CURRECY);
        return d.format(numero);
    }

    public static String dataEmStr(Date data) {
        if(data == null){
            return "";
        }

        SimpleDateFormat sd = new SimpleDateFormat(DD_MM_YYYY);
        return sd.format(data);
    }
    public FormatterUtil() {
    }
}
