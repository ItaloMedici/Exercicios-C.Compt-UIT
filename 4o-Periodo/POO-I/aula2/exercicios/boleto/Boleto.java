package aula2.exercicios.boleto;

/* 
 * Crie a classe Boleto com os atributos vencimento, valor, desconto, um booleano se está
 * pago e nome do cliente. Crie um construtor para que todos dados sejam passados no
 * momento da instanciação dos objetos. Crie um método que retorne o valor líquido do boleto.
 * Crie também um método pagar que altera o boleto para pago.
*/

import java.util.Date;

public class Boleto {
    private Date vencimento;
    private String nomeCliente;
    private Double valor;
    private Double desconto;
    private Boolean pago;

    
    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        if(vencimento.after(new Date()) || vencimento.equals(new Date())) {
            this.vencimento = vencimento;
        } else {
            System.out.println("Data de vencimento inferior ao dia atual");
        }
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Double getValorLiquido() {
        return valor - desconto;
    }

    public Boolean isPago(){
        return pago;
    }
    
    public void pagar() {
        if(!isPago()) {
            pago = true;
        } else {
            System.out.println("Boleto já está pago!");
        }
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }


    public Boleto(Date vencimento, Double valor, Double desconto, String nomeCliente) {
        setVencimento(vencimento);
        this.valor = valor;
        this.desconto = desconto;
        this.nomeCliente = nomeCliente;
        this.pago = false;
    }

    
}
