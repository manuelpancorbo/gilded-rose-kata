package com.milanuncios.codingdojo.gildedrose;

public class AgedBrie extends Item {
  AgedBrie(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
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
