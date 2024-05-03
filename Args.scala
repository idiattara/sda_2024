package sda.args
import com.beust.jcommander.{JCommander, Parameter}
object Args {

  @Parameter(
    names = Array("-rc", "--reader-file-path"),
    description = "Reader configuration file path",
    required = true)
  var readerConfigurationFile: String = _


  @Parameter(
    names = Array("-rt", "--reader-type"),
    description = "Reader type ",
    required = true)
  var readertype: String = _



  def parseArguments(args: Array[String]) = {
    new JCommander(this, args.toArray: _*)
  }
}


