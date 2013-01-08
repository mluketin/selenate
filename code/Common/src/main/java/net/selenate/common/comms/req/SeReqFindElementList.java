package net.selenate.common.comms.req;

import net.selenate.common.comms.*;

public class SeReqFindElementList extends SeCommsReq {
  private static final long serialVersionUID = 1L;

  public final SeElementSelectMethod method;
  public final String         query;

  public SeReqFindElementList(
      final SeElementSelectMethod method,
      final String         query) {
    if (method == null) {
      throw new IllegalArgumentException("Method cannot be null!");
    }
    if (query == null) {
      throw new IllegalArgumentException("Query cannot be null!");
    }

    this.method    = method;
    this.query     = query;
  }

  public SeReqFindElementList(final SeElementSelector selector) {
    if (selector == null) {
      throw new IllegalArgumentException("Selector cannot be null!");
    }

    this.method    = selector.method;
    this.query     = selector.query;
  }
}