package com.itau.twitter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.twitter.service.TwitterService;

@RestController
@RequestMapping("/v1")
public class TwitterController {

	@Autowired
	private TwitterService twitterService;
	
	@GetMapping(path = {"/{hastag}"})
	public ResponseEntity <?> listar(@PathVariable String hastag) {
		try {
			HttpEntity<String> response = twitterService.searchByHastag(hastag);
			return ResponseEntity.ok().body(response.getBody());
		} catch (Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
}
