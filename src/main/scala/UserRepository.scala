object UserRepository {
  private val users = Map(
    (1, User(1, "John", "Doe", 32, Some("he/him"))),
    (2, User(2, "Johanna", "Doe", 30, Some("she/her"))),
    (3, User(3, "Jackie", "Doe", 27, Some("they/them"))),
    (4, User(4, "Jay", "Doe", 24, None))
  )
  def findById(id: Int): Option[User] = users.get(id)
  def findAll: Seq[User]              = users.values.toSeq
}
