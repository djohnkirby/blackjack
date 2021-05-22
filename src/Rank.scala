sealed trait Rank{
  val values: Set[Int]
}

case object Two extends Rank{ override val values = Set(2) }
case object Three extends Rank{ override val values = Set(3) }
case object Four extends Rank{ override val values = Set(4) }
case object Five extends Rank{ override val values = Set(5) }
case object Six extends Rank{ override val values = Set(6) }
case object Seven extends Rank{ override val values = Set(7) }
case object Eight extends Rank{ override val values = Set(8) }
case object Nine extends Rank{ override val values = Set(9) }
case object Ten extends Rank{ override val values = Set(10) }
case object Jack extends Rank{ override val values = Set(10) }
case object Queen extends Rank{ override val values = Set(10) }
case object King extends Rank{ override val values = Set(10) }
case object Ace extends Rank{ override val values = Set(11,1) }
