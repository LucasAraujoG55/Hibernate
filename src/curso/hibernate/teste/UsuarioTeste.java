package curso.hibernate.teste;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import curso.hibernate.modelo.Endereco;
import curso.hibernate.modelo.EstadoCivil;
import curso.hibernate.modelo.Usuario;
import curso.hibernate.modelo.Veiculo;

public class UsuarioTeste {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		usuario.setNome("Usuario Teste 1");
		usuario.setDataNascimento(new Date());
		usuario.setEstadoCivil(EstadoCivil.SOLTEIRO);
		
		Veiculo fusca = new Veiculo("Fusca", 1966);
		Veiculo brasilia = new Veiculo("Brasilia", 1980);
		
		usuario.getVeiculos().add(fusca);
		usuario.getVeiculos().add(brasilia);
		
		
		//usuario.setVeiculo(fusca);
		//fusca.setUsuario(usuario);
		//brasilia.setUsuario(usuario);
		/*Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua Teste");
		endereco.setNumero(123);
		endereco.setCidade("Cidade Teste");
		
		Endereco enderecoComercial = new Endereco();
		enderecoComercial.setLogradouro("Rua Teste C");
		enderecoComercial.setNumero(12345);
		enderecoComercial.setCidade("Cidade Teste C");*/
		
		//SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
		applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		session.beginTransaction();
		
		/*usuario.getEnderecos().add(enderecoComercial);
		usuario.getEnderecos().add(endereco);*/
		
		session.save(usuario);
		//session.save(fusca);
		//session.save(brasilia);
		
		
		
		session.getTransaction().commit();
		
		//Usuario usuarioBanco = (Usuario) session.get(Usuario.class, 3);
		
		session.close();
		
		/*System.out.println("Buscou tudo no banco");
		System.out.println("Nome: " + usuarioBanco.getNome());
		List<Endereco> endercos =  usuarioBanco.getEnderecos();
		System.out.println("Ainda não buscou do banco");
		System.out.println("Endereco " + endercos.get(0).getLogradouro());*/
		
		
		
	}
}
