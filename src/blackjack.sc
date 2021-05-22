
val target = 21
val blackJack = Set(Card(Jack,Spades),Card(Ace,Spades))

def handScore(hand: Set[Card]): Int = {
  hand.foldRight(Set(0))((card, possibleScores) => {
    card.rank.values.flatMap(value => {
      possibleScores.map(_ + value)
    })
  })
    .filter(_ <= target)
    .max
}


def generateAllHandsOfSize(deck: Set[Card], size: Int) = {
  //consider one card at a time
  deck.foldRight(Set(Set.empty[Card]))((card, hands) => {
    //for each card we see we can either choose to add it to the set or not add it
    hands.flatMap(hand => {
      if(hand.size < size){
        Set(hand + card, hand)
      }
      else
        Set(hand)
    })
  }).filter(_.nonEmpty)
}


generateAllHandsOfSize(FullDeck.fullDeck, 7)
  .count(handScore(_)== target)