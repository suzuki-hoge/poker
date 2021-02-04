package poker.cards

case class Card(suit: Suit, rank: Rank) {
  override def toString: String = s"$suit-$rank"

  def <(o: Card): Boolean = if (this.rank == o.rank) this.suit < o.suit else this.rank < o.rank
}

object Card {
  def fromString(s: String): Either[String, Card] = for {
    tup <- split(s)
    suit <- Suit.fromString(tup._1)
    rank <- Rank.fromString(tup._2)
  } yield Card(suit, rank)

  private def split(s: String): Either[String, (String, String)] = {
    val p = """([^-])-([^-]{1,2})""".r
    s match {
      case p(_r, _s) => Right((_r, _s))
      case _ => Left(s"invalid card format: $s")
    }
  }
}
