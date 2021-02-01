package com.ibm.spring.PAS.controller;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.ibm.spring.PAS.dao.EmployeeRepository;
//import com.ibm.spring.PAS.entity.Employee;
//import com.ibm.spring.PAS.utils.CommonUtils;
//
//import net.sf.jasperreports.engine.JRAbstractExporter;
//import net.sf.jasperreports.engine.JRDataSource;
//import net.sf.jasperreports.engine.JREmptyDataSource;
//import net.sf.jasperreports.engine.JRExporterParameter;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.engine.export.JRPdfExporter;
//import net.sf.jasperreports.engine.export.JRXlsExporter;
//import net.sf.jasperreports.engine.util.JRLoader;
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

//@Controller
//@RequestMapping("/report")
public class JasperReportController {
//  20201231 KK 通知不用ireport了
//	Logger logger = LogManager.getLogger(getClass());
//	Properties prop = new CommonUtils().getConfig("jasper.properties");
//	
//	private EmployeeRepository employeeRepository;
//
//	@Autowired
//	public JasperReportController(EmployeeRepository theEmployeeRepository) {
//		employeeRepository = theEmployeeRepository;
//	}
//
//	@Transactional
//	public List<Employee> findAll() {
//		return employeeRepository.findAll();
//	}
//	
//	@RequestMapping("/info")
//	public ModelAndView displayInfo() {
//		logger.info("displayInfo");
//		return new ModelAndView("/jasperReport");
//	}
//	
//	@RequestMapping(value = "/export",method = RequestMethod.GET)
//	public void exportReport(@RequestParam("reportType") String reportType
//			,HttpServletResponse response) {
//		logger.info("choose reportType is: "+reportType);
//		
//		logger.info("Basic Attributes");
//		File file = null;
//		JasperReport jasperReport = null;
//		JRDataSource dataSource = null;
//		JRAbstractExporter exporter = null;
//		byte[] bytes = null;
//		String path = prop.getProperty("outputPath");
//		logger.info("path:"+path); 
//		
//		logger.info("set export path");
//		try {
//			file = new File(path);
//			jasperReport = (JasperReport) JRLoader.loadObject(file);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		logger.info("search DB");
//		List<Employee> employees = employeeRepository.findAll();
//		int size = employees.size();
//		if(size>0) {
//			dataSource = new JRBeanCollectionDataSource(employees);
//		}else {
//			dataSource = new JREmptyDataSource();
//		}
//		
//		Map parameters=new HashMap();
//		parameters.put ("parameters", "empty");
//		
//		if("PDF".equals(reportType)) {
//			exporter = new JRPdfExporter();
//		}else if ("Excel".equals(reportType)) {
//			exporter = new JRXlsExporter();
//		}
//		
//		logger.info("set OutputStream");
//		try {
//			ByteArrayOutputStream oStream = new ByteArrayOutputStream();
//			JasperPrint jasperPrint = JasperFillManager
//					.fillReport(path, parameters, dataSource);
//			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, oStream);
//			exporter.exportReport();
//			bytes = oStream.toByteArray();
//			oStream.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.err.println(e);
//		}
//		
//		logger.info("set response");
//		if("PDF".equals(reportType)) {
//        	response.setHeader("Content-Disposition","attachment; filename=JasperReportExample.pdf");
//            response.setContentType("application/pdf");
//            response.setContentLength(bytes.length);
//		}else if("Excel".equals(reportType)) {
//			response.setHeader("Content-Disposition","attachment; filename=JasperReportExample.xls");
//			response.setContentType("application/vnd.ms-excel");
//			response.setContentLength(bytes.length);
//		}
//		
//		logger.info("export report");
//		try (ServletOutputStream ouputStream = response.getOutputStream()){
//        	ouputStream.write(bytes, 0, bytes.length);
//			ouputStream.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
//		
//	}
	
}
