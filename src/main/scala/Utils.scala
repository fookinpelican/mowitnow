import java.io.{FileNotFoundException, IOException}


import scala.io.Source

object Utils {
  def getFileContent(filePath : String) : String = {
    var fileContent = ""
    try {
      val bufferedSource = Source.fromFile(filePath)
      for (line <- bufferedSource.getLines()) {
        fileContent = fileContent + line + "\n"
      }
      bufferedSource.close

    } catch {
      case x: FileNotFoundException => {
        println("Unable to find file")
      }
      case x : IOException => {
        println("Unable to read file")
      }
    }
    fileContent
  }
  def checkinput(line : String) : Boolean = {
    var tmp = line.split(" ")
    if (tmp.size != 3) {
      throw new Error("Missing parameter in mower creation")
    }
    else {

      try{
        var x = tmp(0).toInt
        var y = tmp(1).toInt
        if(checkOnDir(tmp(2))) {
          var dir = tmp(2)
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
  def checkOnDir(direc : String) : Boolean = {
    if (direc.equals("N") || direc.equals("E") || direc.equals("W") || direc.equals("S") ) {
      true
    }else {
      false
    }
  }
  def getLawnSizeFromFile(size : String) : Coordinates ={
    var tmp = size.split(" ")
    if (tmp.size != 2) {
      throw new Error("The size of the lawn should be represented by two integers separated by a space")
    } else {
      try {
        var x = tmp(0).toInt
        var y = tmp(1).toInt
        var result = new Coordinates(x, y)
        return result
      } catch {
        case e: NumberFormatException => {
          println("Can only convert numbers to lawn coordinates")
        }
      }
    }
    return null
  }
}
