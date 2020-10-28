package exceptions

final case class WrongNumberOfLinesException (private val message: String = "Your file must contain an odd number of lines : one for the lawn + 2 lines per mower",
                                          private val cause: Throwable = None.orNull) extends Exception(message, cause){

}
