import java.lang.reflect.Array;
import java.util.ArrayList;

public class IngressoGrupo extends Ingresso{
    private ArrayList<Jogo> jogos = new ArrayList<>();
    private static ArrayList<Double> juntaTudo = new ArrayList<>();

    public IngressoGrupo(int id){
        super(id);

    }

    public int getCodigo(){
        return getId();
    }

    public void adicionar(Jogo jogo){
        jogos.add(jogo);
    }


    public double calcularValor(){
        ArrayList<Double> soPrecos = new ArrayList<>();

        
        for(Jogo valores : jogos){
            soPrecos.add(valores.getPreco());

        }

       double sum = soPrecos.stream().mapToDouble(i -> i).sum();
       juntaTudo.add(0.9 * sum);


        return (0.9 * sum);
    }

    public static double getSomaPrecosGrupo(){
        ArrayList<Double> somaTudo = new ArrayList<>();
        
        for(double valores : juntaTudo){
            somaTudo.add(valores);
        }

        double sum = somaTudo.stream().mapToDouble(i -> i).sum();
        return sum;

    }

    
    public String toString(){
        return "Código => " + getId();
    }


    
}
