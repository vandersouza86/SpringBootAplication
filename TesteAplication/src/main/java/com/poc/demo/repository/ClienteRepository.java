package com.poc.demo.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.poc.demo.entity.Categoria;
import com.poc.demo.entity.Cliente;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query("" + "SELECT d.cliente " 
	          + "FROM 	TitularDependente d " 
	          + "JOIN   d.cliente "
			  + "WHERE 	d.codDependente = :dependente "
	          )
	public Cliente trazerTitular(@Param("dependente") Cliente dependente);
	
	@Query("" + "SELECT 	c " 
	          + "FROM 	Cliente c " 
			  + "WHERE 	c.codCliente = :codCli")
	public Cliente cliente(@Param("codCli") Long codCli);

	@Query("" + "SELECT d.codDependente " 
	          + "FROM 	TitularDependente d " 
	          + "JOIN   d.cliente "
			  + "WHERE 	d.cliente = :titular "
	          )
	public List<Cliente> trazerDependentes(@Param("titular") Cliente titular);
		
	@Query("" + "SELECT 	c " 
	          + "FROM 	Cliente c " 
			  + "WHERE (:cod is null OR c.codCliente = :cod) "
	          + "AND (:nome is null OR c.nome like %:nome% ) "
			  + "AND (cast(:startDate as date) IS NULL OR c.dataAlteracao >= :startDate) "
			  + "AND (cast(:endDate as date) IS NULL OR c.dataAlteracao <= :endDate  ) "
	          + "AND (:cpf is null OR c.cpf = :cpf )"
			  + "AND (:titular is null OR c.titular = :titular ) "
	          + "AND (:unidade is null OR c.unidade = :unidade ) "
	          + "AND (:status is null OR c.status = :status)")
	public List<Cliente> findSort(
			@Param("cod") Long cod,
			@Param("nome") String nome,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate,
			@Param("cpf") String cpf,				
			@Param("titular") Boolean titular, 
			@Param("unidade") String unidade,	
			@Param("status") String status,	
			Sort sort);
	
	
	@Modifying
	@Query(""
			+ "UPDATE 	Cliente c  "
			+ "SET		c.status = :status "
			+ "WHERE 	c.codCliente = :codigo ")
	public void atualizarStatus(@Param("codigo") Long codigo, @Param("status") String status);

	@Modifying
	@Query(""
			+ "UPDATE 	Cliente c  "
			+ "SET		c.categoria = :categoria, "
			+ "c.status = '4' "
			+ "WHERE 	c.codCliente = :codigo ")
	public void aprovarCliente(@Param("codigo") Long codigo, @Param("categoria") Optional<Categoria> categoria);
	  
	 

}
