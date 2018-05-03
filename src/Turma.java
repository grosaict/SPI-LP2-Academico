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
		Aluno[] aluno = new Aluno[maxAlunoTurma];
		this.aluno = aluno;
	}

	public void adicionaAluno(Aluno aluno) {
		if (this.qtdAlunoTurma >= this.maxAlunoTurma){
			System.err.println("Turma lotada. Opera��o n�o permitida!!");
		}else{
			this.aluno[this.qtdAlunoTurma] = aluno;
			this.qtdAlunoTurma++;			
		}
	}
	
	public void registraAula() {
		if (this.qtdAulas >= this.maxAulas){
			System.err.println("Opera��o n�o permitida!!");
		}else{
			Aula a = new Aula(this.nomeDisciplina, this.qtdAlunoTurma);
			this.aula[qtdAulas] = a;
			this.qtdAulas++;			
		}
	}

	public String getNomeTurma() {
		return this.nomeDisciplina;
	}

	public int getQtdAlunosTurma() {
		return this.qtdAlunoTurma;
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

}
