package utils

import entities.{Action, Coordinates}
import exceptions.{ActionValueException, DirectionValueException, MissingMowerAttributeException}

object InputChecker {

  def checkinputForMower(line: String): Boolean = {
    val tmp = line.split(" ")
    if (tmp.size != 3) {
      throw MissingMowerAttributeException()
    }
    else {
      try {
        val x = tmp(0).toInt
        val y = tmp(1).toInt
        if (checkDirection(tmp(2))) {
          true
        } else {
          throw DirectionValueException()
        }
      } catch {
        case e: NumberFormatException => {
          println("Can only convert numbers to lawn coordinates")
        }
          false
      }
    }

  }

  def checkDirection(direc: String): Boolean = { // check if direction N E W or S
    if (direc.equals("N") || direc.equals("E") || direc.equals("W") || direc.equals("S")) {
      true
    } else {
      false
    }
  }

  def getLawnSizeFromFile(size: String): Coordinates = { // parse the first line to extract lawn max coordinates
    val tmp = size.split(" ")
    if (tmp.size != 2) {
      throw new Error("The size of the lawn should be represented by two integers separated by a space")
    } else {
      try {
        val x = tmp(0).toInt
        val y = tmp(1).toInt
        val result = new Coordinates(x, y)
        return result
      } catch {
        case e: NumberFormatException => {
          println("Can only convert numbers to lawn coordinates")
        }
      }
    }
    null
  }

  def isActionContent(actions: String)  = {// check if each char of the action line is D G or A
    val emumList = Action.values.map(_.toString).toList
    for (i <- 0 to actions.length()-1) {
      if (!emumList.contains(actions.charAt(i).toString)) {
        throw ActionValueException()
      }
    }

  }


}
