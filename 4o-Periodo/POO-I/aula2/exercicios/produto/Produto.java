package aula2.exercicios.produto;

import utils.FormatterUtil;

public class Produto {
    private String nomeProduto;
    private Double precoCusto;
    private Double precoVenda;
    private Double margemLucro;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Double precoCusto) {
        if(precoCusto > 0){
            this.precoCusto = precoCusto;
        }
        else {
            System.out.println("Valor negativo ou igual a 0");
        }
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }
    
    public void setPrecoVenda(Double precoVenda) {
        if(precoVenda >= precoCusto){
            this.precoVenda = precoVenda;
        } else {
            System.out.println("Preço de venda inforior ao preço de custo");
        }
    }

    public Double calcMargemLucro(){
        return precoVenda > 0 && precoCusto > 0 ? precoVenda - precoCusto : 0d;
    }


    public Double getMargemLucroPorcentagem() {
        return (100 * calcMargemLucro()) / precoVenda;     
    }

    public void printProduto() {
        System.out.println(""
            + "\nNome Produto: " + nomeProduto
            + "\nPreco Custo: " + FormatterUtil.formatarEmReais(precoCusto)
            + "\nPreco Venda: " + FormatterUtil.formatarEmReais(precoVenda)
            + "\nLucro: " + FormatterUtil.formatarEmReais(calcMargemLucro())
            + "\nPorcentual de Lucro: " + FormatterUtil.comPorcentagem(getMargemLucroPorcentagem())
        );
    }

    public Produto() {
        nomeProduto = "";
        precoCusto = 0d;
        precoVenda = 0d;
        margemLucro = 0d;
    }

    public Produto(String nomeProduto, Double precoCusto, Double precoVenda) {
        this();
        this.nomeProduto = nomeProduto;
        this.precoCusto = precoCusto;
        setPrecoVenda(precoVenda);
        margemLucro = calcMargemLucro();
    } 

    
}
