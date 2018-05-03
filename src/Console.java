import java.util.Scanner;

public class Console {
	
	public static void exibirAlunos(Aluno[] aluno) {
		for (int j=0; j<aluno.length; j++) {
			imprimeAluno(aluno[j]);
		}
	}
	
	private static void imprimeAluno(Aluno aluno) {
		System.out.println("["+aluno.getMatricula()+"] "+aluno.getNome());
	}

	public static void exibirTurma(Turma turma) {
		int qdtAlunosTurma;
		System.out.println("\n"+turma.getNomeTurma());
		
		qdtAlunosTurma = turma.getQtdAlunosTurma();
		
		for (int i=0; i<qdtAlunosTurma; i++){
			imprimeAluno(turma.getAlunoTurma(i));
		}
	}
	
	public static void listaAulas(Aula[] aula, int qtdAulas){
		for (int i=0;i<qtdAulas;i++){
			System.out.println(aula[i].getDataNomeAula());
			System.out.println(aula[i].getAtividades());
		}
	}
	
	public char menuPrincipal(){
		char itemMenu;
		Scanner leia = new Scanner(System.in);
		System.out.println("\nInforme a op��o desejada:");
		System.out.println("[R]egistro de aulas e presen�as de aluno");
		System.out.println("[A]valia aluno");
		System.out.println("[C]onsulta m�dia dos alunos");
		System.out.println("[S]air");
		try {
			itemMenu = leia.next().charAt(0);
			itemMenu = Character.toUpperCase(itemMenu);
			if (itemMenu != 'R' && itemMenu != 'A' && itemMenu != 'C' && itemMenu != 'S'){
				throw new Exception("OP��O INEXISTENTE");
			}
		}catch(Exception e){
        	System.err.println(">> "+e.getMessage()+" << Informe novamente");
        	itemMenu = menuPrincipal();
		}
		return itemMenu;
	}
}
