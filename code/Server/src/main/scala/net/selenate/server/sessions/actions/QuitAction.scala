package net.selenate.server
package sessions.actions

import extensions.SelenateFirefox

import net.selenate.common.comms.req.SeReqQuit
import net.selenate.common.comms.res.SeResQuit

class QuitAction(val d: SelenateFirefox)
    extends Action[SeReqQuit, SeResQuit]
    with ActionCommons {
  def act = { arg =>
    d.quit
    new SeResQuit()
  }
}
