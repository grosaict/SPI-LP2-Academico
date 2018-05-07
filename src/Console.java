import java.text.DecimalFormat;
import java.util.Scanner;

public class Console {
	
	public static void exibirAlunos(Aluno[] aluno, int qtdAlunos, boolean exibeAvaliacao) {
		for (int j=0; j<qtdAlunos; j++) {
			exibirAluno(j, aluno[j]);
			if (exibeAvaliacao){
				exibirAvaliacaoAluno(aluno[j].getAvaliacao(),aluno[j].getQtdAvaliacoes());
			}
		}
	}
	
	private static void exibirAvaliacaoAluno(Avaliacao[] avaliacao, int qtdAvaliacoes) {
		DecimalFormat decFormat = new DecimalFormat("#.00");
		
		double media = 0;
		
		if (qtdAvaliacoes <= 0){
			System.out.print("\n    [sem avaliação]");
		}else{
			for (int i=0;i<qtdAvaliacoes;i++){
				System.out.print("\n    "+avaliacao[i].getDataNota()+" ["+(i+1)+"ª nota] "+avaliacao[i].getNota());
				media += avaliacao[i].getNota();
			}
			media = media / qtdAvaliacoes;
			System.out.printf("\n    MEDIA = "+decFormat.format(media));
		}
	}

	public static void exibirAluno(int codAluno, Aluno aluno) {
		System.out.print("\n["+(codAluno+1)+"] "+aluno.getMatricula()+" - "+aluno.getNome());
	}

	public static void exibirPresenca(int i, String presenca) {
		System.out.print(" - "+presenca);
	}
	
	public static void exibirTurma(Turma turma, boolean exibeAvaliacao) {
		System.out.print("\n\n"+turma.getNomeTurma());
		exibirAlunos(turma.getAluno(), turma.getQtdAlunosTurma(), exibeAvaliacao);
	}
	
	public static void exibirAulas(Aula[] aula, int qtdAulas){
		for (int i=0;i<qtdAulas;i++){
			System.out.print("\n[Aula "+(i+1)+"] ");
			System.out.println(aula[i].getDataNomeAula());
			System.out.println(aula[i].getAtividades());
			for (int j=0;j<aula[i].getMaxAlunoAula();j++){
				exibirAluno(j, aula[i].getAlunoAula(j));
				exibirPresenca(j, aula[i].getPresenca(j));
			}
		}
	}
	
	public static int retornaA(String msg, int qtdA) {
		int nroA;
		System.out.println(msg);
		Scanner leia = new Scanner(System.in);
		nroA = leia.nextInt();
		if (nroA > 0 && nroA <= qtdA){
			return nroA;
		}else{
			System.err.println("Nro informado não existe!!!");
			return 0;
		}
	}
	
	public static double retornaAvaliacao() {
		double nota;
		Scanner leia = new Scanner(System.in);
		System.out.println("Informe a nota para o aluno: (0 a 10)");
		nota = leia.nextDouble();
		if (nota >= 0 && nota <= 10){
			return nota;
		}else{
			System.err.println("Valor inválido. Nota não registrada!");
			return 99;
		}
	}
	
	public static char menu(String opcoes, String msg){
		char itemMenu;
		boolean opcaoValida = false;
		Scanner leia = new Scanner(System.in);
		System.out.println("\n\nInforme a opção desejada:");
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
}
