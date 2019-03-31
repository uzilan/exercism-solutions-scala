import Bearing._

case class Robot(bearing: Bearing, coordinates: (Int, Int)) {

  def turnRight: Robot = {
    val newBearing = bearing match {
      case North => East
      case East => South
      case South => West
      case West => North
    }
    Robot(newBearing, coordinates)
  }

  def turnLeft: Robot = {
    val newBearing = bearing match {
      case North => West
      case East => North
      case South => East
      case West => South
    }
    Robot(newBearing, coordinates)
  }

  def advance: Robot = {
    val (x, y) = coordinates
    val newCoordinates = bearing match {
      case North => (x, y + 1)
      case East => (x + 1, y)
      case South => (x, y - 1)
      case West => (x - 1, y)
    }
    Robot(bearing, newCoordinates)
  }

  def simulate(instruction: String): Robot =
    instruction.foldLeft(this) { (acc, op) =>
      op match {
        case 'L' => acc.turnLeft
        case 'R' => acc.turnRight
        case 'A' => acc.advance
      }
    }
}

object Bearing extends Enumeration {
  type Bearing = Value

  val North: Value = Value("North")
  val East: Value = Value("East")
  val South: Value = Value("South")
  val West: Value = Value("West")
}