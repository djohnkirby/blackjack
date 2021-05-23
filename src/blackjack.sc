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

FullDeck.fullDeck
  .subsets(7)
  .count(handScore(_) == target)