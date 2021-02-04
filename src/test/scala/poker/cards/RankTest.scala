package poker.cards

import org.scalatest.FunSuite

class RankTest extends FunSuite {
  test("toString") {
    assert(Rank(14).toString == "A")
    assert(Rank(13).toString == "K")
    assert(Rank(12).toString == "Q")
    assert(Rank(11).toString == "J")
    assert(Rank(10).toString == "10")
    assert(Rank(2).toString == "2")
  }

  test("fromString") {
    assert(Rank.fromString("A") == Right(Rank(14)))
    assert(Rank.fromString("K") == Right(Rank(13)))
    assert(Rank.fromString("Q") == Right(Rank(12)))
    assert(Rank.fromString("J") == Right(Rank(11)))
    assert(Rank.fromString("10") == Right(Rank(10)))
    assert(Rank.fromString("2") == Right(Rank(2)))

    assert(Rank.fromString("1") == Left("invalid rank string: 1"))
  }

  test("<") {
    assert(Rank(2) < Rank(3))
    assert(Rank(10) < Rank(11))
  }
}
