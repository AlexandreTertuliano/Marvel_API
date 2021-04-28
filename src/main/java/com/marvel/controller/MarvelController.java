package com.marvel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.service.MarvelService;

@RestController
@RequestMapping(value = "/v1/public")
public class MarvelController {

	@Autowired
	private MarvelService service;

	@GetMapping("/characters")
	public ResponseEntity<String> characters() throws Exception {
		return service.getCharacters();
	}

	@GetMapping("/characters/{characterId}")
	public ResponseEntity<String> CharacterById(@PathVariable String characterId) throws Exception {
		return service.getCharacterById(characterId);
	}
	
	@GetMapping("/characters/{characterId}/comics")
	public ResponseEntity<String> comics(@PathVariable String characterId) throws Exception{
		return service.getComics(characterId);
	}
	
	@GetMapping("/characters/{characterId}/events")
	public ResponseEntity<String> events(@PathVariable String characterId) throws Exception{
		return service.getComics(characterId);
	}
	
	@GetMapping("/characters/{characterId}/series")
	public ResponseEntity<String> series(@PathVariable String characterId) throws Exception{
		return service.getComics(characterId);
	}
	
	@GetMapping("/characters/{characterId}/stories")
	public ResponseEntity<String> stories(@PathVariable String characterId) throws Exception{
		return service.getComics(characterId);
	}
}
