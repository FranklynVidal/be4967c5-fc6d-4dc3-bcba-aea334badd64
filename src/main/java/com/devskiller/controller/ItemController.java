package com.devskiller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devskiller.service.ItemService;

@RestController
public class ItemController {

	private final ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

//	@Autowired
//	ItemService itemService;

	@GetMapping(path = "/titles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	List<String> getTitles(@RequestParam Double rating) {
		return itemService.getTitlesWithAverageRatingLowerThan(rating);
	}

}
