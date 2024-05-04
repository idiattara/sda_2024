package sda.parser

import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods
import sda.reader._

object ConfigurationParser {

  implicit val format = DefaultFormats

  def getCsvReaderConfigurationFromJson(jsonString: String): CsvReader = {
    JsonMethods.parse(FileReaderUsingIOSource.getContent(jsonString)).extract[CsvReader]
  }

  /* Complétez cette fonction. Elle prend un String  en argument et renvoie un objet JsonReader.
     Elle doit être codée de la même manière que la fonction  getCsvReaderConfigurationFromJson

  def getJsonReaderConfigurationFromJson(jsonString: String): JsonReader = {
  ................................................................
  }
   */

}


