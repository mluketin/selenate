package net.selenate.server
package driver

import actors.ActorFactory

object DriverPool {
  private def createPool(ps: ProfileSettings) = {
    val profile = ps.settings
        .map(ProfileInfo.fromString)
        .getOrElse(ProfileInfo.empty)
    val actorName = s"driver-pool_${ ps.name }"
    ActorFactory.typed[IDriverPoolActor](actorName, new DriverPoolActor(profile, ps.size))
  }

  private val poolList = C.Server.Pool.profileSettingsList map createPool

  def get(profile: ProfileInfo) = {
    poolList.find(_.signature == profile.signature) match {
      case Some(pool) =>
        pool.get
      case None =>
        FirefoxRunner.run(profile)
    }
  }
}
