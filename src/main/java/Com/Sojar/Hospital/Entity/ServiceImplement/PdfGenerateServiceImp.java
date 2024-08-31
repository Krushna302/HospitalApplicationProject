package Com.Sojar.Hospital.Entity.ServiceImplement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

import Com.Sojar.Hospital.Entity.ServiceInterface.PdfGenerateService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PdfGenerateServiceImp implements PdfGenerateService {

	
	
	
	@Autowired
	private TemplateEngine templateEngine;
	
	
	@Value("${pdf.directory}")
	private String pdfdirectory;
	
	
	@Override
	public void generatePdfFile(String templateName, Map<String, Object> data, String pdfFileName) {
		
		Context context = new Context();
		
		context.setVariables(data);  //variables the variables to be set.
		
		try {
		String htmlContent = templateEngine.process(templateName, context);
		
		// logger.debug("Generated HTML content: {}", htmlContent);

		String filepath =pdfdirectory + pdfFileName ;
		
		try(FileOutputStream fileOutputStream = new FileOutputStream(filepath)){
			
			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocumentFromString(htmlContent);
			renderer.layout();
			renderer.createPDF(fileOutputStream, false);  // method os and boolean finish
			renderer.finishPDF();       // method
			
			// logger.info("PDF Generated Successfully:{}",pdffileName);
			
		}
		
		catch (DocumentException | FileNotFoundException e) {
			
			// log.error("Error During PDF Generation :{}",e.getMessage(),e);
			
			
		}

		}catch (Exception e) {
			
			log.error("Error Generated PFD File",e);
			
		}
			
			
			
		
		
	}

}
