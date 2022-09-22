package rva.ctrls;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import rva.jpa.Fakultet;
import rva.repositories.FakultetRepository;

@RestController
public class FakultetRestController {

	@Autowired
	private FakultetRepository faRep;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//za sql u javi
	
	@GetMapping("fakultet")
	public Collection<Fakultet> getFakulteti(){
		return faRep.findAll();
	}
	
	@GetMapping("fakultet/{id}")
	public Fakultet getFakultet(@PathVariable("id") Integer id) {
		return faRep.getOne(id);
	}
	
	@GetMapping("fakultetNaziv/{naziv}")
	public Collection<Fakultet> getFakultetiByNaziv(@PathVariable("naziv") String naziv){
		return faRep.findByNazivContainingIgnoreCase(naziv);
	}
	
	@PostMapping("fakultet")
	public ResponseEntity<Fakultet> insertFakultet(@RequestBody Fakultet fakultet){
		if(!faRep.existsById(fakultet.getId())) {
			faRep.save(fakultet);
			return new ResponseEntity<Fakultet>(HttpStatus.OK);
		}
		return new ResponseEntity<Fakultet>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("fakultet")
	public ResponseEntity<Fakultet> updateFakultet(@RequestBody Fakultet fakultet){
		if(faRep.existsById(fakultet.getId())) {
				faRep.save(fakultet);
				return new ResponseEntity<Fakultet>(HttpStatus.OK);
			}
			return new ResponseEntity<Fakultet>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("fakultet/{id}")
	public ResponseEntity<Fakultet> deleteFakultet(@PathVariable("id") Integer id){
		if(faRep.existsById(id)) {
				faRep.deleteById(id);
				if(id==-100) {
					jdbcTemplate.execute("insert into fakultet(id, naziv, sediste) values(-100, 'test', 'test')");
				}
				return new ResponseEntity<Fakultet>(HttpStatus.OK);
			}
			return new ResponseEntity<Fakultet>(HttpStatus.NO_CONTENT);
	}
	
		
	
}
