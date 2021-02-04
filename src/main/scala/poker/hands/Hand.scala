package poker.hands

import poker.cards.{Card, Cards}

/**
  * 手役
  */
sealed trait Hand

/**
  * 手役
  */
object Hand {

  /**
    * ハイカード
    *
    * 常に成立する
    *
    * @param card 手役を構成するカードのうち一番強いもの
    */
  case class HighCards(card: Card) extends Hand {
  }

  /**
    * ワンペア
    *
    * 同ランクによる 2 枚組が 1 セット存在する場合に成立する
    *
    * @param card 手役を構成するカードのうち一番強いもの
    */
  case class OnePair(card: Card) extends Hand {
  }

  /**
    * ツーペア
    *
    * 同ランクによる 2 枚組が 2 セット存在する場合に成立する
    *
    * @param card 手役を構成するカードのうち一番強いもの
    */
  case class TwoPair(card: Card) extends Hand {
  }

  /**
    * スリーオブアカインド
    *
    * 同ランクによる 3 枚組が 1 セット存在する場合に成立する
    *
    * @param card 手役を構成するカードのうち一番強いもの
    */
  case class ThreeOfAKind(card: Card) extends Hand {
  }

  /**
    * ストレート
    *
    * 全てのランクが連続する場合に成立する
    *
    * @param card 手役を構成するカードのうち一番強いもの
    */
  case class Straight(card: Card) extends Hand {
  }

  /**
    * フラッシュ
    *
    * 全てのスートが同一の場合に成立する
    *
    * @param card 手役を構成するカードのうち一番強いもの
    */
  case class Flush(card: Card) extends Hand {
  }

  /**
    * フルハウス
    *
    * 同ランクによる 2 枚組が 1 セットと同ランクによる 3 枚組が 1 セット存在する場合に成立する
    *
    * @param card 手役を構成するカードのうち一番強いもの
    */
  case class FullHouse(card: Card) extends Hand {
  }

  /**
    * フォーオブアカインド
    *
    * 同ランクによる 4 枚組が 1 セット存在する場合に成立する
    *
    * @param card 手役を構成するカードのうち一番強いもの
    */
  case class FourOfAKind(card: Card) extends Hand {
  }

  /**
    * ストレートフラッシュ
    *
    * 全てのランクが連続し、全てのスートが同一の場合に成立する
    *
    * @param card 手役を構成するカードのうち一番強いもの
    */
  case class StraightFlush(card: Card) extends Hand {
  }

  /**
    * ロイヤルストレートフラッシュ
    *
    * 一番弱いカードのランクが 10 であり、全てのランクが連続し、全てのスートが同一の場合に成立する
    *
    * @param card 手役を構成するカードのうち一番強いもの
    */
  case class RoyalStraightFlush(card: Card) extends Hand {
  }

  /**
    * 成立する手役のうち最も強いものを判定する
    *
    * @param cards 手札
    * @return 成立した最も強い手役
    */
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

  private[hands] def checkHighCards(cards: Cards): Option[Hand] =
    Some(cards.strongest())
      .map(HighCards)

  private[hands] def checkOnePair(cards: Cards): Option[Hand] =
    nCountMRanks(cards, 1, 2)
      .map(OnePair)

  private[hands] def checkTwoPair(cards: Cards): Option[Hand] =
    nCountMRanks(cards, 2, 2)
      .map(TwoPair)

  private[hands] def checkThreeOfAKind(cards: Cards): Option[Hand] =
    nCountMRanks(cards, 1, 3)
      .map(ThreeOfAKind)

  private[hands] def checkStraight(cards: Cards): Option[Hand] =
    continualRanks(cards)
      .map(_.strongest())
      .map(Straight)

  private[hands] def checkFlush(cards: Cards): Option[Hand] =
    allSameSuits(cards)
      .map(_.strongest())
      .map(Flush)

  private[hands] def checkFullHouse(cards: Cards): Option[Hand] = for {
    _ <- nCountMRanks(cards, 1, 2)
    c <- nCountMRanks(cards, 1, 3)
  } yield FullHouse(c)

  private[hands] def checkFourOfAKind(cards: Cards): Option[Hand] =
    nCountMRanks(cards, 1, 4)
      .map(FourOfAKind)

  private[hands] def checkStraightFlush(cards: Cards): Option[Hand] =
    continualRanks(cards)
      .flatMap(allSameSuits)
      .map(_.strongest())
      .map(StraightFlush)

  private[hands] def checkRoyalStraightFlush(cards: Cards): Option[Hand] =
    startsWith10(cards)
      .flatMap(continualRanks)
      .flatMap(allSameSuits)
      .map(_.strongest())
      .map(RoyalStraightFlush)

  private[hands] def nCountMRanks(cards: Cards, n: Int, m: Int): Option[Card] = {
    val mRanks = cards.vs.groupBy(_.rank).values.toList.filter(cs => cs.length == m)

    if (mRanks.length == n)
      Some(mRanks.flatten.sortWith((x, y) => x < y).last)
    else
      None
  }

  private[hands] def continualRanks(cards: Cards): Option[Cards] = {
    val r = cards.vs.head.rank.v

    if (cards.vs.map(_.rank.v) == (r to r + 4).toList)
      Some(cards)
    else
      None
  }

  private[hands] def allSameSuits(cards: Cards): Option[Cards] = {
    if (cards.vs.forall(_.suit == cards.vs.head.suit))
      Some(cards)
    else
      None
  }

  private[hands] def startsWith10(cards: Cards): Option[Cards] = {
    if (cards.vs.head.rank.v == 10)
      Some(cards)
    else
      None
  }
}
