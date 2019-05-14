import scala.util.Try

object Types {
  // Examples why types are nice
  //***************************************************************************
  def parseInt(s: String): Int = {
    try {
      parseInt("invalidString")
    } catch {
      case e: Exception => -1
    }
  }

  def parseIntTyped(s: String): Try[Int] = {
    Try { s.trim.toInt }
  }

  //***************************************************************************
  def safeHead(ss: List[String]): String = {
    ss match {
      case h :: t => h
      case Nil    => null
    }
  }

  def safeHeadTyped(ss: List[String]): Option[String] = {
    ss match {
      case h :: t => Some(h)
      case Nil    => None
    }
  }

  //***************************************************************************
  def isItWeekendYet(day: String): Boolean = {
    day match {
      case "Saturday" | "Sunday" => true
      case _                     => false
    }
  }

  def isItWeekendYetTyped(day: DayOfTheWeek): Boolean = {
    day match {
      case Saturday | Sunday => true
      case _                 => false
    }
  }
  sealed trait DayOfTheWeek
  case object Monday extends DayOfTheWeek
  case object Tuesday extends DayOfTheWeek
  case object Wednesday extends DayOfTheWeek
  case object Thursday extends DayOfTheWeek
  case object Friday extends DayOfTheWeek
  case object Saturday extends DayOfTheWeek
  case object Sunday extends DayOfTheWeek
}
