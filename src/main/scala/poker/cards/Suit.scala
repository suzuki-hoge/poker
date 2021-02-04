package poker.cards

/**
  * スート
  */
sealed trait Suit {
  def <(o: Suit): Boolean
}

/**
  * スート
  */
object Suit {

  /**
    * スペード
    *
    * 一番強いスート
    */
  object S extends Suit {
    override def <(o: Suit): Boolean = false

    override def toString: String = "S"
  }

  /**
    * ハート
    *
    * スペードの次に強いスート
    */
  object H extends Suit {
    override def <(o: Suit): Boolean = o == S

    override def toString: String = "H"
  }

  /**
    * ダイヤ
    *
    * ハートの次に強いスート
    */
  object D extends Suit {
    override def <(o: Suit): Boolean = o == S || o == H

    override def toString: String = "D"
  }

  /**
    * クラブ
    *
    * 一番弱いスート
    */
  object C extends Suit {
    override def <(o: Suit): Boolean = o == S || o == H || o == D

    override def toString: String = "C"
  }

  /**
    * 文字列をパースしてスートにする
    *
    * @param s 文字列
    * @return スートとして不正な文字列の場合は失敗し、メッセージを返す
    */
  def fromString(s: String): Either[String, Suit] = s match {
    case "S" => Right(S)
    case "H" => Right(H)
    case "D" => Right(D)
    case "C" => Right(C)
    case _ => Left(s"invalid suit string: $s")
  }
}
