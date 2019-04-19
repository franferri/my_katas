package com.gildedrose.items;

import com.gildedrose.Item;

public abstract class ItemType {

    public abstract void updateQuality(Item item);

    protected void passOneDay(Item item) {

        item.sellIn -= 1;

    }

    protected boolean isExpired(Item item) {

        return item.sellIn < 0;

    }

    protected int remainingDaysToExpire(Item item) {

        return item.sellIn;

    }

    protected void qualityChangesBy(Item item, int quality) {

        item.quality += quality;

        if (item.quality > 50) {
            item.quality = 50;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }

    }

}
