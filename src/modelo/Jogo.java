package modelo;

import java.util.ArrayList;

public class Jogo {
    private int id;
    protected double preco;
    private String data;
    public String estadio;
    private int estoque;    
    private Time time1;
    private Time time2;
    //transformei os 2 ingressos em 1
    private ArrayList<Ingresso> ingressos = new ArrayList<>();

    public Jogo(int recbId, String recebData, String recebEstadio, int recbEstoque, double recebPreco, Time recebTime1, Time recebTime2){
        super();
        this.id = recbId;        
        this.data = recebData;
        this.estadio = recebEstadio;
        this.estoque = recbEstoque; 
        this.preco = recebPreco;       
        this.time1 = recebTime1;
        this.time2 = recebTime2;
        

    }

    /*public Jogo(int codigo, double preco) {
        this.id = codigo;
        this.preco = preco;
    }*/
    
    public Jogo(int codigo) {
        this.id = codigo;
        //this.preco = preco;
    }

    public Jogo (double preco){
        this.preco = preco;
    }

    public Jogo (String recbNome, String recebOrigem){
    }

    /*public double getPreco(){
        return preco;
    }*/

    public int getId(){
        return this.id;
    }

    public String getData(){
        return this.data;
    }

    public String getLocal(){
        return this.estadio;
    }

    public int getEstoque(){
        return this.estoque;
    }

    public double getPreco(){
        return this.preco;
    }

    /*public void getIngressos(){
        for (Ingresso ingresso : ingressos){
            System.out.println(ingresso.getId());
        }
    }*/

    //coloquei isso, vê se precisa
    public ArrayList<Ingresso> getIngressos(){
        return ingressos;
    }

    public void setTime1(Time jogos){
        this.time1 = jogos;
    }
    
    public void setEstoque(int novoEstoque) {
    	this.estoque = novoEstoque;
    }

    public Time getTime1(){
        return this.time1;
    } 

    public Time getTime2(){
        return this.time2;
    }

    public void setTime2(Time nome2){
        this.time2 = nome2;
    }
    // mudei os ingressos para serem adicionados no novo array de ingressos
    public void adicionar (Ingresso tickt){
    	this.estoque = this.estoque - 1;
        ingressos.add(tickt);
    }
    // mudei os ingressos para serem adicionados no novo array de ingressos
    //criei o valor arrecadado
    public double obterValorArrecadado(){
    	double soma = 0;
    	
    	for (Ingresso i : ingressos) {
    		soma = soma + i.calcularValor();
    	}
    	
        return soma;

    }
    // ajeitei o tostring
    @Override
    public String toString(){
    	String ingresso_temp = "";
    	
    	for (Ingresso i : ingressos) {
    		ingresso_temp = ingresso_temp + i.getId() + ",";
    	}
    	
        return "\nid=" + getId() + ", data=" + getData() + ", local=" + getLocal() + ", estoque=" + getEstoque() + ", preço=" + getPreco() +", times1=" + getTime1().getNome() + " x time2=" + getTime2().getNome() + 
        	   "\ningressos:" + ingresso_temp;
                //"Codigos do ingresso => " + 
    }
}