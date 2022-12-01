import java.util.ArrayList;

public class Time extends Jogo {
    private String nome;
    private String origem;
    private ArrayList<Jogo> jogos = new ArrayList<>();

    /*public Time (String recbNome, String recebOrigem) {
        this.nome = recbNome;
        this.origem = recebOrigem;
    }*/

    public Time(String recebNome, String recebOrigem){
        super(recebNome, recebOrigem);
        this.nome = recebNome;
        this.origem = recebOrigem;
    }

    public void adicionar (Jogo jx){
        jogos.add(jx);
    }

    public String getNome(){
        return this.nome;
    }

    public String getOrigem(){
        return this.origem;
    }

    //@Override

    public void getJogos(){
        for (Jogo teste : jogos ){
            System.out.println(teste.getTime1().getNome()); 
            System.out.println(teste.getTime2().getNome());
        }
    }
    // criei o valor arrecadado
    public double obterValorArrecadado() {
    	double soma = 0;
    	
    	for (Jogo j : jogos) {
    		soma = soma + j.obterValorArrecadado();
    	}
    	
    	return soma;
    }
 
    // ajeitei o to string
   	public String toString(){
		String jogosTemp = "";
		
		for(Jogo j : jogos) {
			jogosTemp = jogosTemp + " " + j.getId() + "=" + j.getData() + "," + j.getLocal();
		}
		
	    return "\nnome=" + this.nome + ", origem=" + this.origem +
	    	   "\njogos: " + jogosTemp;
	}

    /*public double obterValorArrecadado(){
        return 

    };*/


}



