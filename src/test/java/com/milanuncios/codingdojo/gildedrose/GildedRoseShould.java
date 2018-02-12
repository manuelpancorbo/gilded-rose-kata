package com.milanuncios.codingdojo.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseShould {
  @Test
  public void decrease_sell_in_after_every_day() {
    Item item = new RegularItem(5, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();

    assertEquals(Integer.valueOf(4), gildedRose.items[0].getSellIn());
  }

  @Test
  public void degrade_quality_after_every_day() {
    Item item = new RegularItem(5, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();

    assertEquals(Integer.valueOf(4), gildedRose.items[0].getQuality());
  }

  @Test
  public void degrade_twice_faster_after_item_sell_in_date_has_passed() {
    Item item = new RegularItem(0, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();

    assertEquals(Integer.valueOf(3), gildedRose.items[0].getQuality());
  }

  @Test
  public void increase_aged_brie_quality_after_every_day() {
    Item agedBrie = new AgedBrie(5, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});

    gildedRose.updateQuality();

    assertEquals(Integer.valueOf(6), gildedRose.items[0].getQuality());
  }

  @Test
  public void not_increase_an_item_quality_over_50() {
    Item agedBrie = new AgedBrie(5, 50);
    GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});

    gildedRose.updateQuality();

    assertEquals(Integer.valueOf(50), gildedRose.items[0].getQuality());
  }

  @Test
  public void not_decrease_sell_in_of_sulfuras() {
    Item sulfuras = new Sulfuras(5, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});

    gildedRose.updateQuality();

    assertEquals(Integer.valueOf(5), gildedRose.items[0].getSellIn());
  }

  @Test
  public void not_degrade_quality_of_sulfuras() {
    Item sulfuras = new Sulfuras(5, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});

    gildedRose.updateQuality();

    assertEquals(Integer.valueOf(5), gildedRose.items[0].getQuality());
  }

  @Test
  public void increase_quality_of_backstage_when_sell_in_date_is_greater_than_10() {
    Item backstagePasses = new BackstagePasses(11, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});

    gildedRose.updateQuality();

    assertEquals(Integer.valueOf(6), gildedRose.items[0].getQuality());
  }

  @Test
  public void increase_quality_of_backstage_twice_faster_when_sell_in_date_is_less_than_or_equal_to_10() {
    Item backstagePasses = new BackstagePasses(10, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});

    gildedRose.updateQuality();

    assertEquals(Integer.valueOf(7), gildedRose.items[0].getQuality());
  }

  @Test
  public void increase_quality_of_backstage_three_times_faster_when_sell_in_date_is_less_than_or_equal_to_5() {
    Item backstagePasses = new BackstagePasses(5, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});

    gildedRose.updateQuality();

    assertEquals(Integer.valueOf(8), gildedRose.items[0].getQuality());
  }

  @Test
  public void degrade_quality_to_0_of_backstage_pass_after_the_concert() {
    Item backstagePasses = new BackstagePasses(0, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});

    gildedRose.updateQuality();

    assertEquals(Integer.valueOf(0), gildedRose.items[0].getQuality());
  }
}