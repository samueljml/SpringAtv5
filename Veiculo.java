package br.samuka.fatec_ipi_paoo_jpa_hibernate_atv.model.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo {

		@Id
		@GeneratedValue
		private Long id;
		
		@Column(nullable = false, length = 40)
		private String modelo;
		
		@Column(nullable = true, length = 30)
		private String marca;
		
		@Column(nullable = true, length = 20)
		private String cor;
		
		@OneToOne
		@JoinColumn(name ="id_da_minha_placa")
		private Placa placa;
		
		@ManyToOne
		private Pessoa pessoa;
		
		/*@ManyToMany
		@JoinTable(name="tb_veiculo_reboque", 
		joinColumns = @JoinColumn(name="id_veiculo"), inverseJoinColumns = @JoinColumn(name="id_reboque"))
		private List<Reboque> reboques;*/
		
		@OneToMany(mappedBy = "veiculo")
		private List<VeiculoReboque> veiculosReboques;
		
		public Pessoa getPessoa() {
			return pessoa;
		}
		
		public void setPessoa(Pessoa pessoa) {
			this.pessoa = pessoa;
		}
		
		public Placa getPlaca() {
			return placa;
		}

		public void setPlaca(Placa placa) {
			this.placa = placa;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public String getCor() {
			return cor;
		}

		public void setCor(String cor) {
			this.cor = cor;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Veiculo other = (Veiculo) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Veiculo [id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", cor=" + cor + ", placa=" + placa
					+ ", pessoa=" + pessoa + "]";
		}

		
		
		
		
		
	
}
