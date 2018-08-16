package curso.hibernate.teste;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import curso.hibernate.heranca.VeiculoDuasRodas;
import curso.hibernate.heranca.VeiculoQuatroRodas;

public class VeiculoHerancaTeste {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
		applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		session.beginTransaction();
		
		VeiculoDuasRodas moto = (VeiculoDuasRodas) 
				session.get(VeiculoDuasRodas.class, 2);
		
		/*VeiculoQuatroRodas fusca = new VeiculoQuatroRodas();
		fusca.setMarca("VW");
		fusca.setModelo("Golf");
		fusca.setAno(2006);
		fusca.setQuantidadePortas(2);
		
		VeiculoDuasRodas moto = new VeiculoDuasRodas();
		moto.setMarca("Honda");
		moto.setModelo("Titan");
		moto.setAno(2015);
		moto.setCilindradas(125);
		
		session.save(fusca);
		session.save(moto);*/
		
		session.getTransaction().commit();
		session.close();
	}
}
