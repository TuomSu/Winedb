package Wines.winedb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Wines.winedb.domain.Wine;
import Wines.winedb.domain.WineRepository;
import Wines.winedb.domain.Country;
import Wines.winedb.domain.CountryRepository;
import Wines.winedb.domain.Type;
import Wines.winedb.domain.TypeRepository;
import Wines.winedb.domain.AppUser;
import Wines.winedb.domain.AppUserRepository;

@SpringBootApplication
public class WinedbApplication {

	private static final Logger Log = LoggerFactory.getLogger(WinedbApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(WinedbApplication.class, args);
	}
	
	@Bean
		public CommandLineRunner demo(WineRepository wrepository, CountryRepository crepository, TypeRepository trepository, AppUserRepository urepository) {
			return (args) -> {
			Log.info("save a couple of wines");
				
			//	crepository.save(new Country("Italy"));
			//	crepository.save(new Country("Spain"));
			//	crepository.save(new Country("Chile"));
			//	crepository.save(new Country("France"));
			//	crepository.save(new Country("USA"));
				
			//	trepository.save(new Type("red"));
			//	trepository.save(new Type("white"));
			//	trepository.save(new Type("rose"));
			//	trepository.save(new Type("sparkling"));
				
			//	wrepository.save(new Wine("Acqua in Fiamme Amarone", crepository.findByName("Italy").get(0), 2021, trepository.findByName("red").get(0), 12));
			//	wrepository.save(new Wine("2u Duas Uvas Branco White", crepository.findByName("Chile").get(0), 2022, trepository.findByName("white").get(0), 9));
			//	wrepository.save(new Wine("A. Bergere Blanc de Blancs Champagne Brut", crepository.findByName("France").get(0), 2019, trepository.findByName("sparkling").get(0), 28));

			//	AppUser user1 = new AppUser("Anna","Anttonen", "USER", "user", "$2a$10$WDMEAdeX.N/M6oJnNpDyUO5szwepvUl6irlqJ/o5aRcZtth9Yfnom");
			//	AppUser user2 = new AppUser("Mikko","Mallikas", "ADMIN", "admin", "$2a$10$f84eQG3AzRK8En0VU4Pnj.FEipEc5XejV54XTesr9rCJI9IcovccC");
			//	urepository.save(user1);
			//	urepository.save(user2);
				
				Log.info("fetch all wines");
						for (Wine wine : wrepository.findAll()) {
							Log.info(wine.toString());
						}
			};
			}
	}

