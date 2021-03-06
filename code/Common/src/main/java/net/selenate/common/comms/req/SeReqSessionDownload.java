package net.selenate.common.comms.req;

import java.net.URL;
import net.selenate.common.exceptions.SeInvalidArgumentException;
import net.selenate.common.exceptions.SeNullArgumentException;

public final class SeReqSessionDownload implements SeCommsReq {
  private static final long serialVersionUID = 45749879L;

  private final String url;

  public SeReqSessionDownload(final String url) {
    this.url = url;
    validate();
  }

  public String getUrl() {
    return url;
  }

  public SeReqSessionDownload withUrl(final String newUrl) {
    return new SeReqSessionDownload(newUrl);
  }

  private void validate() {
    if (url == null) {
      throw new SeNullArgumentException("Url");
    }

    try {
      new URL(url);
    } catch (final Exception e) {
      throw new SeInvalidArgumentException("An error occured while interpreting url as java.net.URL!", e);
    }
  }

  @Override
  public String toString() {
    return String.format("SeReqSessionDownload(%s)", url);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((url == null) ? 0 : url.hashCode());
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
    SeReqSessionDownload other = (SeReqSessionDownload) obj;
    if (url == null) {
      if (other.url != null)
        return false;
    } else if (!url.equals(other.url))
      return false;
    return true;
  }
}
