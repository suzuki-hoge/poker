package poker

import poker.cards.Cards
import poker.hands.Hand

object Game extends App {
  def judge(s: String): String = Cards.fromString(s)
    .map(Hand.check)
    .fold(identity, _.toString)
}
