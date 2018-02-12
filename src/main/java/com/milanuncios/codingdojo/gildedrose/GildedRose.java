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
      if (item instanceof RegularItem || item instanceof Sulfuras || item instanceof AgedBrie) {
        item.updateQuality();
        item.updateSellin();
      } else {
        updateQuality(item);
        updateSellIn(item);
      }
    }
  }

  private void updateQuality(Item item) {
    if (isBackstagePass(item)) {
      updateQualityForBackstage(item);
    }
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
  }

  private void updateSellIn(Item item) {
    decreaseSellIn(item);
  }

  private void increaseQuality(Item item) {
    if (item.quality < MAX_QUALITY) {
      item.quality += 1;
    }
  }

  private void decreaseSellIn(Item item) {
    if (item.sellIn > MIN_SELL_IN) {
      item.sellIn -= 1;
    }
  }

  private boolean isBackstagePass(Item item) {
    return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
  }
}
