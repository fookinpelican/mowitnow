package entities


import scala.collection.mutable.ArrayBuffer

class Lawn(var mowers : ArrayBuffer[Mower], var size : Coordinates) {

  def addMower(mower : Mower) = {
    for (a <- mowers) {
      if (a.currentPlace.equals(mower)) {
        throw new Error("A mower is already in this spot")
      }
    }
    mowers += mower
  }
  def this(size : Coordinates, mowers : ArrayBuffer[Mower]) = {
    this(mowers, size)
  }
  def isSpotTaken(coordinates: Coordinates) : Boolean = {
    for (mower <- mowers) {
      if (coordinates.equals(mower.currentPlace)) {
        true
      }
    }
    false
  }

  def applyActions()  = {
    for( mower <- mowers) {
      mower.applyMvmts()
      println("stop")

    }
  }

  def printMowers() = {
    for (i <- 0 to mowers.size - 1) {
      println("Mower "+ (i+1) + " : " +mowers(i).toString)
    }
  }
}
