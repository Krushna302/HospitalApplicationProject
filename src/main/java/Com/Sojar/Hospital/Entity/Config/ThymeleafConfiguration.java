package Com.Sojar.Hospital.Entity.Config;

import org.hibernate.sql.Template;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class ThymeleafConfiguration {
	
	
	 @Bean
	    public ClassLoaderTemplateResolver emailTemplateResolver() {
	        ClassLoaderTemplateResolver pdfTemplateResolver = new ClassLoaderTemplateResolver();
	        pdfTemplateResolver.setPrefix("templates/");
	        pdfTemplateResolver.setSuffix(".html");
	        pdfTemplateResolver.setTemplateMode("HTML5");
	        pdfTemplateResolver.setCharacterEncoding("UTF-8");
	        pdfTemplateResolver.setOrder(1);
	        return pdfTemplateResolver;
	    }

	 
	
	
	
	

}
