package poker.cards

/**
  * ランク
  *
  * @param v 数値
  */
case class Rank(v: Int) {
  /**
    * ランクの大小比較を行う
    *
    * @param o 比較対象のランク
    * @return
    */
  def <(o:Rank):Boolean = this.v < o.v

  override def toString: String = v match {
    case 14 => "A"
    case 13 => "K"
    case 12 => "Q"
    case 11 => "J"
    case _ => v.toString
  }
}

/**
  * ランク
  */
object Rank {
  /**
    * 文字列をパースしてランクにする
    *
    * @param s 文字列
    * @return ランクとして不正な文字列の場合は失敗し、メッセージを返す
    */
  def fromString(s: String): Either[String, Rank] = s match {
    case "A" => Right(Rank(14))
    case "K" => Right(Rank(13))
    case "Q" => Right(Rank(12))
    case "J" => Right(Rank(11))
    case "10" => Right(Rank(10))
    case "9" => Right(Rank(9))
    case "8" => Right(Rank(8))
    case "7" => Right(Rank(7))
    case "6" => Right(Rank(6))
    case "5" => Right(Rank(5))
    case "4" => Right(Rank(4))
    case "3" => Right(Rank(3))
    case "2" => Right(Rank(2))
    case _ => Left(s"invalid rank string: $s")
  }
}
