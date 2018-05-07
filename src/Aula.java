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
		Scanner leia = new Scanner(System.in);
		
		String[] presenca = new String[maxAlunoAula];
		for (int i=0;i<maxAlunoAula;i++){
			presenca[i] = "Presente";
		}
		
		this.maxAlunoAula = maxAlunoAula;
		this.alunoAula = aluno;
		this.presenca = presenca;
		this.dataNomeAula = dateFormat.format(new Date())+" - "+nomeDisciplina;

		System.out.println(this.dataNomeAula);
		System.out.println("Informe as atividades realizadas nessa aula: ");
		this.atividades = leia.nextLine();
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

		if (this.presenca[codAluno].equals("Ausente")){
			itemMenu = Console.menu("PM","[P]resente / [M]anter ausencia");
		}else{
			itemMenu = Console.menu("AM","[A]usente / [M]anter presença");
		}
		
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
