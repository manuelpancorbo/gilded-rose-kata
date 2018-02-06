package com.milanuncios.codingdojo.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseShould {
  @Test
  public void decrease_sell_in_after_every_day() {
    Item regularItem = new Item("any name", 5, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{regularItem});

    gildedRose.updateQuality();

    assertEquals(4, gildedRose.items[0].sellIn);
  }

  @Test
  public void decrease_quality_after_every_day() {
    Item regularItem = new Item("any name", 5, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{regularItem});

    gildedRose.updateQuality();

    assertEquals(4, gildedRose.items[0].quality);
  }
}