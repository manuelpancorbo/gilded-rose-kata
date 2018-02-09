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
    if (isNotAgedBrie(item) && isNotBackstagePass(item)) {
      if (item.quality > MIN_QUALITY && isNotSulfuras(item)) {
          degradeQuality(item);
      }
    } else {
      if (item.quality < MAX_QUALITY) {
        increaseQuality(item);

        if (isBackstagePass(item)) {
          if (item.sellIn < 11) {
            if (item.quality < MAX_QUALITY) {
              increaseQuality(item);
            }
          }

          if (item.sellIn < 6) {
            if (item.quality < MAX_QUALITY) {
              increaseQuality(item);
            }
          }
        }
      }
    }


    if (item.sellIn == MIN_SELL_IN) {
      if (isNotAgedBrie(item)) {
        if (isNotBackstagePass(item)) {
          if (item.quality > MIN_QUALITY) {
            if (isNotSulfuras(item)) {
              degradeQuality(item);
            }
          }
        } else {
          item.quality = MIN_QUALITY;
        }
      } else {
        if (item.quality < MAX_QUALITY) {
          increaseQuality(item);
        }
      }
    }
  }

  private boolean isNotBackstagePass(Item item) {
    return !isBackstagePass(item);
  }

  private void updateSellIn(Item item) {
    if (isNotSulfuras(item)) {
      decreaseSellIn(item);
    }
  }

  private void increaseQuality(Item item) {
    item.quality += 1;
  }

  private void degradeQuality(Item item) {
    item.quality -= 1;
  }

  private void decreaseSellIn(Item item) {
    item.sellIn -= 1;
  }

  private boolean isNotSulfuras(Item item) {
    return !item.name.equals("Sulfuras, Hand of Ragnaros");
  }

  private boolean isNotAgedBrie(Item item) {
    return !item.name.equals("Aged Brie");
  }

  private boolean isBackstagePass(Item item) {
    return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
  }
}
