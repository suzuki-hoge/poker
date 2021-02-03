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

  def check(cards: Cards): Hand = {
    // todo implementation
    null
  }

  def check2(cards: Cards): List[Hand] = {
    // todo implementation
    null
  }

  def checkHighCards(cards: Cards): Hand = {
    // todo implementation
    null
  }

  def checkOnePair(cards: Cards): Hand = {
    // todo implementation
    null
  }

  def checkTwoPair(cards: Cards): Hand = {
    // todo implementation
    null
  }

  def checkThreeOfAKind(cards: Cards): Hand = {
    // todo implementation
    null
  }

  def checkStraight(cards: Cards): Hand = {
    // todo implementation
    null
  }

  def checkFlush(cards: Cards): Hand = {
    // todo implementation
    null
  }

  def checkFullHouse(cards: Cards): Hand = {
    // todo implementation
    null
  }

  def checkFourOfAKind(cards: Cards): Hand = {
    // todo implementation
    null
  }

  def checkStraightFlush(cards: Cards): Hand = {
    // todo implementation
    null
  }

  def checkRoyalStraightFlush(cards: Cards): Hand = {
    // todo implementation
    null
  }

}
