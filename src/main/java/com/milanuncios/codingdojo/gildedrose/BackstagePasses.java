package com.milanuncios.codingdojo.gildedrose;

public class BackstagePasses extends Item {
  BackstagePasses(int sellIn, int quality) {
    super(sellIn, quality);
  }

  @Override
  public void updateQuality() {
    increaseQuality();
    if (getSellIn().equals(MIN_SELL_IN)) {
      degradeQualityToMinimum();
      return;
    }

    if (getSellIn() < 11) {
      increaseQuality();
    }

    if (getSellIn() < 6) {
      increaseQuality();
    }
  }

  @Override
  public void updateSellin() {
    decreaseSellIn();
  }
}
