package curso.hibernate.heranca;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("quatro_rodas")
@Table(name = "veiculo_quatro_rodas")
public class VeiculoQuatroRodas extends VeiculoHeranca {

	private Integer quantidadePortas;

	public Integer getQuantidadePortas() {
		return quantidadePortas;
	}

	public void setQuantidadePortas(Integer quantidadePortas) {
		this.quantidadePortas = quantidadePortas;
	}

}
