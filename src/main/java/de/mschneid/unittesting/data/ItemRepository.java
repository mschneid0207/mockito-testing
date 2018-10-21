package de.mschneid.unittesting.data;

import de.mschneid.unittesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
