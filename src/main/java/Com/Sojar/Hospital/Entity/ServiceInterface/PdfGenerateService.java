package Com.Sojar.Hospital.Entity.ServiceInterface;

import java.util.Map;

public interface PdfGenerateService {
	
	
	
	
	
	void generatePdfFile(String templateName,Map<String ,Object> data, String pdfFileName);

}
