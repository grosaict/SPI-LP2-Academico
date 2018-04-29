
public class Console {
	
	public static void exibirAlunos(Aluno[] aluno) {
		for (int j=0; j<aluno.length; j++) {
			imprimeAluno(aluno[j]);
		}
	}
	
	private static void imprimeAluno(Aluno aluno) {
		System.out.println("["+aluno.getMatricula()+"] "+aluno.getNome());
		/*for (int i = 0; i < 3; i++) {
			Avaliacao avaliacao = aluno.getAvaliacao(i);
		}*/
	}

	public void exibirTurma(Turma turma) {
		int qdtAlunosTurma;
		System.out.println(turma.getNomeTurma());
		
		qdtAlunosTurma = turma.getQtdAlunosTurma();
		
		for (int i=0; i<qdtAlunosTurma; i++){
			imprimeAluno(turma.getAlunoTurma(i));
		}
		
		
		
	}
	
}
