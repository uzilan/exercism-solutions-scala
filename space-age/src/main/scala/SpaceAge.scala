import SpaceAge.secondsInEarthYear

object SpaceAge {
  val earthOrbitalPeriod: Double = 365.25
  val secondsInEarthYear: Double = 60 * 60 * 24 * earthOrbitalPeriod

  def onEarth(ageInSeconds: Double): Double = Earth.spaceAge(ageInSeconds)

  def onMercury(ageInSeconds: Double): Double = Mercury.spaceAge(ageInSeconds)

  def onVenus(ageInSeconds: Double): Double = Venus.spaceAge(ageInSeconds)

  def onMars(ageInSeconds: Double): Double = Mars.spaceAge(ageInSeconds)

  def onJupiter(ageInSeconds: Double): Double = Jupiter.spaceAge(ageInSeconds)

  def onSaturn(ageInSeconds: Double): Double = Saturn.spaceAge(ageInSeconds)

  def onUranus(ageInSeconds: Double): Double = Uranus.spaceAge(ageInSeconds)

  def onNeptune(ageInSeconds: Double): Double = Neptune.spaceAge(ageInSeconds)

}

sealed abstract class Planet(val orbitalPeriod: Double) {
  def spaceAge(ageInSeconds: Double): Double = ageInSeconds / (orbitalPeriod * secondsInEarthYear)
}

case object Earth extends Planet(1)

case object Mercury extends Planet(0.2408467)

case object Venus extends Planet(0.61519726)

case object Mars extends Planet(1.8808158)

case object Jupiter extends Planet(11.862615)

case object Saturn extends Planet(29.447498)

case object Uranus extends Planet(84.016846)

case object Neptune extends Planet(164.79132)