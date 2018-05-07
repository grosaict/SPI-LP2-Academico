public class Academico {

	public static void main(String[] args) {
		/* Crie uma aplicação crie automaticamente uma turma com 5 alunos, e permita ao usuário
		 * realizar chamadas, adicionar avaliações (até 3), e verificar a média dos alunos.
		 */

		char itemMenu, itemSubMenu;
		String opcoes, msg;
		int nroA;
		int qtdAlunos = 50;
		int maxAlunosTurma = 5;
		Aluno aluno[] = new Aluno[qtdAlunos];
		Turma turma = new Turma("Algoritmos II", maxAlunosTurma);

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
		
		Console.exibirAlunos(aluno, aluno.length, false);
		Console.exibirTurma(turma, false);
		
		do{
			opcoes = "CAS";
			msg = "[C]ontrole de aulas\n[A]valiações dos alunos\n[S]air";
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
					turma.registraAula();
					opcoes = "SN";
					msg = "Deseja realizar chamada? ([S]im [N]ão)";
					itemSubMenu = Console.menu(opcoes,msg);
					if (itemSubMenu == 'S'){
						turma.registraPresencaAula(turma.getQtdAulas()-1);
					}
					break;
				case 'C':	//[C]onsulta aula
					Console.exibirAulas(turma.getAula(), turma.getQtdAulas());
					opcoes = "SN";
					msg = "Deseja realizar chamada? ([S]im [N]ão)";
					itemSubMenu = Console.menu(opcoes,msg);
					if (itemSubMenu == 'S'){
						nroA = Console.retornaA("Informe o nro da aula: ", turma.getQtdAulas());
						if (nroA > 0){
							turma.registraPresencaAula(nroA-1);
						}
					}
					break;
				}
				break;
			case 'A':	//[A]valiações dos alunos
				opcoes = "LRV";
				msg = "[L]ista avaliações\n[R]egistra avaliação\n[V]oltar";
				itemSubMenu = Console.menu(opcoes,msg);
				switch (itemSubMenu){
					case 'L':	//[L]ista avaliações
						Console.exibirTurma(turma, true);
						break;
					case 'R':	//[R]egistra avaliação
						Console.exibirTurma(turma, false);
						nroA = Console.retornaA("\nInforme o nro do aluno: ", turma.getQtdAlunosTurma());
						if (nroA > 0){
							turma.registraAvaliacaoAluno(nroA-1);
						}
						break;
				}
				break;
			}
		}while(itemMenu == 'C' || itemMenu == 'A');
		
		System.err.println(">>> Sistema Encerrado <<<");
	}
}
