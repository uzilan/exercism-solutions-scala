case class Clock(var hours: Int, var minutes: Int) {
  if (minutes < 0) {
    hours = hours - (60 - minutes) / 60
    minutes = 60 + minutes % 60
  } else {
    hours = (hours + (minutes / 60)) % 24
    minutes = minutes % 60
  }
  if (hours < 0) hours = 24 + hours % 24

  def +(other: Clock): Clock = Clock(this.hours + other.hours, this.minutes + other.minutes)

  def -(other: Clock): Clock = Clock(this.hours - other.hours, this.minutes - other.minutes)
}

object Clock {
  def apply(minutes: Int): Clock = Clock(0, minutes)
}