package poker.cards

import org.scalatest.FunSuite

class CardTest extends FunSuite {
  test("toString") {
    assert(Card(Suit.S, Rank(14)).toString == "S-A")    // - つなぎ
  }

  test("fromString") {
    assert(Card.fromString("S-10") == Right(Card(Suit.S, Rank(10))))

    assert(Card.fromString("S10") == Left("invalid card format: S10"))
  }

  test("<") {
    assert(Card(Suit.S, Rank(3)) < Card(Suit.S, Rank(4)))
    assert(Card(Suit.H, Rank(3)) < Card(Suit.S, Rank(3)))
  }
}
