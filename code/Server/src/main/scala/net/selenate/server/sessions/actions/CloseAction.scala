package net.selenate
package server
package sessions
package actions

import common.comms.res._
import common.comms.req._

import org.openqa.selenium.remote.RemoteWebDriver

import scala.collection.JavaConversions._

class CloseAction(val d: RemoteWebDriver)
    extends IAction[SeReqClose, SeResClose]
    with ActionCommons {

  protected val log = Log(classOf[CloseAction])

  def act = { arg =>
    switchToWindow(arg.windowHandle)
    d.close

    new SeResClose()
  }
}
