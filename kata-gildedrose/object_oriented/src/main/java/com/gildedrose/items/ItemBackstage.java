package com.gildedrose.items;

import com.gildedrose.Item;

public class ItemBackstage extends ItemType {

    @Override
    public void updateQuality(Item item) {

        qualityChangesBy(item, +1);

        if (remainingDaysToExpire(item) <= 10) {
            qualityChangesBy(item, +1);
        }

        if (remainingDaysToExpire(item) <= 5) {
            qualityChangesBy(item, +1);
        }

        passOneDay(item);

        if (isExpired(item)) {
            item.quality = 0;
        }

    }
}
