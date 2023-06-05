package entidades;



public class Importacao {
	
	private int id;

	private float pesagem;
	private String origem;
	private String minerio;
	private Operador operador;
	
	public Importacao(int id, float pesagem, String origem, String minerio){
		this.id = id;

		this.pesagem = pesagem;
		this.origem = origem;
		this.minerio = minerio;
		
	}
	
	
	public Importacao() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	
	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public float getPesagem() {
		return pesagem;
	}
	public void setPesagem(float pesagem) {
		this.pesagem = pesagem;
	}
	
	public String getOrigem() {
		return origem;
	}
	
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getMinerio() {
		return minerio;
	}
	
	public void setMinerio(String minerio) {
		this.minerio = minerio;
	}

	
	
}
