package com.milanuncios.codingdojo.gildedrose;

public class AgedBrie extends Item {
  AgedBrie(int sellIn, int quality) {
    super(sellIn, quality);
  }

  @Override
  public void updateQuality() {
    increaseQuality();
    if (getSellIn().equals(MIN_SELL_IN)) {
      increaseQuality();
    }
  }

  @Override
  public void updateSellin() {
    decreaseSellIn();
  }
}
