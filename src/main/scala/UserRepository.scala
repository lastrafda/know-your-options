object UserRepository {
  private val users = Map(
    (1, User(1, "John", "Doe", 32, Some("he/him"))),
    (2, User(2, "Johanna", "Doe", 30, Some("she/her"))),
    (3, User(3, "Jackie", "Doe", 27, Some("they/them"))),
    (4, User(4, "Jay", "Doe", 24, None)),
    (4, User(5, "Jay", "Doe", 24, Some("")))
  )
  def findById(id: Int): Option[User] = users.get(id)
  def findAll: Seq[User]              = users.values.toSeq
  // [for comprehensions] pronounsForId
  // def pronounsForId(id: Int): Option[String] =
  //   for {
  //     user     <- UserRepository.findById(id)
  //     pronouns <- user.pronouns
  //   } yield pronouns

  // [hof] pronounsForId
  def pronounsForId(id: Int): Option[String] =
    UserRepository.findById(id).flatMap(user => user.pronouns)

  def pronounsForIdMap(id: Int): Option[String] =
    UserRepository.findById(id).map(_.pronouns).map(_.get)

  def pronounsForIdWithoutBlanks(id: Int): Option[String] =
    for {
      user     <- UserRepository.findById(id)
      pronouns <- user.pronouns if !pronouns.isBlank()
    } yield pronouns

  // [for comprehensions] pronouns
  // def pronouns: Seq[String] =
  //   for {
  //     user     <- UserRepository.findAll
  //     pronouns <- user.pronouns
  //   } yield pronouns

  // [flatmap] pronouns
  def pronouns: Seq[String] =
    UserRepository.findAll.flatMap(_.pronouns)

  // [map] pronouns
  def pronounsmap: Seq[String] =
    UserRepository.findAll.map(_.pronouns).map(_.get)
}
