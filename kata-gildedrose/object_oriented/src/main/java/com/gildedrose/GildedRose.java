package com.gildedrose;

import com.gildedrose.items.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            builder(item).updateQuality(item);
        }
    }

    public static <T extends ItemType> ItemType builder(Item item) {

        boolean isBackstage = item.name.equals("Backstage passes to a TAFKAL80ETC concert");
        boolean isAgedBrie = item.name.equals("Aged Brie");
        boolean isSulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");

        if (isBackstage) {
            return new ItemBackstage();
        } else if (isAgedBrie) {
            return new ItemAgedBrie();
        } else if (isSulfuras) {
            return new ItemSulfuras();
        }
        return new ItemGeneric();

    }

}