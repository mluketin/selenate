package net.selenate.common.comms.res;

import net.selenate.common.SelenateUtils;
import java.util.List;
import java.util.Set;
import net.selenate.common.comms.*;

public final class SeResBrowserCapture implements SeCommsRes {
  private static final long serialVersionUID = 45749879L;

  private final String                 name;
  private final long                   time;
  private final List<SeCapturedWindow> windowList;

  public SeResBrowserCapture(
      final String                 name,
      final long                   time,
      final List<SeCapturedWindow> windowList) {
    this.name       = name;
    this.time       = time;
    this.windowList = windowList;
    validate();
  }

  public String getName() {
    return name;
  }

  public long getTime() {
    return time;
  }

  public List<SeCapturedWindow> getWindowList() {
    return windowList;
  }

  public SeResBrowserCapture withName(final String newName) {
    return new SeResBrowserCapture(newName, this.time, this.windowList);
  }

  public SeResBrowserCapture withTime(final long newTime) {
    return new SeResBrowserCapture(this.name, newTime, this.windowList);
  }

  public SeResBrowserCapture withWindowList(final List<SeCapturedWindow> newWindowList) {
    return new SeResBrowserCapture(this.name, this.time, newWindowList);
  }

  private void validate() {
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be null!");
    }

    if (windowList == null) {
      throw new IllegalArgumentException("Window list cannot be null!");
    }
  }

  @Override
  public String toString() {
    return String.format("SeResCapture(%s, %d, %s)",
        name, time, SelenateUtils.listToString(windowList));
  }
}