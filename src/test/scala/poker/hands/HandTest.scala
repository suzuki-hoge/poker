package poker.hands

import org.scalatest.FunSuite
import poker.cards.{Card, Cards}
import poker.hands.Hand._

class HandTest extends FunSuite {
  test("check") {
    val cards1 = $$("S-3 H-4 C-6 H-8 S-9")
    assert(Hand.check(cards1) == HighCards($("S-9")))

    val cards2 = $$("S-3 H-5 D-3 C-3 S-5")
    assert(Hand.check(cards2) == FullHouse($("S-3")))

    val cards3 = $$("S-10 S-J S-Q S-K S-A")
    assert(Hand.check(cards3) == RoyalStraightFlush($("S-A")))
  }

  test("checkHighCards") {
    val cards = $$("S-3 H-4 C-6 H-8 S-9")
    assert(Hand.checkHighCards(cards) contains HighCards($("S-9")))
  }

  test("checkOnePair") {
    val cards = $$("S-3 H-4 C-3 H-5 S-6")
    assert(Hand.checkOnePair(cards) contains OnePair($("S-3")))
  }

  test("checkTwoPair") {
    val cards = $$("S-3 H-4 C-3 H-5 S-5")
    assert(Hand.checkTwoPair(cards) contains TwoPair($("S-5")))
  }

  test("checkThreeOfAKind") {
    val cards = $$("S-3 H-4 C-3 H-5 H-3")
    assert(Hand.checkThreeOfAKind(cards) contains ThreeOfAKind($("S-3")))
  }

  test("checkStraight") {
    val cards = $$("S-3 H-4 C-5 H-6 C-7")
    assert(Hand.checkStraight(cards) contains Straight($("C-7")))
  }

  test("checkFlush") {
    val cards = $$("S-3 S-5 S-7 S-9 S-J")
    assert(Hand.checkFlush(cards) contains Flush($("S-J")))
  }

  test("checkFullHouse") {
    val cards = $$("S-3 H-5 D-3 C-3 S-5")
    assert(Hand.checkFullHouse(cards) contains FullHouse($("S-3")))
  }

  test("checkFourOfAKind") {
    val cards = $$("S-3 H-3 D-3 C-3 S-5")
    assert(Hand.checkFourOfAKind(cards) contains FourOfAKind($("S-3")))
  }

  test("checkStraightFlush") {
    val cards = $$("S-2 S-3 S-4 S-5 S-6")
    assert(Hand.checkStraightFlush(cards) contains StraightFlush($("S-6")))
  }

  test("checkRoyalStraightFlush") {
    val cards = $$("S-10 S-J S-Q S-K S-A")
    assert(Hand.checkRoyalStraightFlush(cards) contains RoyalStraightFlush($("S-A")))
  }

  test("nCountMRanks") {
    val cards1 = $$("S-10 S-J S-Q S-K H-K")
    assert(Hand.nCountMRanks(cards1, 1, 2) contains $("S-K"))
    assert(Hand.nCountMRanks(cards1, 1, 3) isEmpty)
    assert(Hand.nCountMRanks(cards1, 2, 2) isEmpty)

    val cards2 = $$("S-10 S-J S-Q H-Q D-Q")
    assert(Hand.nCountMRanks(cards2, 1, 2) isEmpty)
    assert(Hand.nCountMRanks(cards2, 1, 3) contains $("S-Q"))
    assert(Hand.nCountMRanks(cards2, 2, 2) isEmpty)

    val cards3 = $$("S-10 S-J H-J H-Q D-Q")
    assert(Hand.nCountMRanks(cards3, 1, 2) isEmpty)
    assert(Hand.nCountMRanks(cards3, 1, 3) isEmpty)
    assert(Hand.nCountMRanks(cards3, 2, 2) contains $("H-Q"))
  }

  test("continualRanks") {
    val cards1 = $$("S-10 S-J H-Q H-K H-A")
    assert(Hand.continualRanks(cards1) contains cards1)

    val cards2 = $$("S-2 S-3 S-4 S-5 S-7")
    assert(Hand.continualRanks(cards2) isEmpty)
  }

  test("allSameSuits") {
    val cards1 = $$("S-10 S-J S-Q S-K S-A")
    assert(Hand.allSameSuits(cards1) contains cards1)

    val cards2 = $$("S-2 S-3 S-4 S-5 H-7")
    assert(Hand.allSameSuits(cards2) isEmpty)
  }

  test("startsWith10") {
    val cards1 = $$("S-10 S-J H-J H-K S-A")
    assert(Hand.startsWith10(cards1) contains cards1)

    val cards2 = $$("S-10 S-9 S-J S-Q S-K")
    assert(Hand.startsWith10(cards2) isEmpty)
  }

  private def $$(s: String): Cards = Cards.fromString(s).right.get

  private def $(s: String): Card = Card.fromString(s).right.get
}
