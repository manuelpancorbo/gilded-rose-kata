package com.milanuncios.codingdojo.gildedrose;

public abstract class Item {
  static final Integer MIN_SELL_IN = 0;
  private static final Integer MIN_QUALITY = 0;
  private static final Integer MAX_QUALITY = 50;

  private int sellIn;
  private int quality;
  private String name;

  Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  public void updateQuality() {
  }

  public void updateSellin() {
  }

  void degradeQuality() {
    if (quality > MIN_QUALITY) {
      quality -= 1;
    }
  }

  void increaseQuality() {
    if (quality < MAX_QUALITY) {
      quality += 1;
    }
  }

  void decreaseSellIn() {
    if (sellIn > MIN_SELL_IN) {
      sellIn -= 1;
    }
  }

  public Integer getSellIn() {
    return sellIn;
  }

  public Integer getQuality() {
    return quality;
  }

  void degradeQualityToMinimum() {
    quality = MIN_QUALITY;
  }
}
