package poker.cards

case class Card(suit: Suit, rank: Rank) {
}

object Card {
  def fromString(s: String): List[Card] = ???
}
