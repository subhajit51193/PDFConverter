package com.pdf.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import com.pdf.model.Item;


@Service
public class DataMapper {

public Context setData(List<Item> itemList) {
		
		Context context = new Context();
		
		Map<String, Object> data = new HashMap<>();
		
		data.put("items", itemList);
		
		context.setVariables(data);
		
		return context;
	}
}
