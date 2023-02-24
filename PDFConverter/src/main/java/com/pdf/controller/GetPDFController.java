package com.pdf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;


import com.pdf.model.Item;
import com.pdf.service.DataMapper;
import com.pdf.service.DocumentGenerator;



@RestController
public class GetPDFController {
	
	@Autowired
	private DocumentGenerator documentGenerator;
	
	@Autowired
	private SpringTemplateEngine springTemplateEngine;
	
	@Autowired
	private DataMapper dataMapper;

	@PostMapping("/generate/doc")
	public String getPdf(@RequestBody List<Item> itemList) {
		
		String finalHtml = null;
		Context context = dataMapper.setData(itemList);
		finalHtml = springTemplateEngine.process("template", context);
		documentGenerator.htmlToPdf(finalHtml);
		return "successfull";
	}
	
	
} 