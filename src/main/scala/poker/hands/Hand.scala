package poker.hands

import poker.cards.{Card, Cards}

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

  def check(cards: Cards): Hand = ???

  def check2(cards: Cards): List[Hand] = ???

  def checkHighCards(cards: Cards): Hand = ???

  def checkOnePair(cards: Cards): Hand = ???

  def checkTwoPair(cards: Cards): Hand = ???

  def checkThreeOfAKind(cards: Cards): Hand = ???

  def checkStraight(cards: Cards): Hand = ???

  def checkFlush(cards: Cards): Hand = ???

  def checkFullHouse(cards: Cards): Hand = ???

  def checkFourOfAKind(cards: Cards): Hand = ???

  def checkStraightFlush(cards: Cards): Hand = ???

  def checkRoyalStraightFlush(cards: Cards): Hand = ???

}
