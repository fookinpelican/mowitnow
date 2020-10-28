package exceptions

final case class MissingMowerAttributeException(private val message: String = "Missing or too many parameter(s) in mower creation",
                                                private val cause: Throwable = None.orNull) extends Exception(message, cause) {

}