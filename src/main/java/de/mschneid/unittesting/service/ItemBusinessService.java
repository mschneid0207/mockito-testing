package de.mschneid.unittesting.service;

import de.mschneid.unittesting.data.ItemRepository;
import de.mschneid.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {

    @Autowired
    private ItemRepository repository;

    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }
    
    public List<Item> retrieveAllItems() {
        List<Item> items = repository.findAll();
        items.forEach(item -> item.setValue(item.getPrice() * item.getQuantity()));
        return items;
    }
}
