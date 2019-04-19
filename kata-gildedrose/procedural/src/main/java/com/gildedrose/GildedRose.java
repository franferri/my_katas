package com.gildedrose;

import java.util.Arrays;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        Arrays.stream(items)
                .filter(x -> !x.name.equals("Sulfuras, Hand of Ragnaros"))
                .forEach(item -> {

                    boolean isBackstage = item.name.endsWith("Backstage passes to a TAFKAL80ETC concert");
                    boolean isAgedBrie = item.name.endsWith("Aged Brie");
                    boolean isConjured = item.name.startsWith("Conjured");
                    boolean isGeneric = !isBackstage && !isAgedBrie && !isConjured;

                    if (isAgedBrie) {

                        qualityChangesBy(item, +1);

                        passOneDay(item);

                        if (isExpired(item)) qualityChangesBy(item, +1);

                    }

                    if (isBackstage) {

                        qualityChangesBy(item, +1);

                        if (remainingDaysToExpire(item) <= 10) qualityChangesBy(item, +1);
                        if (remainingDaysToExpire(item) <= 5) qualityChangesBy(item, +1);

                        passOneDay(item);

                        if (isExpired(item)) item.quality = 0;

                    }

                    if (isGeneric) {

                        qualityChangesBy(item, -1);

                        passOneDay(item);

                        if (isExpired(item)) qualityChangesBy(item, -1);

                    }

                    if (isConjured) {

                        qualityChangesBy(item, -2);

                        passOneDay(item);

                        if (isExpired(item)) qualityChangesBy(item, -2);

                    }

                });
    }

    private void passOneDay(Item item) {

        item.sellIn -= 1;

    }

    private boolean isExpired(Item item) {

        return item.sellIn < 0;

    }

    private int remainingDaysToExpire(Item item) {

        return item.sellIn;

    }

    private void qualityChangesBy(Item item, int quality) {

        item.quality += quality;

        if (item.quality > 50) {
            item.quality = 50;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }

    }

}