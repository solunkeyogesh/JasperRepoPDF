package com.techniche.esankalan.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@RestController
public class FormCntrl {

	@RequestMapping(value = "/LasaDrugs", method = RequestMethod.GET)
	public void jsonJasperFunction() throws IOException {

		try {
			
			File jsonFile = new File("C:\\Users\\ADMIN\\Documents\\workspace-sts-3.9.12.RELEASE\\ESankalanJasperReports\\JSON\\LasaDrugs.json");

			HashMap<String, Object> parameters = new HashMap<String, Object>();
			
			BufferedImage image = ImageIO.read(getClass().getResource("/static/img/xyz.jpg"));
			parameters.put("logo", image );
			
			
			String reportPath = "C:\\Users\\ADMIN\\Documents\\workspace-sts-3.9.12.RELEASE\\ESankalanJasperReports\\src\\main\\resources\\templates\\jrxml\\LasaDrugs.jrxml";
			FileInputStream jasperPageinputStream = new FileInputStream(reportPath);
			JasperDesign jasperDesign = JRXmlLoader.load(jasperPageinputStream);
			FileInputStream jsonDataStream = new FileInputStream(jsonFile);
			JsonDataSource jsonDataSource = new JsonDataSource(jsonDataStream);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jsonDataSource);
			JasperExportManager.exportReportToPdfFile(jasperPrint, "LasaDrugs.pdf");
		} catch (JRException ex) {
			ex.printStackTrace();
			 
		} 

	}

	
	@RequestMapping(value = "/Memo", method = RequestMethod.GET)
	public void memo() throws IOException {

		try {
			
			File jsonFile = new File("C:\\Users\\ADMIN\\Documents\\workspace-sts-3.9.12.RELEASE\\ESankalanJasperReports\\JSON\\Memo.json");

			HashMap<String, Object> parameters = new HashMap<String, Object>();
			
			BufferedImage image = ImageIO.read(getClass().getResource("/static/img/xyz.jpg"));
			parameters.put("logo", image );
			
			
			String reportPath = "C:\\Users\\ADMIN\\Documents\\workspace-sts-3.9.12.RELEASE\\ESankalanJasperReports\\src\\main\\resources\\templates\\jrxml\\Memo.jrxml";
			FileInputStream jasperPageinputStream = new FileInputStream(reportPath);
			JasperDesign jasperDesign = JRXmlLoader.load(jasperPageinputStream);
			FileInputStream jsonDataStream = new FileInputStream(jsonFile);
			JsonDataSource jsonDataSource = new JsonDataSource(jsonDataStream);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jsonDataSource);
			JasperExportManager.exportReportToPdfFile(jasperPrint, "Memo.pdf");
		} catch (JRException ex) {
			ex.printStackTrace();
			 
		} 

	}

}
