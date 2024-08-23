package Com.Sojar.Hospital.Entity.Exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {
	
	
	
	@ExceptionHandler(ExceptionHandleMsgResponse.class)           // Using HttpServletRequest..interface to provide request information for HTTP servlets
	public @ResponseBody ExceptionHandleData handleExceptionData(HttpServletRequest request,ExceptionHandleMsgResponse exceptionResponse) {
																							// Is a Class	ExceptionHandle...ExceptionHandleMsgResponse
		ExceptionHandleData handleData = new ExceptionHandleData();
		
		
		handleData.setUrl(request.getRequestURI());                //Using Reference URI Set And Get
		
		handleData.setErrormsg(exceptionResponse.getMessage());     //Using Reference ErrorMsg Set And Get
	
		return handleData;
		
	}
	
	

}
