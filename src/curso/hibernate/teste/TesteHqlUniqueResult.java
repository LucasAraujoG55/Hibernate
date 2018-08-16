package curso.hibernate.teste;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import curso.hibernate.modelo.Funcionario;

public class TesteHqlUniqueResult {

	public static void main(String[] args) {
		
		
		Funcionario funcionario = obterPorId(10);
		
		
		if(funcionario != null) {
			System.out.println("Id: " + funcionario.getId());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Cpf: " + funcionario.getCpf());
		} else {
			System.out.println("Funcionário não encontrado");
		}
		
		
		/*List<Funcionario> funcionarios = consulta.list();
		
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Id: " + funcionario.getId());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Cpf: " + funcionario.getCpf());
			System.out.println("----------------------------\n");
		}*/
		
	}
	
	private static Funcionario obterPorId(Integer id) {
		Session sessao = GeradorSessionFactory
				.obterSessionFactory().openSession();
		
		Query consulta = sessao
				.createQuery("select f from Funcionario f where f.id = :id order by f.nome");
		
		consulta.setParameter("id", id);
		
		List<Funcionario> funcionarios = consulta.list();
		
		sessao.close();
		
		if(funcionarios.isEmpty()) {
			return null;
		} else {
			return funcionarios.get(0);
		}
		
		//Funcionario funcionario = (Funcionario) consulta.uniqueResult();
	}
}
