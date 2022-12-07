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
import java.util.Collections;
import java.util.Random;
import java.util.regex.Pattern;

import modelo.Ingresso;
import modelo.IngressoGrupo;
import modelo.IngressoIndividual;
import modelo.Jogo;
import repositorio.Repositorio;

public class Fachada {
	private static Repositorio repositorio = new Repositorio();	
	private static int idSequencial = 0;
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
		//retorna os jogos do reposit�rio na data fornecida
		//...		
		ArrayList<Jogo> jogosData = new ArrayList<>();
		for(Jogo j : repositorio.getJogos())
			if(j.getData() == data)
				jogosData.add(j);
		return jogosData;	
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
		
		//Lembrar de  usar com mais coisas -- Eu escrevi//
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
		//  local ou data vazios, estoque ou pre�o menor ou igual a zero
		if (local == ""){
			throw new Exception ("Local não pode está vazio");
		}

		if(data == ""){
			throw new Exception ("Data não pode está vázio");
		}

		//[0-3]/d-[0-9]/d-[1-2]/d{3}
		if(!Pattern.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$", data) || data == ""){
			throw new Exception ("Data Invalida");
		}

		if(estoque <= 0){
			throw new Exception ("Estoque não pode ser menor ou igual a zero");
		}

		if(preco <= 0){
			throw new Exception ("Preço não pode ser menor ou igual a zero");
		}
		
		Time time1 = repositorio.localizarTime(nometime1);
		Time time2 = repositorio.localizarTime(nometime2);

		//String t1 = time1.getNome();
		//String t2 = time2.getNome();
		//Exce��o: nometime1 ou nometime2 inexistente no repositorio,
		if(time1.getNome() == null || time2.getNome() == null){
			throw new Exception ("Times inexistente no repositório");
		}

		

		//gerar id sequencial do jogo 	
		for (int i=0; i<=idSequencial; i++){
			idSequencial = idSequencial + 1;
			break;
		}

		//criar o jogo	
		Jogo criarJogo = new Jogo(idSequencial, data, local, estoque, preco, time1, time2);
		repositorio.adicionar(criarJogo);

		//relacionar o jogo com os dois times 	
		for(Time t : listarTimes()){
			if(t.getNome().equals(nometime1) || t.getNome().equals(nometime2) ){
				t.adicionar(criarJogo);
				
		}
		}

		ArrayList<Jogo> listaJogos = repositorio.getJogos();
		return repositorio.localizarJogo(idSequencial);

		//gerar id sequencial do jogo 
		//criar o jogo, 
		//relacionar o jogo com os dois times 
		//adicionar este jogo no reposit�rio
		//salvar o repositorio em arquivo
	}
	
	public static void apagarJogo(int id) throws Exception {
		//Exce��o: nome existente no repositorio
		//criar o time
		//adicionar este time no reposit�rio
		//salvar o repositorio em arquivo
		try{
		
		Jogo jogo = repositorio.localizarJogo(id);
		if (jogo != null){
			repositorio.remover(jogo);
			repositorio.salvar();
		}else{
			throw new Exception ("Id inexistente no repositório.");
		}
		}catch (Exception e){
			throw new Exception(e);
		}
	}

	public static IngressoIndividual criarIngressoIndividual(int id) throws Exception{
		//Exce��o: id inexistente no repositorio
		//gerar codigo aleat�rio e verificar unicididade do codigo no jogo indicado
		//criar o ingresso individual 
		//relacionar este ingresso com o jogo indicado
		//adicionar este ingresso no reposit�rio
		//salvar o repositorio em arquivo
		
		Jogo jogo = repositorio.localizarJogo(id);
		if (jogo == null) {
			throw new Exception("Não existe nenhum jogo com esse id");
		}
		Random sorteio = new Random();
		int idSorteado = sorteio.nextInt(1000000);
		
		for (Ingresso i : repositorio.getIngressos()){
			while (i.getCodigo() == idSorteado) {
				idSorteado = sorteio.nextInt(1000000);
			}
		}
		IngressoIndividual ingresso = new IngressoIndividual(idSorteado);
		jogo.adicionar(ingresso);
		ingresso.setJogo(jogo);
		repositorio.adicionar(ingresso);
		repositorio.salvar();
		return ingresso;
	}
	
	public static IngressoGrupo	criarIngressoGrupo(int[] id) throws Exception{
		//Exce��o: id inexistente no repositorio 
		//gerar codigo aleat�rio e verificar unicididade do codigo nos jogos indicados
		//criar o ingresso de grupo, 
		//relacionar este ingresso com os jogos indicados 
		//adicionar este ingresso no reposit�rio
		//salvar o repositorio em arquivo
		for(int cod : id ) {
			Jogo jogo = repositorio.localizarJogo(cod);
			if (jogo == null) {
				throw new Exception("Não existe nenhum jogo com esse id");
			}
		}
		Random sorteio = new Random();
		int idSorteado = sorteio.nextInt(1000000);
		
		for (Ingresso i : repositorio.getIngressos()){
			while (i.getCodigo() == idSorteado) {
				idSorteado = sorteio.nextInt(1000000);
			}
		}
		IngressoGrupo ingresso = new IngressoGrupo(idSorteado);
		for(int cod : id) {
			Jogo jogo = repositorio.localizarJogo(cod);
			jogo.adicionar(ingresso);
			ingresso.adicionar(jogo);
		}
		
		repositorio.adicionar(ingresso);
		repositorio.salvar();
		return ingresso;
	}
	
	public static void	cancelarIngresso(int codigo) throws Exception {
		//Exce��o: codigo inexistente no repositorio
		//remover o relacionamento entre ele e o(s) jogo(s) ligados a ele
		//remover ingresso do reposit�rio 
		//salvar o repositorio em arquivo
	}

}