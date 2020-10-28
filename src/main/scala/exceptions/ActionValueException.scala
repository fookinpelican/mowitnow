package exceptions


final case class ActionValueException (private val message: String = "Actions can only be D G or A",
                                       private val cause: Throwable = None.orNull) extends Exception(message, cause) {

}
