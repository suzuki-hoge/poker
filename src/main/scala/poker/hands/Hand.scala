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

  def check(cards: Cards): Hand = List(
    checkHighCards(cards),
    checkOnePair(cards),
    checkTwoPair(cards),
    checkThreeOfAKind(cards),
    checkStraight(cards),
    checkFlush(cards),
    checkFullHouse(cards),
    checkFourOfAKind(cards),
    checkStraightFlush(cards),
    checkRoyalStraightFlush(cards)
  ).flatten.last

  def checkHighCards(cards: Cards): Option[Hand] = ???

  def checkOnePair(cards: Cards): Option[Hand] = ???

  def checkTwoPair(cards: Cards): Option[Hand] = ???

  def checkThreeOfAKind(cards: Cards): Option[Hand] = ???

  def checkStraight(cards: Cards): Option[Hand] = ???

  def checkFlush(cards: Cards): Option[Hand] = ???

  def checkFullHouse(cards: Cards): Option[Hand] = ???

  def checkFourOfAKind(cards: Cards): Option[Hand] = ???

  def checkStraightFlush(cards: Cards): Option[Hand] = ???

  def checkRoyalStraightFlush(cards: Cards): Option[Hand] = ???

}
