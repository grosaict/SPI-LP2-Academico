import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Avaliacao {
	
	private double nota;
	private String dataNota;
	
	public Avaliacao(double nota) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.dataNota = dateFormat.format(new Date());
		this.nota = nota;
	}

	public double getNota() {
		return this.nota;
	}

	public String getDataNota() {
		return this.dataNota;
	}
}
