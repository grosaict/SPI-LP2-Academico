public class Academico {

	public static void main(String[] args) {
		/* Crie uma aplicação crie automaticamente uma turma com 5 alunos, e permita ao usuário
		 * realizar chamadas, adicionar avaliações (até 3), e verificar a média dos alunos.
		 */

		char itemMenu, itemSubMenu;
		String opcoes, msg;
		int nroAula;
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
			opcoes = "CABS";
			msg = "[C]ontrole de aulas\n[A]valia aluno\n[B]oletim dos alunos\n[S]air";
			itemMenu = console.menu(opcoes,msg);
			switch (itemMenu){
			case 'C':	//Controle de aulas e presenças
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
				itemSubMenu = console.menu(opcoes,msg);
				switch (itemSubMenu){
				case 'N':	//Nova aula
					turma.registraAula();
					opcoes = "SN";
					msg = "Deseja realizar chamada? ([S]im [N]ão)";
					itemSubMenu = console.menu(opcoes,msg);
					if (itemSubMenu == 'S'){
						turma.registraPresencaAula(turma.getQtdAulas()-1);
					}
					break;
				case 'C':	//Consulta aula
					console.listaAulas(turma.getAula(), turma.getQtdAulas());
					opcoes = "SN";
					msg = "Deseja realizar chamada? ([S]im [N]ão)";
					itemSubMenu = console.menu(opcoes,msg);
					if (itemSubMenu == 'S'){
						System.out.println("Informe o nro da aula: ");
						nroAula = console.retornaAula(turma.getQtdAulas());
						if (nroAula > 0){
							turma.registraPresencaAula(nroAula-1);
						}else{
							System.err.println("Aula informada não existe!!!");
						}
					}
					break;
				}
				break;
			case 'A':	//Avalia aluno
				//
				break;
			case 'B':	//Boletim dos alunos
				//
				break;
			}
		}while(itemMenu == 'R' || itemMenu == 'A' || itemMenu == 'C');
		
		System.err.println(">>> Sistema Encerrado <<<");
	}
}
