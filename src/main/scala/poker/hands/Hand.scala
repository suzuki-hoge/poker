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

  def checkHighCards(cards: Cards): Option[Hand] =
    Some(cards.strongest())
      .map(HighCards)

  def checkOnePair(cards: Cards): Option[Hand] =
    nCountMRanks(cards, 1, 2)
      .map(OnePair)

  def checkTwoPair(cards: Cards): Option[Hand] =
    nCountMRanks(cards, 2, 2)
      .map(TwoPair)

  def checkThreeOfAKind(cards: Cards): Option[Hand] =
    nCountMRanks(cards, 1, 3)
      .map(ThreeOfAKind)

  def checkStraight(cards: Cards): Option[Hand] =
    continualRanks(cards)
      .map(_.strongest())
      .map(Straight)

  def checkFlush(cards: Cards): Option[Hand] =
    allSameSuits(cards)
      .map(_.strongest())
      .map(Flush)

  def checkFullHouse(cards: Cards): Option[Hand] = for {
    _ <- nCountMRanks(cards, 1, 2)
    c <- nCountMRanks(cards, 1, 3)
  } yield FullHouse(c)

  def checkFourOfAKind(cards: Cards): Option[Hand] =
    nCountMRanks(cards, 1, 4)
      .map(FourOfAKind)

  def checkStraightFlush(cards: Cards): Option[Hand] =
    continualRanks(cards)
      .flatMap(allSameSuits)
      .map(_.strongest())
      .map(StraightFlush)

  def checkRoyalStraightFlush(cards: Cards): Option[Hand] =
    startsWith10(cards)
      .flatMap(continualRanks)
      .flatMap(allSameSuits)
      .map(_.strongest())
      .map(RoyalStraightFlush)

  def nCountMRanks(cards: Cards, n: Int, m: Int): Option[Card] = {
    val mRanks = cards.vs.groupBy(_.rank).values.toList.filter(cs => cs.length == m)

    if (mRanks.length == n)
      Some(mRanks.flatten.sortWith((x, y) => x < y).last)
    else
      None
  }

  def continualRanks(cards: Cards): Option[Cards] = {
    val r = cards.vs.head.rank.v

    if (cards.vs.map(_.rank.v) == (r to r + 4).toList)
      Some(cards)
    else
      None
  }

  def allSameSuits(cards: Cards): Option[Cards] = {
    if (cards.vs.forall(_.suit == cards.vs.head.suit))
      Some(cards)
    else
      None
  }

  def startsWith10(cards: Cards): Option[Cards] = {
    if (cards.vs.head.rank.v == 10)
      Some(cards)
    else
      None
  }
}
