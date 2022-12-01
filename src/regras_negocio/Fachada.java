package regras_negocio;
/**********************************
 * Projeto2 de POO (2022.2)
 * 
 * Grupo de alunos: 
 * fulano, beltrano e cicrano
 * 
 **********************************/

import modelo.Time;
import java.util.ArrayList;

import modelo.Ingresso;
import modelo.Jogo;
import repositorio.Repositorio;

public class Fachada {
	private static Repositorio repositorio = new Repositorio();	
	private Fachada() {}	

	
	public static ArrayList<Time> listarTimes() {
		//retorna todos os times do reposit�rio
		return repositorio.getTimes();
	}
	public static ArrayList<Jogo> listarJogos() {
		return repositorio.getJogos();
		//retorna todos os jogos do reposit�rio
	}
	
	public static ArrayList<Ingresso> listarIngressos() {
		return repositorio.getIngressos();
		//retorna todos os ingressos do reposit�rio 
	}

	//Lembrar de olhar
	public static ArrayList<Jogo> listarJogos (String data) {
		return repositorio.getJogos();
		//retorna os jogos do reposit�rio na data fornecida
		//...

	}
	public static Ingresso localizarIngresso(int codigo) {
		//retorna o ingresso do reposit�rio com o c�digo fornecido
		//...
		return repositorio.localizarIngresso(codigo);
	}
	
	public static Jogo	localizarJogo(int id) {
		return repositorio.localizarJogo(id);
		//retorna o jogo do reposit�rio com o id fornecido
		//...
	}

	public static Time 	criarTime (String nome, String origem) throws Exception {
		//Exce��o: nome existente no repositorio
		//criar o time
		//adicionar este time no reposit�rio
		//salvar o repositorio em arquivo
		
		
		Time time = repositorio.localizarTime(nome);
		if (time == null){
			Time novoTime = new Time (nome, origem);
			repositorio.adicionar(novoTime);
			ArrayList<Time> listaDeTimes = repositorio.getTimes();
			return repositorio.localizarTime(novoTime.getNome());
		}else{
			throw new Exception ("Já existe um time com esse nome");
		}
	}

	public static Jogo criarJogo (String data, String local, int estoque, double preco, String nometime1, String nometime2)  throws Exception {
		
		//Exce��o: nometime1 ou nometime2 inexistente no repositorio, 
		//  local ou data vazios, estoque ou pre�o menor ou igual a zero
		//gerar id sequencial do jogo 
		//criar o jogo, 
		//relacionar o jogo com os dois times 
		//adicionar este jogo no reposit�rio
		//salvar o repositorio em arquivo
	}
	
	public static void 	apagarJogo(int id) throws Exception{
		//Exce��o: id inexistente no repositorio
		//remover o jogo do reposit�rio
		//salvar o repositorio em arquivo
	}

	public static IngressoIndividual criarIngressoIndividual(int id) throws Exception{
		//Exce��o: id inexistente no repositorio
		//gerar codigo aleat�rio e verificar unicididade do codigo no jogo indicado
		//criar o ingresso individual 
		//relacionar este ingresso com o jogo indicado
		//adicionar este ingresso no reposit�rio
		//salvar o repositorio em arquivo
	}
	
	public static IngressoGrupo	criarIngressoGrupo(int[] id) throws Exception{
		//Exce��o: id inexistente no repositorio 
		//gerar codigo aleat�rio e verificar unicididade do codigo nos jogos indicados
		//criar o ingresso de grupo, 
		//relacionar este ingresso com os jogos indicados 
		//adicionar este ingresso no reposit�rio
		//salvar o repositorio em arquivo
	}
	
	public static void	cancelarIngresso(int codigo) throws Exception {
		//Exce��o: codigo inexistente no repositorio
		//remover o relacionamento entre ele e o(s) jogo(s) ligados a ele
		//remover ingresso do reposit�rio 
		//salvar o repositorio em arquivo
	}


}
