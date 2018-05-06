import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Aula {
	private int maxAlunoAula;
	private Aluno[] alunoAula;
	private String[] presenca;
	private String dataNomeAula;
	private String atividades;

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Scanner leia = new Scanner(System.in);
	
	public Aula(String nomeDisciplina, int maxAlunoAula, Aluno[] aluno) {
		this.maxAlunoAula = maxAlunoAula;
		this.alunoAula = aluno;
		String[] presenca = new String[maxAlunoAula];
		for (int i=0;i<maxAlunoAula;i++){
			presenca[i] = "Presente";
		}
		this.presenca = presenca;
		this.dataNomeAula = dateFormat.format(new Date())+" - "+nomeDisciplina;
		System.out.println(this.dataNomeAula);
		System.out.println("Informe as atividades realizadas nessa aula: ");
		this.atividades = leia.nextLine();
	}
	
	public void registraTodasPresencas() {
		for (int i=0;i<maxAlunoAula;i++){
			listaAlunoAula(i);
			registraPresencaAluno(i);
		}
	}
	
	public void registraPresencaAluno(int codAluno){
		Console c = new Console();
		char itemMenu;
		if (this.presenca[codAluno].equals("Ausente")){
			itemMenu = c.menu("PM","[P]resente / [M]anter registro");
		}else{
			itemMenu = c.menu("AM","[A]usente / [M]anter registro");
		}
		switch (itemMenu){
		case 'P': this.presenca[codAluno] = "Presente";	break;
		case 'A': this.presenca[codAluno] = "Ausente";	break;
		}
	}
	
	public void listaAlunoAula(int codAluno){
		System.out.println("["+(codAluno+1)+"] "+this.alunoAula[codAluno].getMatricula()+" - "+this.alunoAula[codAluno].getNome()+" - "+this.presenca[codAluno]);
	}
	
	public int getMaxAlunoAula() {
		return this.maxAlunoAula;
	}
	
	public Aluno[] getAlunoAula() {
		return this.alunoAula;
	}

	public String getDataNomeAula() {
		return this.dataNomeAula;
	}

	public String getAtividades() {
		return this.atividades;
	}

}
