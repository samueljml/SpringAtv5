package br.nicolar_ipi.fatec_ipi_paoo_async_named_querrys_atv.model.repository;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import br.nicolar_ipi.fatec_ipi_paoo_async_named_querrys_atv.model.beans.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade,Long>{
	
	@Async
	public Future<List<Cidade>> findByNome(String nome);
	@Async
	public Future<List<Cidade>> findByLatitudeLongitude(double latitude, double longitude);
	@Async
	public Future<List<Cidade>> findByNomeIgnoreCase(String nome);
	
	//@Query ("SELECT a FROM Aluno a WHERE a.email = ?1")
	//public Aluno buscarUmAlunoPeloSeuEmail(String email);
	
	@Query ("SELECT c FROM Cidade c WHERE c.nome= ?1")
	public Cidade buscarCidadePeloNome(String nome);
	
	@Query ("SELECT c FROM Cidade c WHERE c.latitude= :lati AND c.longitude= :longi")
	public Cidade buscarCidadePelaLatitudeELongitude(@Param("lati") double latitude, @Param("longi")double longitude);
	
	@Query ("SELECT c FROM Cidade c WHERE LOWER(c.nome)= LOWER(?1)")
	public Cidade buscarCidadePeloNomeIgnoreCase(String nome);
	
	//public Aluno buscarPeloNomeEPeloEmail(@Param ("nome") String nome, @Param("email") String email);
	public Cidade buscarPeloNome (@Param("nome") String nome);
	
	public Cidade buscarPelaLatitudeLongitude(@Param("lati") double latitude, @Param("longi") double longitude);
	
	public Cidade buscarPeloNomeIgnoteCase(@Param("nomeIgnoreCase") String nome);
	
}