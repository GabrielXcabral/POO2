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

 
   @Override
    public String toString(){
        return //super.toString() +
        "Nome => " + this.nome +
        "\nOrigem => " + this.origem;
        //"\nid => " + getId();
    }

    /*public double obterValorArrecadado(){
        return 

    };*/


}
