
public class Console {
	
	public static Aluno definirAluno(int i){
		String nome;
		int matricula = 63000;
		
		Aluno novoAluno = new Aluno();
		
		nome = "Aluno"+(i + 1);
		matricula = matricula + i + 1;
		novoAluno.defineAluno(nome, matricula);
		return novoAluno;
	}
	
	public static void exibirAlunos(Aluno[] aluno) {
		for (int j=0; j<5; j++) {
			imprime(aluno[j]);
		}
	}
	
	private static void imprime(Aluno aluno) {
		System.out.println("["+aluno.getMatricula()+"] "+aluno.getNome());
		/*for (int i = 0; i < 3; i++) {
			Avaliacao avaliacao = aluno.getAvaliacao(i);
		}*/
	}
	
}
