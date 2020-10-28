package entities


import scala.collection.mutable.ArrayBuffer

class Lawn(var mowers : ArrayBuffer[Mower], var size : Coordinates) {

  def addMower(mower : Mower) = {   // add mower to the list of mowers if one isnt already there
    for (a <- mowers) {
      if (a.currentPlace.equals(mower)) {
        throw new Error("A mower is already in this spot")
      }
    }
    mowers += mower
  }

  def isSpotTaken(coordinates: Coordinates) : Boolean = {   // check if a mower is already at coordinates
    for (mower <- mowers) {
      if (coordinates.equals(mower.currentPlace)) {
        return true
      }
    }
    false
  }

  def applyActions(index : Int)  = {    // for each mower apply list of actions and print note if the actions couldn't all be completed
    //for( mower <- mowers) {
      val test = mowers(index).applyMvmts()
      if (test.isPresent) {
        println("NOTE : Your mower stopped before the end of its cycle with following message")
        println(test.get())
      }
    //}
  }

  def printMowers() = {   // format the printing of the mowers on lawn
    for (i <- 0 to mowers.size - 1) {
      println("Mower "+ (i+1) + " : " +mowers(i).toString)
    }
  }
}
