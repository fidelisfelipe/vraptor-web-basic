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
		//consoleInformacoes(primeiraDose, sdf, nome, intervaloHoras, dose,
		//		medida, horasMedicacao, totalMedida);
	}
	
	/**
	 * Um usuário foi atendido por um medico
	 * e diagnosticou-se bronquite asmática
	 * na receita expedida pelo médico
	 * para o tratamento consta as seguintes posologias:
	 */
	@Test
	public void testBronquiteAsmatica(){
		//o usuario
		Usuario usuario = new Usuario();
		usuario.setNome("joao doente");
		
		//foi atendido
		Atendimento atendimento = new Atendimento();
		atendimento.setNomeLocal("hospital curare");
		atendimento.setUsuario(usuario);
		
		//pelo medico
		Medico medico = new Medico();
		medico.setNome("Dr. house");
		
		//o atendimento foi feito pelo medico
		atendimento.setMedicos(Collections.singleton(medico));
		
		//que receitou
		Receituario receituario = new Receituario();
		medico.setReceituarios(Collections.singleton(receituario));
		
		//o seguinte tratamento
		Tratamento tratamento = new Tratamento();
		tratamento.setOrder(1);
		tratamento.setNome("Bronquite asmática");
		
		//a receita possui um tratamento
		receituario.setTratamentos(new TreeSet<Tratamento>());
		receituario.getTratamentos().add(tratamento);

		//o tratamento possui varias posologias
		// a primeira indica que deve ser tratado o catarro no peito com expectorante
		
		//posologia 1
		Posologia posologia1 = new Posologia();
		posologia1.setOrdem(1);
		posologia1.setNome("Expectorante");

		tratamento.setPosologias(new TreeSet<Posologia>());
		tratamento.getPosologias().add(posologia1);
		
		//e para isso deve ser ministrado a seguinte medicação
		Medicamento medicamento1 = new Medicamento();
		medicamento1.setOrder(1);
		
		//o charope de predimisolona
		//5 ml
		medicamento1.setNome("Predimisolona");
		medicamento1.setDose(5);
		medicamento1.setMedida(MedidaEnum.ML);
		
		//uma vez por dia
		//durante 5 dias
		Iteracao iteracao1 = new Iteracao();
		iteracao1.setOrder(1);
		iteracao1.setDias(5);
		iteracao1.setIntervaloHoras(24);
		
		iteracao1.setMedicamentos(new TreeSet<Medicamento>());
		iteracao1.getMedicamentos().add(medicamento1);
		posologia1.setIteracoes(new TreeSet<Iteracao>());
		posologia1.getIteracoes().add(iteracao1);
		
		//posologia 2
		Posologia posologia2 = new Posologia();
		posologia2.setOrdem(2);
		posologia2.setNome("Bronquio dilatação");
		tratamento.getPosologias().add(posologia2);
		
		Medicamento medicamento2 = new Medicamento();
		medicamento2.setOrder(1);
		medicamento2.setNome("Berotec");
		medicamento2.setDose(5);
		medicamento2.setMedida(MedidaEnum.GOTAS);
		
		Medicamento medicamento3 = new Medicamento();
		medicamento3.setOrder(2);
		medicamento3.setNome("Astrovent");
		medicamento3.setDose(5);
		medicamento3.setMedida(MedidaEnum.GOTAS);
		
		
		Medicamento medicamento4 = new Medicamento();
		medicamento4.setOrder(3);
		medicamento4.setNome("Soro fisiologico");
		medicamento4.setDose(3);
		medicamento4.setMedida(MedidaEnum.ML);
		
		//iteração medicamentosa 1
		Iteracao iteracao2 = new Iteracao();
		
		iteracao2.setOrder(1);
		iteracao2.setIntervaloHoras(4);
		iteracao2.setDias(2);
		iteracao2.setMedicamentos(new TreeSet<Medicamento>());
		iteracao2.getMedicamentos().add(medicamento2);
		iteracao2.getMedicamentos().add(medicamento3);
		iteracao2.getMedicamentos().add(medicamento4);
		
		posologia2.setIteracoes(new TreeSet<Iteracao>());
		posologia2.getIteracoes().add(iteracao2);

		//iteração medicamentosa 2
		Iteracao iteracao3 = new Iteracao();
		
		iteracao3.setOrder(2);
		iteracao3.setIntervaloHoras(6);
		iteracao3.setDias(2);
		iteracao3.setMedicamentos(new TreeSet<Medicamento>());
		iteracao3.getMedicamentos().add(medicamento2);
		iteracao3.getMedicamentos().add(medicamento4);
		
		posologia2.getIteracoes().add(iteracao3);
		
		//iteração medicamentosa 3
		Iteracao iteracao4 = new Iteracao();
		
		iteracao4.setOrder(3);
		iteracao4.setIntervaloHoras(8);
		iteracao4.setDias(3);
		iteracao4.setMedicamentos(new TreeSet<Medicamento>());
		iteracao4.getMedicamentos().add(medicamento2);
		iteracao4.getMedicamentos().add(medicamento4);
		
		posologia2.getIteracoes().add(iteracao4);
		
		//posologia 3
		Posologia posologia3 = new Posologia();
		posologia3.setOrdem(3);
		posologia3.setNome("Fortalecimento da imunidade");
		tratamento.getPosologias().add(posologia3);
		
		Medicamento medicamento5 = new Medicamento();
		medicamento5.setOrder(5);
		medicamento5.setNome("Vitamina C");
		medicamento5.setDose(500);
		medicamento5.setMedida(MedidaEnum.MG);

		Medicamento medicamento6 = new Medicamento();
		medicamento6.setOrder(6);
		medicamento6.setNome("Rhodiola rosea");
		medicamento6.setDose(1);
		medicamento6.setMedida(MedidaEnum.CAPSULA);
		
		Iteracao iteracao5 = new Iteracao();
		
		iteracao5.setOrder(1);
		iteracao5.setIntervaloHoras(8);
		iteracao5.setDias(30);
		iteracao5.setMedicamentos(new TreeSet<Medicamento>());
		iteracao5.getMedicamentos().add(medicamento5);
		iteracao5.setPrimeiraDoseEmJejum(Boolean.TRUE);
		
		Iteracao iteracao6 = new Iteracao();
		
		iteracao6.setOrder(1);
		iteracao6.setIntervaloHoras(8);
		iteracao6.setDias(30);
		iteracao6.setMedicamentos(new TreeSet<Medicamento>());
		iteracao6.getMedicamentos().add(medicamento6);
		iteracao6.setPrimeiraDoseEmJejum(Boolean.TRUE);
		
		posologia3.setIteracoes(Collections.singleton(iteracao6));
		
		
		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(" O usuário "+atendimento.getUsuario().getNome());
		sb.append("\n foi atendido na unidade "+atendimento.getNomeLocal());
		
		for (Medico m : atendimento.getMedicos()) {
			sb.append("\n pelo medico "+m.getNome());
			for (Receituario r : m.getReceituarios()) {
				for (Tratamento t : r.getTratamentos()) {
					sb.append("\n foi diagnosticado "+t.getNome());
					for (Posologia p : t.getPosologias()) {
						sb.append("\n");
						sb.append("\n e para seu tratamento com foco "+p.getNome());
						sb.append("\n as seguintes iterações medicamentosas:");
						for (Iteracao i : p.getIteracoes()) {
							sb.append("\n "+i.getOrder());
							sb.append(" ministrar no intervalo de  "+i.getIntervaloHoras()+" horas ");
							sb.append(" durante  "+i.getDias()+" dias ");
							
							if(i.isPrimeiraDoseEmJejum()){
								sb.append("\n sendo a primeira dose do dia em jejum ");
							}
							
							for (Medicamento medicamento : i.getMedicamentos()) {
								sb.append("\n o medicamento "+medicamento.getNome());
								sb.append(" sob a dosagem de : "+medicamento.getDose()+" "+medicamento.getMedida());
							}
						}
						
					}
					
				}
			}
		}
		
		System.out.println(sb.toString());
		
		
		
		
		
		
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
