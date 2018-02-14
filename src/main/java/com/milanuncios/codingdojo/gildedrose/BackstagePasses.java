package com.milanuncios.codingdojo.gildedrose;

public class BackstagePasses extends Item {
  BackstagePasses(int sellIn, int quality) {
    super(sellIn, quality);
  }

  @Override
  public void updateQuality() {
    if (getSellIn().equals(MIN_SELL_IN)) {
      degradeQualityToMinimum();
      return;
    }

    increaseQuality();

    if (shouldIncreaseQualityTwice()) {
      increaseQuality();
    }

    if (shouldIncreaseQualityThreeTimes()) {
      increaseQuality();
    }
  }

  private boolean shouldIncreaseQualityThreeTimes() {
    return getSellIn() <= 5;
  }

  private boolean shouldIncreaseQualityTwice() {
    return getSellIn() <= 10;
  }

  @Override
  public void updateSellIn() {
    decreaseSellIn();
  }
}
