package com.davidykay.lazyfood.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

  /**
   * An array of sample (dummy) items.
   */
  public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

  /**
   * A map of sample (dummy) items, by ID.
   */
  public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

  static {
    // Add 3 sample items.
    addItem(new DummyItem("1", "Hearty American"));
    addItem(new DummyItem("3", "Italian Dining"));
    addItem(new DummyItem("5", "Chinese Pig-out Session"));
    addItem(new DummyItem("6", "Indian Remorse"));
  }

  private static void addItem(DummyItem item) {
    ITEMS.add(item);
    ITEM_MAP.put(item.id, item);
  }

  /**
   * A dummy item representing a piece of content.
   */
  public static class DummyItem {
    public String id;
    public String content;

    public DummyItem(String id, String content) {
      this.id = id;
      this.content = content;
    }

    @Override
    public String toString() {
      return content;
    }

    public int getId() {
      return Integer.parseInt(this.id);
    }
  }

  public static int getRandomId() {
    Random generator = new Random();
    Object[] values = ITEM_MAP.values().toArray();
    DummyItem randomValue = (DummyItem) values[generator.nextInt(values.length)];
    return randomValue.getId();
  }
}
