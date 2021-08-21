package aula2.src;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Honda extends Carro {
  private String modelo;
  private Integer ano;
  private String placa;
  private Double valor;
  private Date dataCompra;
  private Boolean usado;

  private final SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yy");

  private final String PLACA_INVALIDA = "\nCódigo de placa inválido! Código deve ter 7 caracteres";
  private final String DATA_INVALIDA = "\nData inválida! Não é permitido realizar utilizar data superior a do dia atual";
  private final String ANO_INVALIDO = "\nAno inválido! Máximo de +1 ano sob ano atual";

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public Integer getAno() {
    return ano;
  }

  public void setAno(Integer ano) throws Exception {
    int anoAtual = new Date().getYear() + 1900;
    int anoMax = anoAtual + 1;
    if(ano <= anoMax){
      this.ano = ano;
    } else {
      throw new Exception(ANO_INVALIDO);
    }
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) throws Exception {
    if (placa.length() == 7){
      this.placa = placa.toUpperCase();
    } else {
      throw new Exception(PLACA_INVALIDA);
    }
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public Date getDataCompra() {
    return dataCompra;
  }

  public String getDataCompraFormatada() {
    return formatoData.format(dataCompra);
  }

  private Date stringToDate(String dt) throws Exception {
    return formatoData.parse(dt);
  }

  public void setDataCompra(String dataCompra) throws Exception  {
    Date data = stringToDate(dataCompra);

    if(data.before(new Date()) || data.equals(new Date())){
      this.dataCompra = data;
    } else {
      throw new Exception(DATA_INVALIDA);
    }
  }

  public Boolean isUsado() {
    return usado ? true : false;
  }

  public void setCondicao(Boolean usado){
    this.usado = usado;
  }
  
  public void imprimirHonda() {
    imprimirCarro();
    sout.println(""
      + "Modelo: " + modelo
      + "\nAno: " + ano
      + "\nPlaca: " + placa
      + "\nValor: R$" + valor
      + "\nData Compra: " + getDataCompraFormatada()
      + "\nCondição: " + (isUsado() ? "Usado" : "Novo")
    );
  }

  public Honda() {
    super();
    modelo = "";
    ano = 0;
    placa = "FFFFFFF";
    valor = 0d;
    dataCompra = new Date();
    usado = false;
  }

  public Honda(Double combustivel, Double capacidadeTanque, Integer numeroPortas, Double litroPorKm,
    String modelo, Integer ano, String placa, Double valor, String dataCompra, Boolean usado) throws Exception {
    super(combustivel, capacidadeTanque, numeroPortas, litroPorKm);
    setAno(ano);
    setPlaca(placa);
    setDataCompra(dataCompra);
    this.modelo = modelo;
    this.valor = valor;
    this.usado = usado;
  } 
}
