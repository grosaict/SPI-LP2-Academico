public class Turma {
	private String nomeDisciplina;
	private int qtdAlunoTurma = 0;
	private int maxAlunoTurma = 5;
	private Aluno[] aluno = new Aluno[maxAlunoTurma];
	private int qtdAulas = 0;
	private Aula[] aula;
	
	public Turma (String nomeDiscuplina){
		this.nomeDisciplina = nomeDiscuplina;
	}

	public void adicionaAluno(Aluno aluno) {
		if (qtdAlunoTurma >= maxAlunoTurma){
			System.err.println("Operação não permitida!!");
		}else{
			this.aluno[this.qtdAlunoTurma] = aluno;
			this.qtdAlunoTurma++;			
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
}
