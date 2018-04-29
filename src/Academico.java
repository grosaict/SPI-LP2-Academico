
public class Academico {

	public static void main(String[] args) {
		/* Crie uma aplicação crie automaticamente uma turma com 5 alunos, e permita ao usuário
		 * realizar chamadas, adicionar avaliações (até 3), e verificar a média dos alunos.
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
