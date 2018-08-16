package curso.hibernate.teste;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import curso.hibernate.modelo.Funcionario;

public class TesteHqlParametros {

	public static void main(String[] args) {
		
		Session sessao = GeradorSessionFactory
				.obterSessionFactory().openSession();
		
		Integer id = 7;
		//Double salario = 2000.0;
		
		Query consulta = sessao
				.createQuery("from Funcionario where id >= :idFunc and " +
						"salario < :salario order by nome");
		consulta.setParameter("idFunc", id);
		consulta.setParameter("salario", 2000.0);
		
		/*Query consulta = sessao
				.createQuery("from Funcionario where id >= ? or " +
						"salario < ? order by nome");
		consulta.setParameter(0, id);
		consulta.setParameter(1, salario);*/
		List<Funcionario> funcionarios = consulta.list();
		
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Id: " + funcionario.getId());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Cpf: " + funcionario.getCpf());
			System.out.println("Salário: " + funcionario.getSalario());
			System.out.println("----------------------------\n");
		}
		
		sessao.close();
	}
}
