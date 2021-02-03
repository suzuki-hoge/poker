package poker.cards

case class Rank(v: Int) {
  override def toString: String = v match {
    case 14 => "A"
    case 13 => "K"
    case 12 => "Q"
    case 11 => "J"
    case _ => v.toString
  }
}
