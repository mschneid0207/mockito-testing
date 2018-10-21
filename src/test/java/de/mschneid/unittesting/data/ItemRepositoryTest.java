package de.mschneid.unittesting.data;

import de.mschneid.unittesting.model.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository sut;

    @Test
    public void testFindAll() {

        List<Item> items = sut.findAll();
        assertEquals(3, items.size());
    }
}
