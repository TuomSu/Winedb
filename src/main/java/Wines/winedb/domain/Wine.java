package Wines.winedb.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Wine {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 1, message = "min size is 1")
	private String winename;
	
	@ManyToOne
	@JoinColumn(name = "countryid")
	private Country country;
	
	@Min(value = 1900, message = "min value is 1900")
	@Max(value = 2022, message = "max value is 2022")
	private int wineyear;
	
	@ManyToOne
	@JoinColumn(name = "typeid")
	private Type type;
	
	@Min(value = 1, message = "min value is 1")
	private double price;

	public Wine() {
		super();
	}

	public Wine(String winename, Country country, int wineyear, Type type, double price) {
		super();
		this.winename = winename;
		this.country = country;
		this.wineyear = wineyear;
		this.type = type;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWinename() {
		return winename;
	}

	public void setWinename(String winename) {
		this.winename = winename;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public int getWineyear() {
		return wineyear;
	}

	public void setWineyear(int wineyear) {
		this.wineyear = wineyear;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Wine [id=" + id + ", winename=" + winename + ", wineyear=" + wineyear + ", price=" + price
				+ "]";
	}
	
	
	
}
