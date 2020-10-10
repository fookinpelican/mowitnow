package entities

class Coordinates (var x: Int, var y: Int){



  override def toString: String =
    s"($x, $y)"

   def equals(coordinates: Coordinates): Boolean = {
    if (this.x == coordinates.x && this.y == coordinates.y) {
      true
    }else {
      false
    }
  }

  def isGreaterThan(coordinates: Coordinates) : Boolean = {
    if(this.x > coordinates.x || this.y > coordinates.y) {
      true
    } else {
      false
    }

  }
  def isOutOfBounds() : Boolean = {
    if(this.x < 0 || this.y < 0) {
      true
    } else {
      false
    }
  }
}
