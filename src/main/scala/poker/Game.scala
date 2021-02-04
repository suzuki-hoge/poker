package poker

import poker.cards.Cards
import poker.hands.Hand

/**
  * ゲーム
  */
object Game extends App {
  /**
    * 判定
    *
    * @param s 手札文字列
    * @return 結果文字列
    */
  def judge(s: String): String = Cards.fromString(s)
    .map(Hand.check)
    .fold(identity, _.toString)
}
