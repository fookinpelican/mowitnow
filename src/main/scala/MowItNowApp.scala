
import entities.{Coordinates, Lawn, Mower}
import utils.{ContentGetter, InputChecker}

import scala.collection.mutable.ArrayBuffer

object MowItNowApp extends App {
  /*Print welcome message */
  println("**********************************")
  println("Welcome to the lawn mower app")
  println("**********************************")

/*  Ask for conf file path */
  println("- Please type the full path of your conf file")
  val filePath = scala.io.StdIn.readLine()

  /* extract file content as string */
  var fileContent = ContentGetter.getFileContent(filePath)

  var tmp = fileContent.split("\n")
  if (tmp.size % 2 != 1) {
    throw new Error("Your file is missing lines")
  }
  /*Create empty lawn  */
  var lawn = new Lawn(InputChecker.getLawnSizeFromFile(tmp(0)),ArrayBuffer[Mower]())
  /*
  adds the mowers to the lawn
      - checks the first line to see if it's parsable to coordinates + N|E|W|S  or throws Error
      - creates coordinates
      - check the line of actions to see if it only contains D G and A or throws Error
      - check if mower coordinates are greater than lawn max or throws Error
      - create and add mower to lawn
   */
  for(a <- 1 to tmp.size - 1 by 2){
    if (InputChecker.checkinput(tmp(a))) {
      val splitLine = tmp(a).split(" ")
      val coordinates = new Coordinates(splitLine(0).toInt, splitLine(1).toInt)
      val mvmts = tmp(a+1)
      if (coordinates.isGreaterThan(lawn.size)) {
        throw new Error("mower outside of lawn")
      }
      if (!InputChecker.isActionContent(mvmts)) {
        throw new Error("Actions can only be D G or A")
      }
      lawn.addMower(new Mower(coordinates, coordinates, splitLine(2), mvmts, lawn))
    }
  }
  lawn.applyActions()
  lawn.printMowers()








}
