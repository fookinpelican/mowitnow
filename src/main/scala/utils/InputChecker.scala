package utils

import entities.{Action, Coordinates}

object InputChecker {

  def checkinputForMower(line: String): Boolean = {
    val tmp = line.split(" ")
    if (tmp.size != 3) {
      throw new Error("Missing parameter in mower creation")
    }
    else {
      try {
        val x = tmp(0).toInt
        val y = tmp(1).toInt
        if (checkDirection(tmp(2))) {
          true
        } else {
          throw new Error("Direction can only be N E W or S ")
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

  def isActionContent(actions: String): Boolean = {  // check if each char of the action line is D G or A
    for (i <- 0 to actions.length()-1) {
      if (!Action.isActionType(actions.charAt(i).toString)) {
        false
      }
    }
    true
  }



}
