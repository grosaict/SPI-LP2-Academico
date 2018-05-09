
public class Academico {

	public static void main(String[] args) {
		/* Crie uma aplica��o que crie automaticamente uma turma com 5 alunos, e permita ao usu�rio
		 * realizar chamadas, adicionar avalia��es (at� 3), e verificar a m�dia dos alunos.
		 */

		char itemMenu, itemSubMenu;
		String opcoes, msg;
		int nroA;
		int qtdAlunos = 20;
		int maxAlunosTurma = 5;
		Aluno aluno[] = new Aluno[qtdAlunos];
		Turma turma = new Turma("Algoritmos II", maxAlunosTurma);

		//cria automaticamente qtdAlunos
		for (int i=0; i<qtdAlunos; i++){
			aluno[i] = new Aluno();
			if (i < 9){
				aluno[i].setNome("Aluno0"+(i + 1));
			}else{
				aluno[i].setNome("Aluno"+(i + 1));
			}
			aluno[i].setMatricula(63000+i+1);
		}
		
		qtdAlunos = 0;
		
		//insere maxAlunosTurma na turma
		for (int i=aluno.length-1; i>=0; i--){
			if (maxAlunosTurma > qtdAlunos){
				if (turma.adicionaAluno(aluno[i])){
					qtdAlunos++;
					i--;
				}else{
					System.err.println("Turma lotada. Opera��o n�o permitida!!");
					i = -1;
				}
			}else{
				i = -1;
			}
		}
		
		Console.exibirAlunos(aluno, aluno.length, false);
		Console.exibirTurma(turma, false);
		
		do{
			opcoes = "CAS";
			msg = "[C]ontrole de aulas\n[A]valia��es dos alunos\n[S]air";
			itemMenu = Console.menu(opcoes,msg);
			switch (itemMenu){
			case 'C':	//[C]ontrole de aulas
				opcoes = msg = "";
				if (turma.getQtdAulas() < turma.getMaxAulas()){
					opcoes = "N";
					msg = "[N]ova aula\n";
				}
				if (turma.getQtdAulas() > 0){
					opcoes += "C";
					msg += "[C]onsulta aula\n";
				}
				opcoes += "V";
				msg += "[V]oltar";
				itemSubMenu = Console.menu(opcoes,msg);
				switch (itemSubMenu){
				case 'N':	//[N]ova aula
					if (turma.registraAula()){
						opcoes = "SN";
						msg = "Deseja realizar chamada? ([S]im [N]�o)";
						itemSubMenu = Console.menu(opcoes,msg);
						if (itemSubMenu == 'S'){
							turma.registraPresencaAula(turma.getQtdAulas()-1);
						}
					}else{
						System.err.println("N�mero m�ximo de aulas atingido. Opera��o n�o permitida!!");
					}
					break;
				case 'C':	//[C]onsulta aula
					Console.exibirAulas(turma.getAula(), turma.getQtdAulas());
					opcoes = "SN";
					msg = "Deseja realizar chamada? ([S]im [N]�o)";
					itemSubMenu = Console.menu(opcoes,msg);
					if (itemSubMenu == 'S'){
						nroA = Console.retornaA("Informe o nro da aula: ([0] para desistir!!)", turma.getQtdAulas());
						if (nroA > 0){
							turma.registraPresencaAula(nroA-1);
						}
					}
					break;
				}
				break;
			case 'A':	//[A]valia��es dos alunos
				Console.exibirTurma(turma, true);
				opcoes = "RV";
				msg = "[R]egistra avalia��o\n[V]oltar";
				itemSubMenu = Console.menu(opcoes,msg);
				switch (itemSubMenu){
					case 'R':	//[R]egistra avalia��o
						nroA = Console.retornaA("\nInforme o nro do aluno: ([0] para desistir!!)", turma.getQtdAlunosTurma());
						if (nroA > 0){
							if (!turma.registraAvaliacaoAluno(nroA-1)){
								System.err.println("Todas as avalia��es j� registradas para o aluno");
							}
						}
						break;
				}
				break;
			}
		}while(itemMenu == 'C' || itemMenu == 'A');
		
		System.err.println(">>> Sistema Encerrado <<<");
	}
}
