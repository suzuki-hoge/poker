package poker.hands

import poker.cards.Card

sealed trait Hand

object Hand {

  case class HighCards(card: Card) extends Hand {
  }

  case class OnePair(card: Card) extends Hand {
  }

  case class TwoPair(card: Card) extends Hand {
  }

  case class ThreeOfAKind(card: Card) extends Hand {
  }

  case class Straight(card: Card) extends Hand {
  }

  case class Flush(card: Card) extends Hand {
  }

  case class FullHouse(card: Card) extends Hand {
  }

  case class FourOfAKind(card: Card) extends Hand {
  }

  case class StraightFlush(card: Card) extends Hand {
  }

  case class RoyalStraightFlush(card: Card) extends Hand {
  }

}
