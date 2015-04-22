package br.com.caelum.vraptor.sysweb.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;

import org.junit.Test;

import br.com.caelum.vraptor.sysweb.GenericTest;
import br.com.caelum.vraptor.sysweb.enums.MedidaEnum;

/**
 * @author Fidelis
 *
 */
public class MedicamentoTest extends GenericTest {
	
	@Test
	public void testOverViewMedicamento(){
		
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
	
	/**
	 * Um usuário foi atendido por um medico
	 * e diagnosticou-se bronquite asmática
	 * na receita expedida pelo médico
	 * para o tratamento consta as seguintes posologias:
	 */
	@Test
	public void testBronquiteAsmatica(){
		Usuario usuario = new Usuario();
		usuario.setNome("joao doente");
		
		Atendimento atendimento = new Atendimento();
		atendimento.setNomeLocal("hospital curare");
		atendimento.setUsuario(usuario);

		Medico medico = new Medico();
		medico.setNome("Dr. house");
		
		atendimento.setMedicos(Collections.singleton(medico));
		
		Receituario receituario = new Receituario();
		medico.setReceituarios(Collections.singleton(receituario));
		
		Tratamento tratamento = new Tratamento();
		tratamento.setNome("Bronquite asmática");
		
		receituario.setTratamentos(Collections.singleton(tratamento));
		//posologia 1
		Posologia posologia1 = new Posologia();
		posologia1.setNome("Expectorante");
		tratamento.setPosologias(Collections.singleton(posologia1));
		
		Medicamento medicamento1 = new Medicamento();
		medicamento1.setNome("Predimisolona");
		
		posologia1.setMedicamentos(Collections.singleton(medicamento1));
		
		//posologia 2
		Posologia posologia2 = new Posologia();
		posologia2.setNome("Bronquilo dilatação");
		tratamento.setPosologias(Collections.singleton(posologia2));
		
		Medicamento medicamento2 = new Medicamento();
		medicamento2.setNome("Berotec");
		
		posologia2.setMedicamentos(Collections.singleton(medicamento2));
		
		Medicamento medicamento3 = new Medicamento();
		medicamento3.setNome("Astrovent");
		
		posologia2.setMedicamentos(Collections.singleton(medicamento3));
		
		Medicamento medicamento4 = new Medicamento();
		medicamento4.setNome("Soro fisiologico");
		
		posologia2.setMedicamentos(Collections.singleton(medicamento4));
		
		//iteração medicamentosa 1
		Iteracao iteracao1 = new Iteracao();
		posologia2.setIteracoes(new TreeSet<Iteracao>());
		
		iteracao1.setOrder(1);
		iteracao1.setIntervaloHoras(4);
		iteracao1.setDias(2);
		iteracao1.setMedicamentos(new TreeSet<Medicamento>());
		iteracao1.getMedicamentos().add(medicamento2);
		iteracao1.getMedicamentos().add(medicamento3);
		iteracao1.getMedicamentos().add(medicamento4);
		
		posologia2.getIteracoes().add(iteracao1);

		//iteração medicamentosa 2
		Iteracao iteracao2 = new Iteracao();
		iteracao2.setOrder(2);
		iteracao2.setIntervaloHoras(8);
		iteracao2.setDias(3);
		iteracao2.setMedicamentos(new TreeSet<Medicamento>());
		iteracao2.getMedicamentos().add(medicamento2);
		iteracao2.getMedicamentos().add(medicamento4);
		
		posologia2.getIteracoes().add(iteracao2);
		
		
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
