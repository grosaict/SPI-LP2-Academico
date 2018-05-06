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
			System.out.print("\n[Aula "+(i+1)+"] ");
			System.out.println(aula[i].getDataNomeAula());
			System.out.println(aula[i].getAtividades());
			for (int j=0;j<aula[i].getMaxAlunoAula();j++){
				aula[i].listaAlunoAula(j);
			}
		}
	}
	
	public char menu(String opcoes, String msg){
		char itemMenu;
		boolean opcaoValida = false;
		Scanner leia = new Scanner(System.in);
		System.out.println("\nInforme a opção desejada:");
		System.out.println(msg);
		try {
			itemMenu = leia.next().charAt(0);
			itemMenu = Character.toUpperCase(itemMenu);
			for (int i=0; i<opcoes.length();i++){
				if (itemMenu == opcoes.charAt(i)){
					opcaoValida = true;
					i = opcoes.length();
				}
			}
			if (!opcaoValida){
				throw new Exception("OPÇÃO INEXISTENTE");
			}
		}catch(Exception e){
        	System.err.println(">> "+e.getMessage()+" << Informe novamente");
        	itemMenu = menu(opcoes, msg);
		}
		return itemMenu;
	}

	public int retornaAula(int qtdAulas) {
		int nroAula;
		Scanner leia = new Scanner(System.in);
		nroAula = leia.nextInt();
		if (nroAula > 0 && nroAula <= qtdAulas){
			return nroAula;
		}else{
			return 0;
		}
	}
}
