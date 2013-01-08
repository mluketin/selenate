package net.selenate.common.comms;

import java.util.ArrayList;
import java.util.List;

public class SePage extends SeComms {
  private static final long serialVersionUID = 1L;

  public final String name;
  public final List<SeElementSelector> selectorList;

  public SePage(
      final String name,
      final List<SeElementSelector> selectorList) {
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be null!");
    }
    if (selectorList == null) {
      throw new IllegalArgumentException("Selector list cannot be null!");
    }
    if (selectorList.isEmpty()) {
      throw new IllegalArgumentException("Selector list cannot be empty!");
    }

    this.name         = name;
    this.selectorList = selectorList;
  }

  public SePage(
      final String name,
      final SeElementSelector selector) {
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be null!");
    }
    if (selector == null) {
      throw new IllegalArgumentException("Selector cannot be null!");
    }

    this.name         = name;
    this.selectorList = new ArrayList<SeElementSelector>();
    this.selectorList.add(selector);
  }
}