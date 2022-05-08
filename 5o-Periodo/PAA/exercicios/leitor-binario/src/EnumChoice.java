import java.util.ArrayList;
import java.util.List;

public enum EnumChoice {
    INSERIR((short) 1, "1 - Inserir Serviço"),
    DELETAR((short) 2, "2 - Deletar Serviço"),
    BUSCAR((short) 3, "3 - Buscar Serviço"),
    LISTAR((short) 4, "4 - Listar Serviços");

    private final Short codigo;
    private final String descricao;

    private EnumChoice(Short codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static EnumChoice get(Object value) throws Exception {
        for (EnumChoice value1 : values()) {
            if (String.valueOf(value).equalsIgnoreCase(String.valueOf(value1.codigo))) {
                return value1;
            }
        }
        throw new Exception("Escolha não encontrada!");
    }

    /**
     * @return the codigo
     */
    public Short getCodigo() {
        return codigo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    public static List<String> getStrListValues() {
        List<String> data = new ArrayList();

        for (EnumChoice c : values()) {
            data.add(c.getDescricao());
        }

        return data;
    }
}
