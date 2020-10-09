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


}
