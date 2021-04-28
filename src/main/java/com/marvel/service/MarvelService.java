package com.marvel.service;

import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MarvelService {

	private String baseUrl = "https://gateway.marvel.com:443/v1/public/";

	private RestTemplate restTemplate;

	public MarvelService() {
		restTemplate = new RestTemplate();
	}

	public ResponseEntity<String> getCharacters() throws Exception {
		return restTemplate.getForEntity(baseUrl + "characters?" + getParams(), String.class);
	}

	public ResponseEntity<String> getCharacterById(String characterId) throws Exception {
		return restTemplate.getForEntity(baseUrl + "characters/" + characterId + "?" + getParams(), String.class);
	}
	
	public ResponseEntity<String> getComics(String characterId) throws Exception {
		return restTemplate.getForEntity(baseUrl + "characters/" + characterId + "/comics"+ "?" + getParams(), String.class);
	}
	
	public ResponseEntity<String> getEvents(String characterId) throws Exception {
		return restTemplate.getForEntity(baseUrl + "characters/" + characterId + "/events"+ "?" + getParams(), String.class);
	}

	public ResponseEntity<String> getSeries(String characterId) throws Exception {
		return restTemplate.getForEntity(baseUrl + "characters/" + characterId + "/series"+ "?" + getParams(), String.class);
	}
	
	public ResponseEntity<String> getStories(String characterId) throws Exception {
		return restTemplate.getForEntity(baseUrl + "characters/" + characterId + "/stories"+ "?" + getParams(), String.class);
	}
	
	private String getParams() throws Exception {
		var publicKey = "7dd3522c1d3e2275407a09645e75b900";
		var privateKey = "e987654ab1e8bcc19e81ea152a935901f25e327b";
		var ts = String.valueOf(System.currentTimeMillis());

		var params = "apikey=" + publicKey;
		params += "&";
		params += "hash=" + getHash(ts, privateKey, publicKey);
		params += "&";
		params += "ts=" + ts;
		return params;
	}

	private String getHash(String ts, String privateKey, String publicKey) throws Exception {
		var md = MessageDigest.getInstance("MD5");
		byte[] digest = md.digest((ts + privateKey + publicKey).getBytes("UTF-8"));
		return DatatypeConverter.printHexBinary(digest).toLowerCase();

	}

}
