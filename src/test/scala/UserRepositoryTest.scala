import minitest.SimpleTestSuite
object UserRepositoryTest extends SimpleTestSuite {
  test(
    "def pronouns should still work after using hofs instead of for comprehensions"
  ) {
    assertEquals(UserRepository.pronouns.length, 4)
  }

  test("pronouns for id with an empty string should return None") {
    assertEquals(UserRepository.pronounsForIdWithoutBlanks(5), None)
  }
}
