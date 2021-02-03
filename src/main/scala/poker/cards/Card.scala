package poker.cards

case class Card(suit: Suit, rank: Rank) {
  override def toString: String = s"$suit-$rank"
}

object Card {
  def fromString(s: String): Either[String, Card] = ???
}
