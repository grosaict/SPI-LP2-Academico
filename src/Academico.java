
public class Academico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Crie uma aplica��o crie automaticamente uma turma com 5 alunos, e permita ao usu�rio
		 *  realizar chamadas, adicionar avalia��es (at� 3), e verificar a m�dia dos alunos.
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
