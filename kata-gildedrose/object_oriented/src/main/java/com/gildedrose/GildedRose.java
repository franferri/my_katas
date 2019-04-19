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

        boolean isSulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");
        boolean isBackstage = item.name.endsWith("Backstage passes to a TAFKAL80ETC concert");
        boolean isAgedBrie = item.name.endsWith("Aged Brie");
        boolean isConjured = item.name.startsWith("Conjured");

        if (isBackstage) {
            return new ItemBackstage();
        } else if (isAgedBrie) {
            return new ItemAgedBrie();
        } else if (isSulfuras) {
            return new ItemSulfuras();
        } else if (isConjured) {
            return new ItemConjuredGeneric();
        }
        return new ItemGeneric();

    }

}