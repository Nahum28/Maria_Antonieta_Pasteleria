package com.ma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ma.services.ExcelService;

@RestController
@RequestMapping ("/excel")
public class ExcelController {

	@Autowired 
	private ExcelService excelService;
	
	@GetMapping("/leer")
	public ResponseEntity<String> añadirExcel(){
		excelService.lecturaExcel();
		return ResponseEntity.ok("lectura correcta") ;
		
	}
}
