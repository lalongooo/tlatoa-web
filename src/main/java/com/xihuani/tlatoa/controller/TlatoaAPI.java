package com.xihuani.tlatoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xihuani.tlatoa.model.Sentence;
import com.xihuani.tlatoa.service.ResourceService;

@Controller
@RequestMapping("api")
public class TlatoaAPI {
	
	@Autowired
	public ResourceService resourceService;
	
	@RequestMapping(value = "sentence", method=RequestMethod.GET)
    @ResponseBody
    public List<Sentence> searchSentence(@RequestParam(value = "phrase", required = false) String phrase) {
		return resourceService.search(phrase);
    }

}
