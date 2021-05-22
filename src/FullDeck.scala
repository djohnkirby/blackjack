object FullDeck {
  val allRanks = Set(Ace, Two,Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King)
  val allSuits = Set(Clubs, Diamonds, Hearts, Spades)

  val fullDeck = for(rank <- allRanks; suit <- allSuits) yield Card(rank, suit)
}
