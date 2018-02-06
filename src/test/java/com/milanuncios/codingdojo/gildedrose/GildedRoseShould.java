package com.milanuncios.codingdojo.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseShould {
  @Test
  public void decrease_sell_in_after_every_day() {
    Item item = new Item("any name", 5, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();

    assertEquals(4, gildedRose.items[0].sellIn);
  }

  @Test
  public void degrade_quality_after_every_day() {
    Item item = new Item("any name", 5, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();

    assertEquals(4, gildedRose.items[0].quality);
  }

  @Test
  public void degrade_twice_faster_after_item_sell_in_date_has_passed() {
    Item item = new Item("Aged Brie", 5, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();

    assertEquals(6, gildedRose.items[0].quality);
  }

  @Test
  public void increase_aged_brie_quality_after_every_day() {
    Item agedBrie = new Item("Aged Brie", 5, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});

    gildedRose.updateQuality();

    assertEquals(6, gildedRose.items[0].quality);
  }
}