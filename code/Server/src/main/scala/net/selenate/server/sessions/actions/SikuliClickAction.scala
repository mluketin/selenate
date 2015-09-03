package net.selenate
package server
package sessions
package actions

import org.openqa.selenium.remote.RemoteWebDriver
import net.selenate.common.comms.req.SeReqSikuliClick
import net.selenate.common.comms.res.SeResSikuliClick
import net.selenate.server.images.SikuliDirect

class SikuliClickAction(val d: RemoteWebDriver) extends IAction[SeReqSikuliClick, SeResSikuliClick] {

  protected val log = Log(classOf[SikuliClickAction])

  def act = { arg =>
    SikuliDirect.clickImage(arg.image)
    new SeResSikuliClick()
  }
}
