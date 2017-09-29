package kh.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class GradeInputController {
	
	private static final Logger logger 
	= LoggerFactory.getLogger(GradeInputController.class);
	
		
	@RequestMapping(value="classList.do", method={RequestMethod.GET, RequestMethod.POST})
	public String classList(Model model) throws Exception{
		return "classList.tiles";
	}
}
