package de.mschneid.unittesting.service;

import de.mschneid.unittesting.data.ItemRepository;
import de.mschneid.unittesting.model.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService sut;

    @Mock
    private ItemRepository repositoryMock;

    @Test
    public void retrieveAllItems() {
        Item item = Item.builder().id(1).name("Ball").price(10).quantity(20).build();
        Item item2 = Item.builder().id(2).name("Rad").price(200).quantity(2).build();

        when(repositoryMock.findAll()).thenReturn(Arrays.asList(item, item2));

        List<Item> items = sut.retrieveAllItems();
        Assert.assertEquals(200, items.get(0).getValue());
        Assert.assertEquals(400, items.get(1).getValue());

    }

}