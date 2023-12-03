package dianome.entregas.controles;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dianome.entregas.dtos.EntregadoresDto;
import dianome.entregas.modelos.EntregasModelos;
import dianome.entregas.repositorio.Repositorio;
import jakarta.validation.Valid;

@RestController
public class ControleEntregadores {
	
	@Autowired
	
	Repositorio repositorio;
	
	@GetMapping("/entregadores")
	public ResponseEntity<List<EntregasModelos>> listar(){
		
		List<EntregasModelos> entregadoreslist = repositorio.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(entregadoreslist);
	}
	
	@PostMapping ("/entregadores")
	public ResponseEntity<EntregasModelos> salvar (@RequestBody @Valid EntregadoresDto entregadoresdto) {
		var EntregasModelos = new EntregasModelos();
		BeanUtils.copyProperties(entregadoresdto,EntregasModelos);
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(EntregasModelos));
	}
	
	@GetMapping("/entregadores/{id}")
	public ResponseEntity <Object> detalhar (@PathVariable(value = "id") Integer id){ 
	Optional<EntregasModelos> Entregadores = repositorio.findById(id);
	if (Entregadores.isEmpty()) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado");
	}
	return ResponseEntity.status(HttpStatus.OK).body(Entregadores.get());
	
	}
			
	@PutMapping("/entregadores/{id}")	
	public ResponseEntity <Object> AtualizarEntregadores(@PathVariable(value="id")Integer id,
													@RequestBody @Valid EntregadoresDto entregadoresdto){
	Optional<EntregasModelos> Entregadores = repositorio.findById(id);
	if (Entregadores.isEmpty()) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado"); 
	}
	var EntregasModelos = Entregadores.get();
	BeanUtils.copyProperties(entregadoresdto,EntregasModelos);
	return ResponseEntity.status(HttpStatus.OK).body(repositorio.save(EntregasModelos));
	}
	
	@DeleteMapping("/entregadores/{id}")
	public ResponseEntity <Object> DeletarEntregadores(@PathVariable(value="id")Integer id) {	
	Optional<EntregasModelos> Entregadores = repositorio.findById(id);
	if (Entregadores.isEmpty()) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado");
	}
	
	repositorio.delete(Entregadores.get());
	return ResponseEntity.status(HttpStatus.OK).body("Entregador deletado");
	
}}
			
			
			
			
	
	