package com.milanuncios.codingdojo.gildedrose;

public class Item {
  static final Integer MIN_SELL_IN = 0;
  private static final Integer MIN_QUALITY = 0;

  public int sellIn;
  public int quality;
  public String name;

  Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  public void updateQuality(){}

  public void updateSellin(){}

  void degradeQuality() {
    if (quality > MIN_QUALITY) {
      quality -= 1;
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
}
