sealed trait Suit {
  val suit: String
}

case object Spades extends Suit {
  override val suit = "spades"
}

case object Hearts extends Suit {
  override val suit = "hearts"
}

case object Clubs extends Suit {
  override val suit = "clubs"
}

case object Diamonds extends Suit {
  override val suit = "diamonds"
}
