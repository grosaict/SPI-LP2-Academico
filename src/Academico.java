
public class Academico {

	public static void main(String[] args) {
		/* Crie uma aplica��o crie automaticamente uma turma com 5 alunos, e permita ao usu�rio
		 * realizar chamadas, adicionar avalia��es (at� 3), e verificar a m�dia dos alunos.
		 */

		int qtdAlunos = 10;
		Aluno aluno[] = new Aluno[qtdAlunos];
		Turma turma = new Turma("Algoritmos II");
		Aula aula = new Aula();
		Console console	= new Console();

		for (int i=0; i<qtdAlunos; i++){
			aluno[i] = new Aluno("Aluno"+(i + 1), 63000+i+1);
		}
		
		for (int i=aluno.length-1; i>=0; i--){
			turma.adicionaAluno(aluno[i]);
			i--;
		}
		
		//console.exibirAlunos(aluno);
		System.out.println("\n\n\n");
		console.exibirTurma(turma);
		
		
	}
}
