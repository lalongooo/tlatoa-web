package com.xihuani.permutassep.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xihuani.permutassep.common.Constants;
import com.xihuani.permutassep.model.Post;
import com.xihuani.permutassep.service.IPermutasSEPService;
import com.xihuani.web.common.ControllerUtil;

@Controller
public class Permutasep {
	@Autowired
	public IPermutasSEPService ipermutasSEPService;
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public String listSentences(Map<String, Object> map) {
		map.put("post", new Post());
		map.put("postList", ipermutasSEPService.getPosts());
		map.put("post_nav_class", "active");
		return Constants.View.PERMUTASSEP_HOME_JSP;	
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String createPost(@ModelAttribute("post") Post post, BindingResult result) {
		ipermutasSEPService.newPost(post);
		return ControllerUtil.redirect(Constants.View.PERMUTASSEP_HOME);
	}
	
}
