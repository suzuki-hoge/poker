package poker.cards

case class Cards(vs: List[Card]) {
}

object Cards {
  def fromString(s: String): Either[String, Cards] = ???
}
