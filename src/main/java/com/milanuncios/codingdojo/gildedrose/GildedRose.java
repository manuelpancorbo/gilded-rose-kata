package com.milanuncios.codingdojo.gildedrose;

public class GildedRose {
  Item[] items;

  GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
        item.updateQuality();
        item.updateSellIn();
    }
  }
}
