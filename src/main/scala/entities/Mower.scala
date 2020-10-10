package entities

import java.util.Optional


class Mower(var initialPlace : Coordinates, var currentPlace : Coordinates, var direction : String, var mvmts :String, var lawn : Lawn) {

  def applyMvmts(): Optional[String]  = {    // return String or nothing (to know if the actions were all completed)
    for (i <- 0 to mvmts.length-1) {       //  loop through actions
      val action = mvmts.charAt(i).toString  // get single action as string
      if (action.equals("A")) {           // if action = a, get new coordinates
        val newCoordinates = getNextMove()
        if (!lawn.isSpotTaken(newCoordinates)) {
          if (!currentPlace.isGreaterThan(lawn.size) && !newCoordinates.isOutOfBounds()){
            currentPlace = newCoordinates // if the new spot is available, and the coordinates are inside lawn update coordinates
          }
          else { // otherwise stop execution and return the reason for stopping
            return Optional.of("You're out of your lawn")
          }
        } else {
          return Optional.of("A mower's already there")
        }
      }else { // if action equals D or G rotate mower
        rotate(action)
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


  def rotate(action : String)  = {
    if (action.equals("G")){
         turnLeft()
    }
    if(action.equals("D")){
        turnRight()
    }
  }

  def turnLeft() = {
    this.direction match {
      case "N" => this.direction = "W"
      case "W" => this.direction = "S"
      case "S" => this.direction = "E"
      case "E" => this.direction = "N"
    }
  }


  def turnRight()  = {

    this.direction match {
      case "N" => this.direction = "E"
      case "W" => this.direction = "N"
      case "S" => this.direction = "W"
      case "E" => this.direction = "S"
    }

  }
  override def toString: String = { // to string override to print coordinates + direction
     currentPlace.toString + " " + direction
  }
}
