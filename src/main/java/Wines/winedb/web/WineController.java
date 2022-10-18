package Wines.winedb.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Wines.winedb.domain.Wine;
import Wines.winedb.domain.WineRepository;
import Wines.winedb.domain.CountryRepository;
import Wines.winedb.domain.TypeRepository;

@Controller
public class WineController {

	@Autowired
	private WineRepository wrepository;
	
	@Autowired
	private CountryRepository crepository;
	
	@Autowired
	private TypeRepository trepository;
	
	@GetMapping(value= {"/", "/winelist"})
	public String wineList(Model model) {
		model.addAttribute("wines", wrepository.findAll());
		
		return "winelist";
}
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/add")
    public String addWine(Model model){
    	model.addAttribute("wine", new Wine());
    	model.addAttribute("countries", crepository.findAll());
    	model.addAttribute("types", trepository.findAll());
        return "addwine";
    }     
    
    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public String save(@Valid Wine wine, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("countries", crepository.findAll());
	    	model.addAttribute("types", trepository.findAll());
			System.out.println("Some error happened");
			return "addwine";
		}
        wrepository.save(wine);
        return "redirect:winelist";
    }    
	
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteWine(@PathVariable("id") Long id, Model model) {
    	wrepository.deleteById(id);
        return "redirect:../winelist";
    }     
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editWine(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("wine", wrepository.findById(id));
    	model.addAttribute("countries", crepository.findAll());
    	model.addAttribute("types", trepository.findAll());
    	return "editwine";
    }	
	
	
	
}
