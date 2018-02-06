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
    Item item = new Item("any name", 0, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();

    assertEquals(3, gildedRose.items[0].quality);
  }

  @Test
  public void increase_aged_brie_quality_after_every_day() {
    Item agedBrie = new Item("Aged Brie", 5, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});

    gildedRose.updateQuality();

    assertEquals(6, gildedRose.items[0].quality);
  }

  @Test
  public void not_increase_an_item_quality_over_50() {
    Item agedBrie = new Item("Aged Brie", 5, 50);
    GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});

    gildedRose.updateQuality();

    assertEquals(50, gildedRose.items[0].quality);
  }

  @Test
  public void not_decrease_sell_in_of_sulfuras() {
    Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 5, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});

    gildedRose.updateQuality();

    assertEquals(5, gildedRose.items[0].sellIn);
  }

  @Test
  public void not_degrade_quality_of_sulfuras() {
    Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 5, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});

    gildedRose.updateQuality();

    assertEquals(5, gildedRose.items[0].quality);
  }

  @Test
  public void increase_quality_of_backstage_when_sell_in_date_is_greater_than_10() {
    Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});

    gildedRose.updateQuality();

    assertEquals(6, gildedRose.items[0].quality);
  }

  @Test
  public void increase_quality_of_backstage_twice_faster_when_sell_in_date_is_less_than_or_equal_to_10() {
    Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});

    gildedRose.updateQuality();

    assertEquals(7, gildedRose.items[0].quality);
  }

  @Test
  public void increase_quality_of_backstage_three_times_faster_when_sell_in_date_is_less_than_or_equal_to_5() {
    Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});

    gildedRose.updateQuality();

    assertEquals(8, gildedRose.items[0].quality);
  }

  @Test
  public void degrade_quality_to_0_of_backstage_pass_after_the_concert() {
    Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});

    gildedRose.updateQuality();

    assertEquals(0, gildedRose.items[0].quality);
  }
}