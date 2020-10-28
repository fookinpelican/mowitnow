package entities

object Action extends Enumeration {
  type Action = Value

  val left = Value("G")
  val go = Value("A")
  val right = Value("D")


}
