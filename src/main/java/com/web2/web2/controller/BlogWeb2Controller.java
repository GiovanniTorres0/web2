package com.web2.web2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web2.web2.modelo.Postagens;
import com.web2.web2.repository.BlogWeb2Repository;

@Controller
public class BlogWeb2Controller {
	@Autowired
	BlogWeb2Repository blogWeb2Repository;
	
	
	@RequestMapping(value="/postagens", method=RequestMethod.GET)
	public ModelAndView getPostagens() {
		ModelAndView mv = new ModelAndView("postagens");
		List<Postagens> postagens = blogWeb2Repository.findAll();
		
		mv.addObject("postagens", postagens);
		return mv;
	}
	
	
}
