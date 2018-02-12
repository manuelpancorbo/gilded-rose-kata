package com.milanuncios.codingdojo.gildedrose;

public class RegularItem extends Item {
  RegularItem(String name, Integer sellIn, Integer quality) {
    super(name, sellIn, quality);
  }

  public void updateQuality() {
    degradeQuality();
    if (getSellIn().equals(MIN_SELL_IN)) {
      degradeQuality();
    }
  }

  public void updateSellin() {
    decreaseSellIn();
  }
}