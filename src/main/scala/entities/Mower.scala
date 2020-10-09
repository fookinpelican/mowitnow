package entities

import java.util.Optional


class Mower(var initialPlace : Coordinates, var currentPlace : Coordinates, var direction : String, var mvmts :String, var lawn : Lawn) {

  def applyMvmts(): Optional[String]  = {
    for (i <- 0 to mvmts.length-1) {
      val action = mvmts.charAt(i).toString
      if (action.equals("A")) {
        val newCoordinates = getNextMove()
        println(newCoordinates.toString)
        if (!lawn.isSpotTaken(newCoordinates)) {
          if (!currentPlace.isGreaterThan(lawn.size) || newCoordinates.isOutOfBounds()){
            currentPlace = newCoordinates
          }
          else {
            return Optional.of("You're out of your lawn")
          }
        } else {
          return Optional.of("A mower's already there")
        }
      }else {
        val test = rotate(action)
        this.direction = test
      }
    }
    Optional.empty()
  }

  def getNextMove(): Coordinates = {

      if (this.direction.equals("N")) {
        new Coordinates(this.currentPlace.x, this.currentPlace.y+1)
      } else if (this.direction.equals("S")){
        new Coordinates(this.currentPlace.x, this.currentPlace.y-1)
      }else if (this.direction.equals("E")) {
        new Coordinates(this.currentPlace.x+1, this.currentPlace.y)
      } else {
        new Coordinates(this.currentPlace.x-1, this.currentPlace.y)
      }
  }


  def rotate(action : String) : String = {
    if (action.equals("G")){
        println("turning left")
        return turnLeft()
    }
    if(action.equals("D")){
      println("turning right")
       return turnRight()
    }
    null
  }
  def turnLeft(): String = {
    if (this.direction.equals("N")) {
      return "W"
    }
    if(this.direction.equals("W")){
      return "S"
    }
    if(this.direction.equals("S")){
      return "E"
    }
    if(this.direction.equals("E")){
      return "N"

    }
    null
  }
  def turnRight(): String  = {
    if (this.direction.equals("N")) {
      return "E"
    }
    if(this.direction.equals("W")){
      return "N"
    }
    if(this.direction.equals("S")){
      return "W"
    }
    if(this.direction.equals("E")){
      return "S"
    }
    null
  }
  override def toString: String = {
     currentPlace.toString + " " + direction
  }
}
