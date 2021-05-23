# blackjack
Exploring combinatorics with Blackjack!

I wrote this code to explore some interesting questions about
combinatorics that I started coming upon while reading Edward Thorp's
[autobiography](https://www.amazon.com/A-Man-for-All-Markets-audiobook/dp/B01N4JAXQM/ref=sr_1_1?dchild=1&keywords=a+man+for+all+markets&qid=1621810952&sr=8-1)
about his career as the inventor of modern card counting.

In one chapter he recounts the story of his first attempt to test his
card counting system, in which he pulled a 7-card 21. He said this was a rare event.
I was immediately [nerd sniped](https://xkcd.com/356/). How rare exactly?

Well it turns out that 52 choose 7 = 133,784,560. So there are over one hundred million
possible 7-card hands. But how many of them are worth 21?

Well first I needed to write a method to calculate the score of a given
hand, unfortunately the Ace can take on two possible scores, so I had to
dynamically detect the highest non-busting score. The final `foldRight`
is needed to ensure that there is a score of 0 for any busting hand:

```
def handScore(hand: Set[Card]): Int = {
  hand.foldRight(Set(0))((card, possibleScores) => {
    card.rank.values.flatMap(value => {
      possibleScores.map(_ + value)
    })
  })
    .filter(_ <= target)
    .foldRight(0)(_ max _)
}
```

Finally then this was just a matter of selecting all subsets of size
7:
```
FullDeck.fullDeck
  .subsets(7)
  .count(handScore(_) == target)
```

And it turns out the answer is....48,276. And that took my laptop 11 minutes!

So the answer of how rare of an event this was, it will occur in only
0.03% of 7-card hands!

Isn't it amazing that [Edward Thorp](https://en.wikipedia.org/wiki/Edward_O._Thorp)
was able to do all this [in the 1960s using FORTRAN](https://youtu.be/nn6HZdMJwnU?t=20)!?