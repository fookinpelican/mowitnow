package utils

import java.io.{FileNotFoundException, IOException}

import scala.io.Source

object ContentGetter {
  def getFileContent(filePath: String): String = {
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
      case x: IOException => {
        println("Unable to read file")
      }
    }
    fileContent
  }
}
