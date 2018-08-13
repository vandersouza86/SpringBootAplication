package com.poc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.demo.VO.FiltroListaClienteVO;
import com.poc.demo.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService cs;

	@GetMapping
	public ResponseEntity<?> listarPreCadastro(FiltroListaClienteVO filter) {

		if (filter.getOrderField() == null) {
			filter.setOrderField("codCliente");
		}
		if (filter.getOrderDirection() == null) {
			filter.setOrderDirection("DESC");
		}
		try {
			cs.listarPreCadastro(filter);
			return new ResponseEntity<>(cs.listarPreCadastro(filter), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Não foi possivel efetuar a ação ", HttpStatus.SERVICE_UNAVAILABLE);

		}

	}

	@GetMapping("/detalhecliente")
	public ResponseEntity<?> detalheCliente(@RequestParam("codigo") Long codigo) {
		try {
			cs.detalharCliente(codigo);
			return new ResponseEntity<>(cs.detalharCliente(codigo), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Não foi possivel efetuar a ação ", HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@PostMapping("/aprovacliente")
	public ResponseEntity<?> aprovarCliente(@RequestParam("codigo") Long codigo,
			@RequestParam("categoria") Long categoria) {
		try {
			cs.aprovarCliente(codigo, categoria);
			return new ResponseEntity<>("Cliente aprovado com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Não foi possivel efetuar a ação ", HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@DeleteMapping
	public ResponseEntity<?> deletarCliente(@RequestParam("codigo") Long codigo) {
		try {
			cs.deletarCliente(codigo);
			return new ResponseEntity<>("Cliente deletado com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Não foi possivel efetuar a ação ", HttpStatus.SERVICE_UNAVAILABLE);
		}

	}

}
