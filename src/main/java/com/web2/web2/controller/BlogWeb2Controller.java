package com.web2.web2.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(value="/postagens/{id}", method=RequestMethod.GET)
	public ModelAndView getPost(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("postagem");
		
		Optional<Postagens> postagem = blogWeb2Repository.findById(id);
		
		mv.addObject("titulo", postagem.get().getTitulo());
		mv.addObject("autor", postagem.get().getAutor());
		mv.addObject("data", postagem.get().getData());
		
		return mv;
			
}	
	
	@RequestMapping(value="/newpost", method=RequestMethod.GET)
	public String newPost() {
		return "formulario";
	}
	
	@RequestMapping(value="/newpost", method=RequestMethod.POST)
	public String savePost(@Valid Postagens postagem, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campus obrigatórios");
			return "redirect:/newpost";
		}
		postagem.setData(LocalDate.now());
		blogWeb2Repository.save(postagem);
		return "redirect:/postagens";
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
