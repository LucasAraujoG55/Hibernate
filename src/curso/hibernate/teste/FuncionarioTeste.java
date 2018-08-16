package curso.hibernate.teste;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import curso.hibernate.modelo.Funcionario;
import curso.hibernate.modelo.Projeto;

public class FuncionarioTeste {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
		applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		session.beginTransaction();
		
		Funcionario funcionario1 = new Funcionario();
		funcionario1.setNome("Antônio Batista");
		funcionario1.setSalario(2000.0);
		
		Funcionario funcionario2 = new Funcionario();
		funcionario2.setNome("Manuel Oliveira");
		funcionario2.setSalario(2200.0);
		
		Projeto projeto1 = new Projeto();
		projeto1.setNome("Projeto 1");
		
		Projeto projeto2 = new Projeto();
		projeto2.setNome("Projeto 2");
		
		funcionario1.getProjetos().add(projeto1);
		funcionario1.getProjetos().add(projeto2);
		
		funcionario2.getProjetos().add(projeto1);
		
		projeto1.getFuncionarios().add(funcionario1);
		
		projeto2.getFuncionarios().add(funcionario1);
		projeto2.getFuncionarios().add(funcionario2);
		
		session.save(funcionario1);
		session.save(funcionario2);
		//session.save(projeto1);		//session.save(projeto2);
		
		session.getTransaction().commit();
		session.close();
	}
}
