package Wines.winedb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import Wines.winedb.web.WineController;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class WinedbApplicationTests {
	
	@Autowired
	WineController wineController;

	@Test
	void contextLoads() throws Exception {
		assertThat(wineController).isNotNull();
	} {
	}

}
