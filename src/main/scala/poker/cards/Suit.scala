package poker.cards

sealed trait Suit {
}

object Suit {

  object S extends Suit {
    override def toString: String = "S"
  }

  object H extends Suit {
    override def toString: String = "H"
  }

  object D extends Suit {
    override def toString: String = "D"
  }

  object C extends Suit {
    override def toString: String = "C"
  }

}
