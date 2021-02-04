package poker.cards

import org.scalatest.FunSuite

class CardsTest extends FunSuite {
  test("fromString") {
    assert(Cards.fromString("S-A S-K S-Q S-J S-10") == Right(Cards(List(
      Card(Suit.S, Rank(10)), Card(Suit.S, Rank(11)), Card(Suit.S, Rank(12)), Card(Suit.S, Rank(13)), Card(Suit.S, Rank(14))
    ))))

    assert(Cards.fromString("S-A S-K S-Q S-J") == Left("invalid cards format: S-A S-K S-Q S-J"))
    assert(Cards.fromString("S-A S-K S-Q S-J S-10 S-9") == Left("invalid cards format: S-A S-K S-Q S-J S-10 S-9"))
    assert(Cards.fromString("S-A S-K S-K S-J S-J") == Left("duplicate cards: S-J, S-K"))
    assert(Cards.fromString("S-A S-K S-Q S-J S10") == Left("invalid card format: S10"))
    assert(Cards.fromString("S-A S-K S-Q S-J S-X") == Left("invalid rank string: X"))
  }
}
