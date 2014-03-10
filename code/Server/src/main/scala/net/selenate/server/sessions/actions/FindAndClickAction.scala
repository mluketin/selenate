package net.selenate.server
package sessions.actions

import driver.selenium.SelenateFirefox

import net.selenate.common.comms.req.SeReqFindAndClick
import net.selenate.common.comms.res.SeResFindAndClick
import org.openqa.selenium.remote.RemoteWebElement

class FindAndClickAction(val d: SelenateFirefox)(implicit context: ActionContext)
    extends IAction[SeReqFindAndClick, SeResFindAndClick]
    with ActionCommons {
  type PathElement = (FramePath, RemoteWebElement)
  protected val log = Log(classOf[FindAndClickAction])

  def act = { arg =>
    val elementList: Stream[Boolean] =
      inAllWindows { address =>
        tryb {
          findElement(arg.method, arg.query).click
        }
      }

    val isElementClicked = elementList.contains(true)
    if (isElementClicked) {
      new SeResFindAndClick()
    } else {
      throw new IllegalArgumentException("Element [%s, %s] was not found in any frame!".format(arg.method.toString, arg.query))
    }
  }
}
