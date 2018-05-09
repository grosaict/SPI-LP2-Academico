
public class Turma {
	private String nomeDisciplina;
	
	private int qtdAlunoTurma = 0;
	private int maxAlunoTurma;
	private Aluno[] aluno;
	
	private int qtdAulas = 0;
	private int maxAulas = 5;
	private Aula[] aula = new Aula[maxAulas];
	
	public Turma (String nomeDiscuplina, int maxAlunoTurma){
		this.nomeDisciplina = nomeDiscuplina;
		this.maxAlunoTurma = maxAlunoTurma;
		this.aluno = new Aluno[maxAlunoTurma];
	}

	public boolean adicionaAluno(Aluno aluno) {
		if (this.qtdAlunoTurma >= this.maxAlunoTurma){
			return false;
		}else{
			this.aluno[this.qtdAlunoTurma] = aluno;
			this.qtdAlunoTurma++;
			return true;
		}
	}
	
	public boolean registraAula() {
		if (this.qtdAulas < this.maxAulas){
			this.aula[qtdAulas] = new Aula(this.nomeDisciplina, this.qtdAlunoTurma, this.aluno);
			this.qtdAulas++;
			return true;
		}else{
			return false;
		}
	}

	public void registraPresencaAula(int codAula) {
		this.aula[codAula].registraTodasPresencas();
	}
	
	public boolean registraAvaliacaoAluno(int codAluno) {
		double nota;
		nota = Console.retornaAvaliacao();
		if (nota != 99){
			return this.aluno[codAluno].registraAvaliacao(nota);
		}else{
			return false;
		}
	}

	public String getNomeTurma() {
		return this.nomeDisciplina;
	}

	public int getQtdAlunosTurma() {
		return this.qtdAlunoTurma;
	}

	public Aluno[] getAlunoTurma() {
		return this.aluno;
	}

	public Aluno getAlunoTurma(int i) {
		return this.aluno[i];
	}

	public Aula[] getAula() {
		return this.aula;
	}

	public int getQtdAlunoTurma() {
		return this.qtdAlunoTurma;
	}

	public int getQtdAulas() {
		return this.qtdAulas;
	}

	public int getMaxAulas() {
		return this.maxAulas;
	}

}
