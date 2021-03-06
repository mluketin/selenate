package net.selenate.common.comms.req;

import net.selenate.common.comms.SeElementSelector;
import net.selenate.common.exceptions.SeNullArgumentException;

public final class SeReqSelectFindOptionList implements SeCommsReq {
  private static final long serialVersionUID = 45749879L;

  private final SeElementSelector selector;

  public SeReqSelectFindOptionList(final SeElementSelector selector) {
    this.selector = selector;
    validate();
  }

  public SeElementSelector getSelector() {
    return selector;
  }

  public SeReqSelectFindOptionList withSelector(final SeElementSelector newSelector) {
    return new SeReqSelectFindOptionList(newSelector);
  }

  private void validate() {
    if (selector == null) {
      throw new SeNullArgumentException("Selector");
    }
  }

  @Override
  public String toString() {
    return String.format("SeReqSelectFindOptionList(%s)", selector);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((selector == null) ? 0 : selector.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SeReqSelectFindOptionList other = (SeReqSelectFindOptionList) obj;
    if (selector == null) {
      if (other.selector != null)
        return false;
    } else if (!selector.equals(other.selector))
      return false;
    return true;
  }
}
