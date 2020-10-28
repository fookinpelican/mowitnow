package exceptions

final case class DirectionValueException (private val message: String = "Direction can only be N E W or S",
                                          private val cause: Throwable = None.orNull) extends Exception(message, cause){

}
