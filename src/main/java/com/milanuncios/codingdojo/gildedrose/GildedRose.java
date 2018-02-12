package com.milanuncios.codingdojo.gildedrose;

import java.util.Arrays;
import java.util.List;

public class GildedRose {
  List<Item> items;

  GildedRose(Item[] items) {
    this.items = Arrays.asList(items);
  }

  public void updateQuality() {
    items.forEach(item -> {
      item.updateQuality();
      item.updateSellin();
    });
  }
}
