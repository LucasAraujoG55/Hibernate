package curso.hibernate.teste;

import org.hibernate.Query;
import org.hibernate.Session;

public class TesteFuncoes {

	public static void main(String[] args) {
		
		Session sessao = GeradorSessionFactory
				.obterSessionFactory().openSession();
		
		/*Query consulta = sessao.createQuery("select count(*) " +
				"from Funcionario where month(dataAdmissao) = :mes");
		consulta.setParameter("mes", 3);*/
		Query consulta = sessao.createQuery("select count(distinct salario) " +
				"from Funcionario");
		long salarios = (long) consulta.uniqueResult();
		
		System.out.println("Quantidade de funcionários: " + salarios);
		/*
		 *  ABS: Calcula o valor absoluto de um número.
			CONCAT: Concatena strings.
			CURRENT_DATE: Recupera a data atual.
			CURRENT_TIME: Recupera o horário atual.
			CURRENT_TIMESTAMP: Recupera a data e o horário atuais.
			LENGTH: Calcula o número de caracteres de uma string.
			LOCATE: Localiza uma string dentro de outra.
			LOWER: Deixa as letras de uma string minúsculas.
			MOD: Calcula o resto da divisão entre dois números.
			SIZE: Calcula o número de elementos de uma coleção.
			SQRT: Calcula a raiz quadrada de um número.
			SUBSTRING: Recupera um trecho de uma string.
			UPPER: Deixa as letras de uma string maiúsculas.
			TRIM: Elimina eventuais espaços no início e no fim de uma string.
		 */
		
		sessao.close();
	}
	
	
}
