package Wines.winedb.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Wines.winedb.domain.Wine;

@Entity
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long countryid;
	
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
	private List<Wine> wines;

	public Country() {
		super();
	}

	public Country(String name) {
		super();
		this.name = name;
	}

	public Long getCountryid() {
		return countryid;
	}

	public void setCountryid(Long countryid) {
		this.countryid = countryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Wine> getWines() {
		return wines;
	}

	public void setWines(List<Wine> wines) {
		this.wines = wines;
	}

	
	
	
	
}
