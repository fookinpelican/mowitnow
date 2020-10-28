package utils

import java.io.{FileNotFoundException, IOException}

import scala.io.{BufferedSource, Source}

object ContentGetter {
  def getFileContent(filePath: String): String = {
    var fileContent = ""
    try {
      val bufferedSource = getBufferForInput(filePath)
      for (line <- bufferedSource.getLines()) {
        fileContent = fileContent + line + "\n"
      }
      bufferedSource.close

    } catch {
      case x: FileNotFoundException => {
        throw new Error("Unable to find file")
      }
      case x: IOException => {
        throw new Error("Unable to read file")
      }
    }
    fileContent
  }
  def getBufferForInput(path : String) : BufferedSource = {
    if (path.isEmpty) {
      Source.fromInputStream(getClass().getClassLoader().getResourceAsStream("test"))
    }else{
      Source.fromFile(path)
    }
  }
}
