import minitest._

object UserRendererTest extends SimpleTestSuite {
  test("Label for user with pronouns contains first name and pronouns") {
    val user = User(1, "Jimmy", "Doe", 25, Some("they/them"))
    assertEquals(UserRenderer.userLabel(user), "Jimmy (they/them)")
  }
  test("Label for user without pronouns contains first and last name") {
    val user = User(1, "Jose", "Lastra", 25, None)
    assertEquals(UserRenderer.userLabel(user), "Jose Lastra")
  }

  test("first name is returned if optional user is defined") {
    val user = Option(User(1, "Jose", "Doe", 25, Some("he/him")))
    assertEquals(UserRenderer.firstName(user), "Jose")
  }

  test("N/A is returned if optional user is not defined") {
    assertEquals(UserRenderer.firstName(None), "N/A")
  }
}
