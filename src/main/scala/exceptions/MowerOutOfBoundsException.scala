package exceptions
final case class MowerOutOfBoundsException (private val message: String = "The mower is outside the lawn",
                                       private val cause: Throwable = None.orNull) extends Exception(message, cause) {

}