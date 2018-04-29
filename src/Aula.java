import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Aula {

	private String nomeDisciplina;
	private String dataAula;
	private String atividades;

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Scanner leia = new Scanner(System.in);
	
	public void registraAula(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.dataAula = dateFormat.format(new Date());
		System.out.println(this.dataAula+" - "+this.nomeDisciplina);
		System.out.println("Informe as atividades realizadas nessa aula: ");
		this.atividades = leia.nextLine();
	}

}
