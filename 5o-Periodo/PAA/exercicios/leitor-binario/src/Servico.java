import java.util.ArrayList;
import java.util.List;

public class Servico {
    private Long identificador;
    private String descricao;
    private Double valor;

    private static Long identifcadorControll = 0L;

    public Servico(Long identificador, String descricao, Double valor) {
        this.identificador = identificador;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Servico(String descricao, Double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public Long getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    static void updadeIDControll() {
        identifcadorControll++;
    }

    static Long getIDControll() {
        return identifcadorControll;
    }

    public static Servico toEntity(String saved) {
        String[] values = saved.split(";");

        Long id = new Long(values[0]);
        String desc = values[1];
        Double valor =  new Double(values[2].replace(",", "."));

        return new Servico(id, desc, valor);
    }

    public static List<Servico> toEntities(String[] saved) {
        List<Servico> servicos = new ArrayList();

        for (String s : saved) {
            servicos.add(toEntity(s));
        }

        return servicos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("%d - %s R$ %.2f", identificador, descricao, valor);
    }

    public String toSave() {
        return String.format("%d;%s;%.2f", identificador, descricao, valor);
    }

}
