package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void FruitOneDayPast() {

        Item[] items = new Item[]{
                new Item("Fruit", 5, 5)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(4, items[0].sellIn);
        assertEquals(4, items[0].quality);

    }

    @Test
    public void FruitQualityLossTwiceAsFast() {

        Item[] items = new Item[]{
                new Item("Fruit", 0, 4)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(2, items[0].quality);

    }

    @Test
    public void FruitQualityWillNeverBeNegative() {

        Item[] items = new Item[]{
                new Item("Fruit", 0, 0)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);

    }

    @Test
    public void AgedBrieQualityIncreasePerDay() {

        Item[] items = new Item[]{
                new Item("Aged Brie", 1, 49)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, items[0].sellIn);
        assertEquals(50, items[0].quality);

    }

    @Test
    public void AgedBrieQualityTopsAtFifty() {

        Item[] items = new Item[]{
                new Item("Aged Brie", 1, 50)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, items[0].sellIn);
        assertEquals(50, items[0].quality);

    }

    @Test
    public void LegendaryItem() {

        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", 1, 50)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(1, items[0].sellIn);
        assertEquals(50, items[0].quality);

    }

    @Test
    public void BackstageBeforeTenDays() {

        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 12, 5),
                new Item("Backstage passes to a TAFKAL80ETC concert", 12, 50)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(11, items[0].sellIn);
        assertEquals(6, items[0].quality);

        assertEquals(11, items[1].sellIn);
        assertEquals(50, items[1].quality);

    }

    @Test
    public void BackstageBetweenTenDaysAndSixDays() {

        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 5),
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 5)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(7, items[0].quality);

        assertEquals(5, items[1].sellIn);
        assertEquals(7, items[1].quality);

    }

    @Test
    public void BackstageBetweenFiveDaysAndZeroDays() {

        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 5)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(4, items[0].sellIn);
        assertEquals(8, items[0].quality);

        assertEquals(0, items[1].sellIn);
        assertEquals(8, items[1].quality);

    }

    @Test
    public void BackstageExpired() {

        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);

    }

    @Test
    public void ConjuredFruitOneDayPast() {

        Item[] items = new Item[]{
                new Item("Conjured Fruit", 5, 5)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(4, items[0].sellIn);
        assertEquals(3, items[0].quality);

    }

    @Test
    public void ConjuredFruitQualityLossTwiceAsFast() {

        Item[] items = new Item[]{
                new Item("Conjured Fruit", 0, 4)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);

    }


    @Test
    public void ConjuredFruitQualityWillNeverBeNegative() {

        Item[] items = new Item[]{
                new Item("Conjured Fruit", 0, 0)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);

    }

}
