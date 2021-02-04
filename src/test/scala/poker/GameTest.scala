package poker

import org.scalatest.FunSuite

class GameTest extends FunSuite {
  test("judge") {
    assert(Game.judge("S-3 H-4 C-6 H-8 S-9") == "HighCards(S-9)")
    assert(Game.judge("H-3 H-4 H-6 H-8 H-9") == "Flush(H-9)")

    assert(Game.judge("S-A S-K S-K S-J S-J") == "duplicate cards: S-J, S-K")
  }
}
