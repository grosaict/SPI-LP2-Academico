import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Aula {
	private String nomeDisciplina;
	private String dataAula;
	private String atividades;
	private PresencaAluno[] presenca;

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Scanner leia = new Scanner(System.in);
	
	public Aula(String nomeDisciplina, int qtdAlunoAula){
		this.nomeDisciplina = nomeDisciplina;
		this.presenca = new PresencaAluno[qtdAlunoAula];
	}

	public void registraAula() {
		this.dataAula = dateFormat.format(new Date());
		System.out.println(this.dataAula+" - "+this.nomeDisciplina);
		System.out.println("Informe as atividades realizadas nessa aula: ");
		this.atividades = leia.nextLine();
		realizaChamada();
	}

	private void realizaChamada() {
		
		
	}

}
