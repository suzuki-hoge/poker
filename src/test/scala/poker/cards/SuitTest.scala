package poker.cards

import org.scalatest.FunSuite

class SuitTest extends FunSuite {
  test("toString") {
    assert(Suit.S.toString == "S")
    assert(Suit.H.toString == "H")
    assert(Suit.D.toString == "D")
    assert(Suit.C.toString == "C")
  }

  test("fromString") {
    assert(Suit.fromString("S") == Right(Suit.S))
    assert(Suit.fromString("H") == Right(Suit.H))
    assert(Suit.fromString("D") == Right(Suit.D))
    assert(Suit.fromString("C") == Right(Suit.C))

    assert(Suit.fromString("A") == Left("invalid suit string: A"))
  }

  test("<") {
    assert(Suit.C < Suit.D)
    assert(Suit.D < Suit.H)
    assert(Suit.H < Suit.S)
  }
}
