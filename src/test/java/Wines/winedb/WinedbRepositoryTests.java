package Wines.winedb;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import Wines.winedb.domain.Wine;
import Wines.winedb.domain.WineRepository;
import Wines.winedb.domain.Country;
import Wines.winedb.domain.CountryRepository;
import Wines.winedb.domain.Type;
import Wines.winedb.domain.TypeRepository;

@DataJpaTest
class WinedbRepositoryTests {

	@Autowired
	WineRepository wrepository;
	
	@Autowired
	CountryRepository crepository;
	
	@Autowired
	TypeRepository trepository;
	
	@Test
	public void findWineCountrybyId() {
		Country country = wrepository.findById((long)1).get().getCountry();
		
		assertEquals(country.getName(), "Italy");
	}
	
	@Test
	public void findWinenamebyId() {
		Wine wine = wrepository.findById((long)1).get();
		
		assertEquals(wine.getWinename(), "Acqua in Fiamme Amarone");
	}

	@Test
	public void insertNewWine() {
		Wine wine = new Wine("Testataan viinin lisäämistä", crepository.findByName("Spain").get(0), 2021, trepository.findByName("red").get(0), 14);
		wrepository.save(wine);
		assertNotNull(wine.getId());
	}
	
	@Test
	public void DeleteWine() {
		Optional <Wine> removeWine = wrepository.findById((long)3);
		
		wrepository.deleteById(removeWine.get().getId());
		
	}

}
