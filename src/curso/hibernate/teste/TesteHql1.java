package curso.hibernate.teste;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import curso.hibernate.modelo.Funcionario;

public class TesteHql1 {

	public static void main(String[] args) {
		
		Session sessao = GeradorSessionFactory
				.obterSessionFactory().openSession();
		
		Query consulta = sessao
				.createQuery("select f from Funcionario f order by f.nome");
		
		List<Funcionario> funcionarios = consulta.list();
		
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Cpf: " + funcionario.getCpf());
			System.out.println("----------------------------\n");
		}
		
		sessao.close();
	}
}
