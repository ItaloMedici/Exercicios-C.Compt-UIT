package utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Italo Médici
 */

public class FormatterUtil {
    private static final String DUAS_CASAS = "#,##0.00";
    private static final String CURRECY = "¤#,##0.00;¤-#,##0.00";
    private static final String DD_MM_YYYY = "dd/MM/yyyy";

    // Formatadores de numero
    public static String formatarNumeroDuasCasas(Double numero) {
        if (numero == null)
            return "";

        DecimalFormat d = new DecimalFormat(DUAS_CASAS);
        return d.format(numero);
    }

    public static String formatarEmReais(Double numero) {
        if (numero == null)
            return "";

        DecimalFormat d = new DecimalFormat(CURRECY);
        return d.format(numero);
    }

    public static String comPorcentagem(Double num) {
        return formatarNumeroDuasCasas(num) + "%";
    }

    // Datas
    public static String dataEmStr(Date data) {
        if (data == null) {
            return "";
        }

        SimpleDateFormat sd = new SimpleDateFormat(DD_MM_YYYY);
        return sd.format(data);
    }

    public static Date strEmData(String data) {
        try {
            if (data != null) {
                SimpleDateFormat d = new SimpleDateFormat(DD_MM_YYYY);
                Date tempDate = d.parse(data);
                if (!d.format(tempDate).equals(data)) {
                    throw new ParseException("", 5);
                } else {
                    return tempDate;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Formatadores de String
    public static String formatarTelefone(String telefone) {
        String tel2 = "";

        if (telefone.length() == 11) {
            tel2 = "(" + telefone.substring(0, 2) + ") " 
            + telefone.substring(2, 7) + "-" 
            + telefone.substring(7, 11);
        }

        return tel2;
    }

    public String formatarDocumentos(String documento) {

        String cpf = documento.substring(0, 3) + "."
        + documento.substring(3, 6) + "."
        + documento.substring(6, 9) + "-"
        + documento.substring(9, 11);
        
        String cnpj = documento.length() == 14
        ? documento.substring(0, 2) + "."
        + documento.substring(2, 5) + "."
        + documento.substring(5, 8) + "/"
        + documento.substring(8, 12) + "-"
        + documento.substring(12, 14) 
        : documento;

        return documento.length() == 11 ? cpf : cnpj;
    }
}
