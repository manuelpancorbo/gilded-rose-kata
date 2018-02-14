package com.milanuncios.codingdojo.gildedrose;

public class RegularItem extends Item {
  RegularItem(Integer sellIn, Integer quality) {
    super(sellIn, quality);
  }

  public void updateQuality() {
    degradeQuality();
    if (getSellIn().equals(MIN_SELL_IN)) {
      degradeQuality();
    }
  }

  public void updateSellIn() {
    decreaseSellIn();
  }
}
