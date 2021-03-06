package com.gildedrose.items;

import com.gildedrose.Item;

public class ItemAgedBrie extends ItemType {

	@Override
	public void updateQuality(Item item) {

		qualityChangesBy(item, +1);

		passOneDay(item);

		if (isExpired(item)) {
			qualityChangesBy(item, +1);
		}

	}

}
