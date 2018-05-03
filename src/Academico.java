public class Academico {

	public static void main(String[] args) {
		/* Crie uma aplicação crie automaticamente uma turma com 5 alunos, e permita ao usuário
		 * realizar chamadas, adicionar avaliações (até 3), e verificar a média dos alunos.
		 */

		char itemMenu;
		int qtdAlunos = 50;
		int maxAlunosTurma = 5;
		Aluno aluno[] = new Aluno[qtdAlunos];
		Turma turma = new Turma("Algoritmos II", maxAlunosTurma);
		Console console	= new Console();

		//cria automaticamente qtdAlunos
		for (int i=0; i<qtdAlunos; i++){
			aluno[i] = new Aluno();
			aluno[i].setNome("Aluno"+(i + 1));
			aluno[i].setMatricula(63000+i+1);
		}
		
		qtdAlunos = 0;
		
		//insere maxAlunosTurma na turma
		for (int i=aluno.length-1; i>=0; i--){
			if (maxAlunosTurma > qtdAlunos){
				turma.adicionaAluno(aluno[i]);
				qtdAlunos++;
				i--;
			}else{
				i = -1;
			}
		}
		
		//console.exibirAlunos(aluno);
		//console.exibirTurma(turma);
		
		do{
			itemMenu = console.menuPrincipal();;
			switch (itemMenu){
			case 'R':	//Registro de aulas e presenças
				turma.registraAula();
				console.listaAulas(turma.getAula(), turma.getQtdAulas());
				break;
			case 'A':	//Avalia aluno
				//
				break;
			case 'C':	//Consulta media dos alunos
				//
				break;
			}
		}while(itemMenu == 'R' || itemMenu == 'A' || itemMenu == 'C');
		
		System.err.println(">>> Sistema Encerrado <<<");
	}
}
