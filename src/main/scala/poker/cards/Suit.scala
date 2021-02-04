package poker.cards

sealed trait Suit {
  def <(o: Suit): Boolean
}

object Suit {

  object S extends Suit {
    override def <(o: Suit): Boolean = false

    override def toString: String = "S"
  }

  object H extends Suit {
    override def <(o: Suit): Boolean = o == S

    override def toString: String = "H"
  }

  object D extends Suit {
    override def <(o: Suit): Boolean = o == S || o == H

    override def toString: String = "D"
  }

  object C extends Suit {
    override def <(o: Suit): Boolean = o == S || o == H || o == D

    override def toString: String = "C"
  }

  def fromString(s: String): Either[String, Suit] = s match {
    case "S" => Right(S)
    case "H" => Right(H)
    case "D" => Right(D)
    case "C" => Right(C)
    case _ => Left(s"invalid suit string: $s")
  }
}
