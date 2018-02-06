package com.milanuncios.codingdojo.gildedrose;

public class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      if (isNotAgedBrie(item)
          && !isBackstagePass(item)) {
        if (item.quality > 0) {
          if (isNotSulfuras(item)) {
            item.quality = item.quality - 1;
          }
        }
      } else {
        if (item.quality < 50) {
          item.quality = item.quality + 1;

          if (isBackstagePass(item)) {
            if (item.sellIn < 11) {
              if (item.quality < 50) {
                item.quality = item.quality + 1;
              }
            }

            if (item.sellIn < 6) {
              if (item.quality < 50) {
                item.quality = item.quality + 1;
              }
            }
          }
        }
      }

      if (isNotSulfuras(item)) {
        item.sellIn = item.sellIn - 1;
      }

      if (item.sellIn < 0) {
        if (isNotAgedBrie(item)) {
          if (!isBackstagePass(item)) {
            if (item.quality > 0) {
              if (isNotSulfuras(item)) {
                item.quality = item.quality - 1;
              }
            }
          } else {
            item.quality = item.quality - item.quality;
          }
        } else {
          if (item.quality < 50) {
            item.quality = item.quality + 1;
          }
        }
      }
    }
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
