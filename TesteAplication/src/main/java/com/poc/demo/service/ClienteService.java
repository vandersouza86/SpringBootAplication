package com.poc.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.poc.demo.VO.FiltroListaClienteVO;
import com.poc.demo.VO.PreCadastroVO;
import com.poc.demo.entity.Categoria;
import com.poc.demo.entity.Cliente;
import com.poc.demo.repository.CategoriaRepository;
import com.poc.demo.repository.ClienteRepository;



@Component
public class ClienteService {

	@Autowired
	private ClienteRepository cr;
	
	@Autowired
	private CategoriaRepository ct;

	public List<PreCadastroVO> listarPreCadastro(FiltroListaClienteVO filtro) {
		List<PreCadastroVO> preCadastroVO = new ArrayList<PreCadastroVO>();

		List<Cliente> clientes = 
				cr.findSort(
					filtro.getCodCliente(),
					filtro.getNome(),
					filtro.getStartDate(),
					filtro.getEndDate(),
					filtro.getCpf(),
					filtro.getTitular(),
					filtro.getUnidade(),
					filtro.getStatus(),
					orderBy(filtro.getOrderField(), (Sort.Direction.fromString(filtro.getOrderDirection().toUpperCase())))
				);

		for (Cliente cliente : clientes) {
			PreCadastroVO clienteVO = new PreCadastroVO();
			clienteVO.setCodCliente(cliente.getCodCliente());
			clienteVO.setCpf(cliente.getCpf());
			clienteVO.setDataAlteracao(cliente.getDataAlteracao());
			clienteVO.setNome(cliente.getNome());
			clienteVO.setStatus(cliente.getStatus());
			clienteVO.setTitular(cliente.getTitular());
			clienteVO.setUnidade(cliente.getUnidade());

			preCadastroVO.add(clienteVO);
		}
			return preCadastroVO;
	}

	public Cliente detalharCliente(Long codigo) {
		Cliente clvo = cr.cliente(codigo);

		if (clvo.getTitular()) {
			List<Cliente> cls = cr.trazerDependentes(clvo);
			clvo.getDependentes().addAll(cls);
		} else {
			Cliente cl = cr.trazerTitular(clvo);
			clvo.setTitularInfo(cl);
		}
		return clvo;
	}
	
	
	public void aprovarCliente(Long codCliente, Long codCategoria) {
		Optional<Categoria> categoria = ct.findById(codCategoria);
		cr.aprovarCliente(codCliente, categoria);
	}
	
	private Sort orderBy(String param,Sort.Direction order) {
		return new Sort(order,param);
	}

	public void deletarCliente(Long codigo) {
		cr.deleteById(codigo);
	}

}
