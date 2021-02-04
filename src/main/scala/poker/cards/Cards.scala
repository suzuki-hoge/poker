package poker.cards

case class Cards(vs: List[Card]) {
}

object Cards {
  def fromString(s: String): Either[String, Cards] = for {
    tup <- split(s)
    c1 <- Card.fromString(tup._1)
    c2 <- Card.fromString(tup._2)
    c3 <- Card.fromString(tup._3)
    c4 <- Card.fromString(tup._4)
    c5 <- Card.fromString(tup._5)
    cards = List(c1, c2, c3, c4, c5)
    _ <- duplicateCheck(cards)
  } yield Cards(cards.sortWith((x, y) => x < y))

  type ErrorMessage = String
  type CardCandidates = (String, String, String, String, String)

  private def split(s: String): Either[ErrorMessage, CardCandidates] = {
    val p = """([^ ]+) ([^ ]+) ([^ ]+) ([^ ]+) ([^ ]+)""".r

    s match {
      case p(cc1, cc2, cc3, cc4, cc5) => Right((cc1, cc2, cc3, cc4, cc5))
      case _ => Left(s"invalid cards format: $s")
    }
  }

  private def duplicateCheck(cards: List[Card]): Either[String, Unit] = {
    val grouped = cards.groupBy(identity).values.filter(cs => cs.length > 1).map(_.head).toList.sortWith((x, y) => x < y)

    if (grouped.isEmpty)
      Right(())
    else
      Left(s"duplicate cards: ${grouped.mkString(", ")}")
  }
}
