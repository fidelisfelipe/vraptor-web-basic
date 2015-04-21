package br.com.caelum.vraptor.sysweb.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

import br.com.caelum.vraptor.sysweb.GenericTest;

/**
 * @author Fidelis
 *
 */
enum MedidaEnum{ML,GOTAS,CAPSULAS}
public class MedicamentoTest extends GenericTest {
	
	@Test
	public void overViewMedicamento(){
		
		final int HR_DIA = 24;
		//configuracoes
		Calendar primeiraDose = newCalendarBR();
		SimpleDateFormat sdf = newSimpleDateFormatBR();
		Calendar intervalo = newCalendarBR();
		
		String nome = "Charope";
		int intervaloHoras = 12;
		int totalDias = 5;
		long intervaloMilis = intervalHoraEmMili(intervaloHoras);
		double dose = 2.5;
		MedidaEnum medida = MedidaEnum.ML;
		
		//converte horas em minutos, minutos em segundos, segundos em milissegundos
		intervalo.setTimeInMillis(intervaloMilis);
		
		//horarios das medicações
		List<Date> horasMedicacao = new ArrayList<Date>();
		
		//com a primera hora
		Calendar ultimaDose = newCalendarBR();
		ultimaDose.setTime(primeiraDose.getTime());
		
		//cria a ultima hora
		ultimaDose.add(Calendar.HOUR, totalDias*HR_DIA);
		
		//cada dose será a primeira somada ao intervalo
		Calendar proximaDose = newCalendarBR();
		primeiraDose.setTime(primeiraDose.getTime());

		while(proximaDose.before(ultimaDose)){
			proximaDose.add(Calendar.HOUR, intervaloHoras);
			horasMedicacao.add(proximaDose.getTime());
		}
		double totalMedida = getTotalMedidas(dose, horasMedicacao);
		
		//saida das informações
		consoleInformacoes(primeiraDose, sdf, nome, intervaloHoras, dose,
				medida, horasMedicacao, totalMedida);
	}

	private double getTotalMedidas(double dose, List<Date> horasMedicacao) {
		return dose*(horasMedicacao.size()+1);
	}

	private void consoleInformacoes(Calendar primeiraDose,
			SimpleDateFormat sdf, String nome, int intervaloHoras, double dose,
			MedidaEnum medida, List<Date> horasMedicacao, double totalMedida) {
		System.out.println("tabela de horarios para "+nome);
		System.out.println("Medicamento: "+nome);
		System.out.println("O medicamento deve conter "+totalMedida+" "+medida.toString());
		System.out.println("Cada dose: "+dose);
		System.out.println("Medida: "+medida);
		System.out.println("intervalo em horas: "+intervaloHoras);
		System.out.println("Total de doses: "+(horasMedicacao.size()+1));
		System.out.println(""+sdf.format(primeiraDose.getTime()));
		for (Date date : horasMedicacao) {
			System.out.println(""+sdf.format(date));
		}
	}

	private SimpleDateFormat newSimpleDateFormatBR() {
		String pattern = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf;
	}

	private Calendar newCalendarBR() {
		Locale aLocale = new Locale("pt","BR");
		return Calendar.getInstance(aLocale);
	}

	private int intervalHoraEmMili(int intervaloHoras) {
		return ((intervaloHoras*60)*60)*1000;
	}

}
