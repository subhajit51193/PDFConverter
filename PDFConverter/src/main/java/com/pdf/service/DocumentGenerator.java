package com.pdf.service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import com.itextpdf.*;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.pdf.PdfWriter;

import org.springframework.stereotype.Service;

@Service
public class DocumentGenerator {

	public String htmlToPdf(String processedHtml) {
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		try {
			
			PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
			DefaultFontProvider defaultFont = new DefaultFontProvider(false,true,false);
			ConverterProperties converterProperties = new ConverterProperties();
			converterProperties.setFontProvider(defaultFont);
			
			HtmlConverter.convertToPdf(processedHtml, pdfWriter, converterProperties);
			
			FileOutputStream fout = new FileOutputStream("/Users/ACER/Desktop/PDF/details.pdf");
			
			byteArrayOutputStream.writeTo(fout);
			byteArrayOutputStream.close();
			
			byteArrayOutputStream.flush();
			fout.close();
			
			return null;
			
		} catch(Exception ex) {
			
			//exception occured
		}
		
		return null;
	}
}