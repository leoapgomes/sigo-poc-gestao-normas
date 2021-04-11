package br.com.indtexbr.sigo.gestaodenormas.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.indtexbr.sigo.gestaodenormas.dto.NormaDTO;
import br.com.indtexbr.sigo.gestaodenormas.form.NormaForm;
import br.com.indtexbr.sigo.gestaodenormas.models.Norma;
import br.com.indtexbr.sigo.gestaodenormas.repository.NormaRepository;

@RestController
@RequestMapping("/normas")
public class GestaoDeNormasController {

	@Autowired
	private NormaRepository normasRepository;
	
	@GetMapping
	public List<NormaDTO> all(){	
		List <Norma> contratos = normasRepository.findAll();
		return contratos.stream().map(NormaDTO::new).collect(Collectors.toList());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NormaDTO> get(@PathVariable Long id){
		
		Optional<Norma> norma = normasRepository.findById(id);
		if (norma.isPresent()) {
			return ResponseEntity.ok(new NormaDTO(norma.get()));
		}
		
		return ResponseEntity.notFound().build();		
	}	


	@PostMapping
	@Transactional
	public ResponseEntity<NormaDTO> post(@RequestBody @Valid NormaForm form, UriComponentsBuilder uriBuilder) {
		
		Norma norma = form.toNorma();
		normasRepository.save(norma);
		
		URI uri = uriBuilder.path("/normas/{id}").buildAndExpand(norma.getId()).toUri();
		return ResponseEntity.created(uri).body( new NormaDTO(norma) );
	}	
		

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<NormaDTO> put(@PathVariable Long id, @RequestBody @Valid NormaForm form) {
		
		Optional<Norma> optional = normasRepository.findById(id);
		if (optional.isPresent()) {
			Norma norma = normasRepository.getOne(id);
			
			norma.setTitulo(form.getTitulo());
			norma.setNorma(form.getNorma());
			norma.setTipoDeNorma(form.getTipoDeNorma());
			norma.setUrl(form.getUrl());
			
			return ResponseEntity.ok(new NormaDTO(norma));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Norma> optional = normasRepository.findById(id);
		if (optional.isPresent()) {
			normasRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}	
	
	
}