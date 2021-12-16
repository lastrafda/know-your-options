object Options {
  def map[A, B](opt: Option[A])(f: A => B): Option[B] = opt match {
    case Some(opt) => Some(f(opt))
    case None      => None
  }

  def flatMap[A, B](opt: Option[A])(f: A => Option[B]): Option[B] = opt match {
    case Some(opt) => f(opt)
    case None      => None
  }

  def filter[A](opt: Option[A])(f: A => Boolean): Option[A] = opt match {
    case Some(opt) => {
      if (f(opt)) Some(opt) else None
    }
    case None => None
  }
}
