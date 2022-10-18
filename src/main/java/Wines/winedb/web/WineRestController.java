package Wines.winedb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Wines.winedb.domain.Wine;
import Wines.winedb.domain.WineRepository;

@RestController
public class WineRestController {
	
	@Autowired
	private WineRepository repository;
	
	//Listaa kaikki viinit
		@GetMapping("/wines")
		public Iterable<Wine> WineListRest() {
		return repository.findAll();
		}
		
		//Etsii IDn perusteella
		@GetMapping("/wines/{id}")
		Optional <Wine> findWineRest(@PathVariable Long id) {
		return repository.findById(id);
		}
		
		//Lisää uuden viinin
		@PostMapping("wines")
		Wine newWine(@RequestBody Wine newWine) {
			return repository.save(newWine);
		}
		
		//Muuttaa viinin tietoja
		@PutMapping("/wines/{id}")
		Wine editWine(@RequestBody Wine editedWine, @PathVariable Long id) {
			editedWine.setId(id);
			return repository.save(editedWine);
		}
		
		//Poistaa kirjan
		@DeleteMapping("/wines/{id}")
		public Iterable<Wine> deleteWine(@PathVariable Long id) {
			repository.deleteById(id);
			return repository.findAll();
		}

}
