package sda.parser
import scala.io.Source
object FileReaderUsingIOSource {

  def getContent(file: String): String = {
    Source.fromFile(file).getLines().mkString
  }
}


