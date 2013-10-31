package com.xihuani.tlatoa.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xihuani.tlatoa.common.Constants;
import com.xihuani.tlatoa.model.Resource;
import com.xihuani.tlatoa.model.Sentence;
import com.xihuani.tlatoa.service.ResourceService;
import com.xihuani.web.common.ControllerUtil;

@Controller
public class Tlatoa {
	@Autowired
	public ResourceService resourceService;
	
	@RequestMapping(value = "/sentence", method = RequestMethod.GET)
	public String listSentences(Map<String, Object> map) {
		map.put("sentence", new Sentence());
		map.put("sentenceList", resourceService.listSentences());
		map.put("sentence_nav_class", "active");
		return Constants.View.TLATOA_HOME_JSP;	
	}
	
	@RequestMapping(value = "/sentence", method = RequestMethod.POST)
	public String createSentence(@ModelAttribute("sentence") Sentence sentence, BindingResult result) {
		resourceService.addSentence(sentence);
		return ControllerUtil.redirect(Constants.View.TLATOA_HOME);
	}
	
	@RequestMapping(value = "/sentence/{sentenceId}/resource", method = RequestMethod.GET)
	public String listResources(@PathVariable("sentenceId") Integer sentenceId, Map<String, Object> map) {
		map.put("sentenceId", sentenceId);
		map.put("resource", new Resource());
		map.put("resourceList", resourceService.listResource(sentenceId));
		map.put("resource_nav_class", "active");
		return Constants.View.TLATOA_HOME_JSP;
	}
	
	@RequestMapping(value = "/sentence/{sentenceId}/resource", method = RequestMethod.POST)
	public String addResources(@PathVariable("sentenceId")Integer sentenceId, @ModelAttribute("resource") Resource resource) {
		resourceService.addResource(sentenceId, resource);
		return ControllerUtil.redirect(Constants.View.TLATOA_HOME, sentenceId, Constants.View.TLATOA_RESOURCE);
	}
	
	@RequestMapping(value = "/sentence/{sentenceId}/resource/{resourceId}/delete", method = RequestMethod.GET)
	public String addResources(@PathVariable("sentenceId")Integer sentenceId, @PathVariable("resourceId")Integer resourceId) {
		resourceService.removeResource(sentenceId, resourceId);
		return ControllerUtil.redirect(Constants.View.TLATOA_HOME, sentenceId, Constants.View.TLATOA_RESOURCE);
	}
	
	@RequestMapping(value = "/sentence/{sentenceId}/sort_resource", method = RequestMethod.POST)
	public String sortRerources(@PathVariable("sentenceId") Integer sentenceId, @RequestParam(value = "resourceId", required = true)Integer[] resourceId) {
		resourceService.sortResource(sentenceId, resourceId);
		return ControllerUtil.redirect(Constants.View.TLATOA_HOME, sentenceId, Constants.View.TLATOA_RESOURCE);
	}
	
}
