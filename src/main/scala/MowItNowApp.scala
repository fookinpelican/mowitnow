
import scala.collection.mutable.ArrayBuffer

object MowItNowApp extends App {
  println("**********************************")
  println("Welcome to the lawn mower app")
  println("**********************************")

  println("- Please type the full path of your conf file")
  val filePath = scala.io.StdIn.readLine()
  var fileContent = Utils.getFileContent(filePath)
  var tmp = fileContent.split("\n")
  if (tmp.size % 2 != 1) {
    throw new Error("Your file is missing lines")
  }
  var lawn = new Lawn(Utils.getLawnSizeFromFile(tmp(0)),ArrayBuffer[Mower]())
  // get number of mowers
  var numberOfMowersDescr = (tmp.size - 1)

// fill
  for( a <- 1 to numberOfMowersDescr by 2){
    if (Utils.checkinput(tmp(a))) {
      var splitLine = tmp(a).split(" ")
      var coordinates = new Coordinates(splitLine(0).toInt, splitLine(1).toInt)
      if (coordinates.isGreaterThan(lawn.size)) {
        throw new Error("Mower outside of lawn")
      }
      if (!Action.isActionType(splitLine(2))){
        throw new Error(splitLine(2) +" is not of type action")
      }
      lawn.addMower(new Mower(coordinates, coordinates, splitLine(2)))
    } else {
      throw new Error("Input error, please check file content")
    }
  }



}
