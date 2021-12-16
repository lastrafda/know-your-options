object UserRenderer {
  // userLabel with pattern matching
  // def userLabel(user: User): String = user.pronouns match {
  //   case Some(pronouns) => s"${user.firstName} ($pronouns)"
  //   case None           => s"${user.firstName} ${user.lastName}"
  // }
  // userLabel with fold
  def userLabel(user: User): String =
    user.pronouns.fold(s"${user.firstName} ${user.lastName}")(
      pronoun => s"${user.firstName} ($pronoun)"
    )

  // firstName with pattern matching
  // def firstName(user: Option[User]): String = user match {
  //   case Some(user) => user.firstName
  //   case None       => "N/A"
  // }

  // firstName with fold
  def firstName(user: Option[User]): String =
    user.fold("N/A")(_.firstName)
}
