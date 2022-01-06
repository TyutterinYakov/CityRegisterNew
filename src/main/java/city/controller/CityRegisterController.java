package city.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import city.business.CityRegisterService;
import city.view.PersonRequest;
import city.view.PersonResponse;

@Controller
public class CityRegisterController {
	@Autowired
	private CityRegisterService cityService;
	
	private static final Logger log = LoggerFactory.getLogger(CityRegisterController.class);
	
	
	@PostMapping(path="/checkCityRegister", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<PersonResponse> getCityRegisterInfo(@RequestBody List<PersonRequest> request){
		log.info("requet controller: {}", request);
		
		List<PersonResponse> response = cityService.buildResponse(request);
		return response;
	}
	
	
	
	
	
	
	
}
