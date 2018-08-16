package curso.hibernate.teste;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import curso.hibernate.modelo.Funcionario;

public class TesteManipulacaoData {

	public static void main(String[] args) {
		
		Session sessao = GeradorSessionFactory
				.obterSessionFactory().openSession();
		
		Query consulta = sessao
				.createQuery("select f from Funcionario f where day(f.dataAdmissao) = " +
						"day(current_date) and hour(f.dataAdmissao) = month(current_date) " +
						"order by f.nome");
		//consulta.setParameter("ano", 2015);
		List<Funcionario> funcionarios = consulta.list();
		
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Cpf: " + funcionario.getCpf());
			System.out.println("Data Admissão: " + formatarData(
					funcionario.getDataAdmissao()));
			System.out.println("----------------------------\n");
		}
		
		sessao.close();
	}
	
	public static String formatarData(Date data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data);
	}
}
