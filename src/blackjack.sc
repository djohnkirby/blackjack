val target = 21
val blackJack = Set(Card(Jack,Spades),Card(Ace,Spades))

def handScore(hand: Set[Card]): Int = {
  hand.foldRight(Set(0))((card, possibleScores) => {
    card.rank.values.flatMap(value => {
      possibleScores.map(_ + value)
    })
  })
    .filter(_ <= target)
    .foldRight(0)(_ max _)
}

val sevenCardHands =
  FullDeck.fullDeck
    .subsets(7)
    .count(handScore(_) != 0)

val sevenCard21s =
  FullDeck.fullDeck
  .subsets(7)
  .count(handScore(_) == target)

print(s"There are ${sevenCardHands} possible legal hands" +
  s" of 7 cards in Blackjack and of those ${sevenCard21s} are" +
  s" 21s\n")