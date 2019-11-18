package com.boot;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ShipwreckControllerTest {

  @InjectMocks
  private ShipwreckController shipwreckController;

  @Mock
  private ShipwreckRepository shipwreckRepository;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testShipwreckGet() {
    Shipwreck shipwreck = new Shipwreck();
    shipwreck.setId(1L);

    when(shipwreckRepository.findOne(1L)).thenReturn(shipwreck);

    Shipwreck wreck = shipwreckController.get(1L);
//    assertEquals(1L, wreck.getId().longValue());
    assertThat(wreck.getId(), is(1L));
  }

   @Test
  public void testShipwreckGetMany() {
    List<Shipwreck> wrecks = new ArrayList<Shipwreck>();
    Shipwreck shipwreckOne = new Shipwreck();
    shipwreckOne.setId(2L);
    Shipwreck shipwreckTwo = new Shipwreck();
    shipwreckTwo.setId(3L);
    wrecks.add(shipwreckOne);
    wrecks.add(shipwreckTwo);

    when(shipwreckRepository.findAll()).thenReturn(wrecks);

    List<Shipwreck> actual = shipwreckController.list();
    assertEquals(wrecks, actual);
    assert wrecks.size() == actual.size();
   }

}
