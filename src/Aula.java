import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Aula {
	private int maxAlunoAula;
	private Aluno[] alunoAula;
	private String[] presenca;
	private String dataNomeAula;
	private String atividades;

	public Aula(String nomeDisciplina, int maxAlunoAula, Aluno[] aluno) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		String[] presenca = new String[maxAlunoAula];
		for (int i=0;i<maxAlunoAula;i++){	//Atribui presença para todos alunos por default
			presenca[i] = "Presente";
		}
		
		this.maxAlunoAula = maxAlunoAula;
		this.alunoAula = aluno;
		this.presenca = presenca;
		this.dataNomeAula = dateFormat.format(new Date())+" - "+nomeDisciplina;
		this.atividades = Console.retornaAtividadesAula(this.dataNomeAula);
	}
	
	public void registraTodasPresencas() {
		for (int i=0;i<maxAlunoAula;i++){
			Console.exibirAluno(i, this.alunoAula[i]);
			Console.exibirPresenca(i, this.presenca[i]);
			registraPresencaAluno(i);
		}
	}
	
	public void registraPresencaAluno(int codAluno){
		char itemMenu;
		String opcoes, msg;

		if (this.presenca[codAluno].equals("Ausente")){
			opcoes = "PM";
			msg = "[P]resente / [M]anter ausencia";
		}else{
			opcoes = "AM";
			msg = "[A]usente / [M]anter presença";
		}
		
		itemMenu = Console.menu(opcoes,msg);
		switch (itemMenu){
			case 'P': this.presenca[codAluno] = "Presente";	break;
			case 'A': this.presenca[codAluno] = "Ausente";	break;
		}
	}
	
	public int getMaxAlunoAula() {
		return this.maxAlunoAula;
	}
	
	public Aluno getAlunoAula(int codAluno) {
		return this.alunoAula[codAluno];
	}
	
	public String getPresenca(int codAluno) {
		return this.presenca[codAluno];
	}

	public String getDataNomeAula() {
		return this.dataNomeAula;
	}

	public String getAtividades() {
		return this.atividades;
	}

}
