import java.util.ArrayList;

public class IngressoIndividual extends Ingresso {
    private Jogo jogo;
    private static ArrayList<Double> somaTudo = new ArrayList<>();

    public IngressoIndividual(int id){
        super(id);
    }

    public static double getSomaPrecos (){
        ArrayList<Double> valoresSomados = new ArrayList<>();
        
        for(double soma : somaTudo){
            valoresSomados.add(soma);
        }

        double sum = valoresSomados.stream().mapToDouble(i -> i).sum();

        return sum;
    }
   

    public void setJogo(Jogo j){
        this.jogo = j;
    }

    public int getCodigo(){
        return getId();
    }

    @Override
    public double calcularValor(){
        somaTudo.add(1.2 * jogo.getPreco());
        return 1.2 * jogo.getPreco();
    }

    @Override
    public String toString(){
        return "Código => " + getId();
    }

    
    //public double calcularValor();
}
