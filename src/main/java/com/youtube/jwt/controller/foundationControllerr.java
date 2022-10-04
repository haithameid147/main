package com.youtube.jwt.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtube.jwt.entity.City;
import com.youtube.jwt.entity.Foundation;
import com.youtube.jwt.entity.Service;
import com.youtube.jwt.service.serviceOfService;
@CrossOrigin(origins = "http://10.101.0.80:4200")
//@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class foundationControllerr {
//
//	@Autowired
//	com.youtube.jwt.service.foundationService foindationService;
//	@Autowired
//	serviceOfService service;
//
//	@Autowired
//	com.youtube.jwt.service.cityService cityService;
//
//	@GetMapping("/foundation")
//	public List<Foundation> getAllFoundation() {
//		return foindationService.all();
//	}
//
//	@GetMapping("/employees/{servicesId},{city}/foundation")
//	public List<Foundation> getAllfoundationByserviceID(@PathVariable int servicesId,@PathVariable String city) {
//		System.out.println(city) ;
//		return foindationService.getFoundationOfServiceId(servicesId);
//	}
//	
//	
//	@GetMapping("/getAllfoundationBySerch/{servicesId},{cityId}/foundation")
//	public List<Foundation> getAllfoundationBySerch(@PathVariable int servicesId,@PathVariable int cityId) {
//		System.out.println(cityId) ;
//		System.out.println(servicesId) ;
//		return foindationService.getAllfoundationBySearch(servicesId,cityId);
//	}
//
//	@GetMapping("/city/{cityId}/foundation")
//	public List<Foundation> getAllfoundationByCityID(@PathVariable int cityId) {
//		return foindationService.getFoundationOfCityId(cityId);
//	}
//
//	@GetMapping("/apppUserr/{appUserId}/foundation")
//	public List<Foundation> getAllfoundationByAppUserID(@PathVariable String appUserId) {
//		return foindationService.getFoundationOfAppUserName(appUserId);
//	}
//	@GetMapping("/getAllfoundationNameContaining/{name}")
//	public List<Foundation> getAllfoundationNameContaining(@PathVariable String name) {
//		System.out.print("first"+name);
//		return foindationService.getFoundationByNameContaining(name);
//	}
//
//	@GetMapping("/foundation/{idd}")
//	public Foundation findFoundationById(@PathVariable int idd) {
//		return foindationService.findFoundationById(idd);
//	}
//
//	@GetMapping("/foundationCityID/{idd}")
//	public int findsCityIdByFoundationById(@PathVariable int idd) {
//
//		return foindationService.findCityIdByFoundationById(idd);
//	}
//
//	@GetMapping("/foundationServiceID/{idd}")
//	public int findserviceIdByFoundationById(@PathVariable int idd) {
//
//		return foindationService.findserviceIdByFoundationById(idd);
//	}
//
//	@PreAuthorize("hasRole('User')")
//	@PostMapping("/addfoundation")
//	public void addfoundation(@RequestBody Foundation newArea) {
//		foindationService.addFoundation(newArea);
//		// return "area saved";
//	}
//
//	@PreAuthorize("hasRole('User')")
//	@PostMapping("/addfoundation1")
//	public void addfoundation1(@RequestParam("file") MultipartFile file,
//			@RequestParam("foundatiion") String foundatiion) throws IOException {
//		try {
//			Foundation founatioon = new ObjectMapper().readValue(foundatiion, Foundation.class);
//		} catch (IOException e) {
//			System.out.println("haitham");
//
//		}
//
//		Foundation founation = new ObjectMapper().readValue(foundatiion, Foundation.class);
//
//		founation.setLogo(file.getBytes());
//		founation.setFilenameDB(file.getOriginalFilename());
//		foindationService.addFoundation(founation);
//		// return "area saved";.
//	}
//
//	@PutMapping("/addFoundation2/{id}")
//	public String ubdatefoundation(@PathVariable int id, @RequestParam("foundatiion") String foundatiion)
//			throws JsonMappingException, JsonProcessingException {
//		System.out.println("foundation 2");
//		Foundation founation = new ObjectMapper().readValue(foundatiion, Foundation.class);
//		System.out.println(founation.getService().getId());
//		// System.out.println(new Gson().toJson(founation));
//		// System.out.println("newFoundation");
//		int idd = founation.getService().getId();
//		Service servicee = service.findById(idd);
//		founation.setService(servicee);
//
//		int cityId = founation.getCity().getId();
//		City city = cityService.findById(cityId);
//		founation.setCity(city);
//		foindationService.addFoundation(founation);
//		return "area ubdate";
//	}
//
//	@PutMapping("/addFoundation/{id}")
//	public String ubdatefoundation1(@RequestParam("file") MultipartFile file, @PathVariable int id,
//			@RequestParam("foundatiion") String foundatiion) throws IOException {
//		System.out.println("foundation 11");
//		Foundation founation = new ObjectMapper().readValue(foundatiion, Foundation.class);
//
//		System.out.print(founation.getService().getId());
//		// System.out.println(new Gson().toJson(founation));
//
//		if (file != null && !file.isEmpty()) {
//			founation.setLogo(file.getBytes());
//			founation.setFilenameDB(file.getOriginalFilename());
//
//		}
//		int idd = founation.getService().getId();
//		Service servicee = service.findById(idd);
//		founation.setService(servicee);
//
//		int cityId = founation.getCity().getId();
//		City city = cityService.findById(cityId);
//		founation.setCity(city);
//
//		foindationService.addFoundation(founation);
//
//		return "area ubdate";
//	}
//
//	@DeleteMapping("/deleteFoundation/{id}")
//	public String deleteArea(@PathVariable int id) {
//		foindationService.deleteFoundation(id);
//		return "city deleted";
//
//	}

}
