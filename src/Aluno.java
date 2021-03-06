
public class Aluno {
	private String nome;
	private int matricula;
	private int qtdAvaliacoes = 0;
	private int maxAvaliacoes = 3;
	private Avaliacao[] avaliacao = new Avaliacao[maxAvaliacoes];

	public boolean registraAvaliacao(double nota) {
		if (this.qtdAvaliacoes < this.maxAvaliacoes){
			Avaliacao avaliacao = new Avaliacao(nota);
			this.avaliacao[qtdAvaliacoes] = avaliacao;
			this.qtdAvaliacoes++;
			return true;
		}else{
			return false;
		}
	}
	
	public Avaliacao[] getAvaliacoes() {
		return this.avaliacao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public int getMatricula() {
		return this.matricula;
	}

	public int getQtdAvaliacoes() {
		return this.qtdAvaliacoes;
	}

	public int getMaxAvaliacoes() {
		return this.maxAvaliacoes;
	}
}
