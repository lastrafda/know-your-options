import minitest.SimpleTestSuite

object OptionsTest extends SimpleTestSuite {
  test("[map] returns `None` if the option is not defined") {
    val noNumber: Option[Int] = None
    assertEquals(Options.map(noNumber)(_ + 1), None)
  }

  test("[map] returns a `Some` if the option is defined") {
    val number: Option[Int] = Some(1)
    assertEquals(Options.map(number)(_ + 1), Some(2))
  }

  test("[flatMap] returns a `None` if the parent Option is not defined") {
    val noUser: Option[User] = None
    assertEquals(Options.flatMap(noUser)(_.pronouns), None)
  }

  test("[flatMap] returns a `Some` if the parent Option is defined") {
    val user: Option[User] = Some(User(1, "Jose", "Lastra", 25, Some("he/him")))
    assertEquals(Options.flatMap(user)(_.pronouns), Some("he/him"))
  }

  test("[flatMap] returns a `Some` if the nested Option is not defined") {
    val user: Option[User] = Some(User(1, "Jose", "Lastra", 25, None))
    assertEquals(Options.flatMap(user)(_.pronouns), None)
  }

  test("[filter] returns `None` if the predicate is false") {
    val user: Option[User] = Some(User(1, "Jose", "Lastra", 25, Some("he/him")))
    assertEquals(Options.filter(user)(_.firstName.equals("Pablo")), None)
  }

  test("[filter] returns a `Some` if the predicate is true") {
    val user: Option[User] = Some(User(1, "Jose", "Lastra", 25, Some("he/him")))
    assertEquals(Options.filter(user)(_.firstName.equals("Jose")), user)
  }

  test("[filter] returns `None` if there is no `Some` caller") {
    val user: Option[User] = None
    assertEquals(Options.filter(user)(_.firstName.equals("Jose")), None)
  }
}
