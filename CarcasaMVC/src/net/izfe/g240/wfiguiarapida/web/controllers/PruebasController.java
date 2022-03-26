package net.izfe.g240.wfiguiarapida.web.controllers;

import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/pruebas")
@Controller
public class PruebasController {
	
	@RequestMapping
	public String home(){
		return "pruebas/home";
	}

	@RequestMapping("/rest-tempalte-timeout")
	public String restTemplateTimeout(Model model){
		this.executeRest("http://desa2.sare.gipuzkoa.net/WAS/SIST/SWSPruebasWEB/jsps/inicio.jsp?retardo=900000", model);
		return "pruebas/restTemplate";
	}
	
	@RequestMapping("/rest-tempalte-externa")
	public String restTemplateExterna(Model model){
		this.executeRest("http://www.marca.com", model);
		return "pruebas/restTemplate";
	}
	
	@RequestMapping("/rest-tempalte-interna")
	public String restTemplateInterna(Model model){
		this.executeRest("http://desa2.sare.gipuzkoa.net/WAS/SIST/SWSPruebasWEB/jsps/inicio.jsp?retardo=10000", model);
		return "pruebas/restTemplate";
	}
	
	@RequestMapping("/rest-template-ssl")
	public String restTemplateSsl(Model model){
		this.executeRest("https://www9.gipuzkoa.eus/WAS/HACI/WATGipuzkoatariaWEB/inicio.do", model);
		return "pruebas/restTemplate";
	}
	
	private void executeRest(String url, Model model){
		model.addAttribute("restUrl", url);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
	    HttpEntity<String> entity = new HttpEntity<String>(headers);
	    
	    System.out.println("Ejecutando RestTemplate...");
	    
	    long initDate = new Date().getTime();
	    long endDate;
	    
	    boolean error = false;
	    ResponseEntity<String> response = null;
	    String errorMessage="";
	    try{
//	    	response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
	    	response = restTemplate.getForEntity(url, String.class);
	    }catch(ResourceAccessException e){
	    	error = true;
	    	e.printStackTrace();
	    	errorMessage=e.getMessage();
	    } finally {
	    	endDate = new Date().getTime();
	    }
	    model.addAttribute("status", (response==null) ? "NO RESPONSE" : response.getStatusCode());
	    model.addAttribute("error", error);
	    model.addAttribute("errorMessage", errorMessage);
	    
	    long tartea = endDate - initDate;
	    long segundo = tartea/1000;
	    
	    model.addAttribute("segundo", segundo);
	}
}
