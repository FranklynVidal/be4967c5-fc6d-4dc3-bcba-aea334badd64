package com.devskiller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devskiller.dao.ItemRepository;
import com.devskiller.model.Item;

@Service
public class ItemService {

	private final ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public List<String> getTitlesWithAverageRatingLowerThan(Double rating) {
		List<Item> items = itemRepository.findItemsWithAverageRatingLowerThan(rating);
		List<String> titles = new ArrayList<String>();

		if (items.size() > 0) {
			for (Item item : items) {
				titles.add(item.getTitle());
			}
		}

		return titles;
	}

}
