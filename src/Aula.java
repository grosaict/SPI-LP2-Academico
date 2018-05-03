import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Aula {
	private int maxAlunoAula;
	private Aluno[] aluno;
	private String dataNomeAula;
	private String atividades;

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	Scanner leia = new Scanner(System.in);
	
	public Aula(String nomeDisciplina, int maxAlunoAula) {
		this.maxAlunoAula = maxAlunoAula;
		Aluno[] aluno = new Aluno[maxAlunoAula];
		this.aluno = aluno;
		this.dataNomeAula = dateFormat.format(new Date())+" - "+nomeDisciplina;
		System.out.println(this.dataNomeAula);
		System.out.println("Informe as atividades realizadas nessa aula: ");
		this.atividades = leia.nextLine();
	}

	public String getDataNomeAula() {
		return this.dataNomeAula;
	}

	public String getAtividades() {
		return this.atividades;
	}

}
