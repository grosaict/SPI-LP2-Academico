
public class Academico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Crie uma aplicação crie automaticamente uma turma com 5 alunos, e permita ao usuário
		 *  realizar chamadas, adicionar avaliações (até 3), e verificar a média dos alunos.
		 */
		
		Aluno aluno[] = new Aluno[5];
		Turma turma = new Turma();
		Aula aula = new Aula();
		Console console	= new Console();

		for (int i=0; i<5; i++){
			aluno[i] = console.definirAluno(i);
		}

		
	}
}
