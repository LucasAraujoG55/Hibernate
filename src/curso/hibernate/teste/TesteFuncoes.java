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
		
		System.out.println("Quantidade de funcion�rios: " + salarios);
		/*
		 *  ABS: Calcula o valor absoluto de um n�mero.
			CONCAT: Concatena strings.
			CURRENT_DATE: Recupera a data atual.
			CURRENT_TIME: Recupera o hor�rio atual.
			CURRENT_TIMESTAMP: Recupera a data e o hor�rio atuais.
			LENGTH: Calcula o n�mero de caracteres de uma string.
			LOCATE: Localiza uma string dentro de outra.
			LOWER: Deixa as letras de uma string min�sculas.
			MOD: Calcula o resto da divis�o entre dois n�meros.
			SIZE: Calcula o n�mero de elementos de uma cole��o.
			SQRT: Calcula a raiz quadrada de um n�mero.
			SUBSTRING: Recupera um trecho de uma string.
			UPPER: Deixa as letras de uma string mai�sculas.
			TRIM: Elimina eventuais espa�os no in�cio e no fim de uma string.
		 */
		
		sessao.close();
	}
	
	
}
