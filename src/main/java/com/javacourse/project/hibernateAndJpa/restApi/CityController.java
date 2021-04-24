package com.javacourse.project.hibernateAndJpa.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacourse.project.hibernateAndJpa.Business.ICitySerivce;
import com.javacourse.project.hibernateAndJpa.Entities.City;

@RestController // Annotation for it is a rest controller
@RequestMapping("/api") // Standard for API : in this class all of the operations starts with api
public class CityController {
	private ICitySerivce cityService;

	@Autowired // Finds the class that implements city service
	public CityController(ICitySerivce cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/cities")
	public List<City> get(){
		return cityService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody City city){	// @RequestBody : Annotation for to get the parameter from the request body
		cityService.add(city);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody City city){
		cityService.update(city);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody City city){
		cityService.delete(city);
	}
	
	@GetMapping("/cities/{id}")
	public City getById(@PathVariable int id){ 	// @PathVariable : Annotation for to get parameter from the URL/path. The key of the URL parameter must match with the operation's parameter name.
		return cityService.getById(id);
	}
}
