package com.milanuncios.codingdojo.gildedrose;

public class GildedRose {
  private static final int MAX_QUALITY = 50;
  private static final int MIN_QUALITY = 0;
  private static final int MIN_SELL_IN = 0;

  Item[] items;

  GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      updateQuality(item);
      updateSellIn(item);
    }
  }

  private void updateQuality(Item item) {

    if (isSulfuras(item)) {
      return;
    }

    if (isAgedBrie(item)) {
      updateQualityForAgedBrie(item);
      return;
    }

    if (isBackstagePass(item)) {
      updateQualityForBackstage(item);
      return;
    }

    updateQualityForRegularItem(item);
  }

  private void updateQualityForBackstage(Item item) {
    increaseQuality(item);
    if (item.sellIn == MIN_SELL_IN) {
      item.quality = MIN_QUALITY;
    } else {

      if (item.sellIn < 11) {
        increaseQuality(item);
      }

      if (item.sellIn < 6) {
        increaseQuality(item);
      }
    }
    return;
  }

  private void updateQualityForAgedBrie(Item item) {
    increaseQuality(item);
    if (item.sellIn == MIN_SELL_IN) {
      increaseQuality(item);
    }
  }

  private void updateQualityForRegularItem(Item item) {
    degradeQuality(item);
    if (item.sellIn == MIN_SELL_IN) {
      degradeQuality(item);
    }
  }

  private boolean isSulfuras(Item item) {
    return item.name.equals("Sulfuras, Hand of Ragnaros");
  }

  private boolean isAgedBrie(Item item) {
    return item.name.equals("Aged Brie");
  }

  private void updateSellIn(Item item) {
    if (isNotSulfuras(item)) {
      decreaseSellIn(item);
    }
  }

  private void increaseQuality(Item item) {
    if (item.quality < MAX_QUALITY) {
      item.quality += 1;
    }
  }

  private void degradeQuality(Item item) {
    if (item.quality > MIN_QUALITY) {
      item.quality -= 1;
    }
  }

  private void decreaseSellIn(Item item) {
    if (item.sellIn > MIN_SELL_IN) {
      item.sellIn -= 1;
    }
  }

  private boolean isNotSulfuras(Item item) {
    return !isSulfuras(item);
  }

  private boolean isNotAgedBrie(Item item) {
    return !isAgedBrie(item);
  }

  private boolean isBackstagePass(Item item) {
    return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
  }
}
