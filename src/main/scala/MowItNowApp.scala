
import entities.{Coordinates, Lawn, Mower}
import utils.{ContentGetter, InputChecker}

import scala.collection.mutable.ArrayBuffer

object MowItNowApp extends App {
  println("**********************************")
  println("Welcome to the lawn mower app")
  println("**********************************")

  println("- Please type the full path of your conf file")
  val filePath = scala.io.StdIn.readLine()      // get user input

  var fileContent = ContentGetter.getFileContent(filePath)   // get file content as string

  var tmp = fileContent.split("\n")
  if (tmp.size % 2 != 1) {
    throw new Error("Your file is missing lines")
  }

  var lawn = new Lawn(ArrayBuffer[Mower](),InputChecker.getLawnSizeFromFile(tmp(0))) // create coord from 1st line of file and create lawn

  for(a <- 1 to tmp.size - 1 by 2){        // loop though mower spec in file content
    if (InputChecker.checkinputForMower(tmp(a))) {  // check if line contains right info
      val splitLine = tmp(a).split(" ")
      val coordinates = new Coordinates(splitLine(0).toInt, splitLine(1).toInt) // create new coordinates
      val mvmts = tmp(a+1)        // get actions line
      if (coordinates.isGreaterThan(lawn.size)) { // check if mower is not outside of lawn
        throw new Error("mower outside of lawn")
      }
      if (!InputChecker.isActionContent(mvmts)) {  // check if actions only contains D G or A
        throw new Error("Actions can only be D G or A")
      }
      lawn.addMower(new Mower(coordinates, coordinates, splitLine(2), mvmts, lawn)) // add mowers to the lawn
    }
  }
  lawn.applyActions()  // for each mower on the lawn apply actions
  lawn.printMowers() // print the result of the mvmts








}
