package curso.hibernate.teste;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import curso.hibernate.modelo.Funcionario;

public class TesteFuncionarioCRUD {

	public static void main(String[] args) {
		// Create
		Funcionario funcionario = new Funcionario("Marcos Souza", 
				1800.0, "223344-66", new Date());
		//create(funcionario);

		
		// Read
		Funcionario funcionarioBanco = read(11);
		System.out.println("Nome: " + funcionarioBanco.getNome());
		
		// Update
		//funcionarioBanco.setNome("Manuel de Oliveira");
		//funcionarioBanco.setCpf("65432-23");
		//funcionarioBanco.setId(22);
		funcionarioBanco.setDataAdmissao(new Date());
		update(funcionarioBanco);
		
		// Save or Update
		//salvarOuAlterar(funcionarioBanco);
		
		// Delete
		//Funcionario funcionarioRemover = read(2);
		//delete(8);
	}
	
	private static void create(Funcionario funcionario) {
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(funcionario);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	private static Funcionario read(Integer idFuncionario) {
		Session session = obterSessionFactory().openSession();
		
		Funcionario funcionario = (Funcionario) session
				.get(Funcionario.class, idFuncionario);
		
		session.close();
		
		return funcionario;
		
	}
	
	private static void update(Funcionario funcionario) {
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		
		session.update(funcionario);
		
		session.getTransaction().commit();
		
		session.close();
		
	}
	
	private static void salvarOuAlterar(Funcionario funcionario) {
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(funcionario);
		
		session.getTransaction().commit();
		
		session.close();
		
	}
	
	public static void delete(Integer idFuncionario) {
		Session session = obterSessionFactory().openSession();
		session.beginTransaction();
		
		Funcionario func = read(idFuncionario);
		session.delete(func);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	private static SessionFactory obterSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
		applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		return factory;
	}
}
