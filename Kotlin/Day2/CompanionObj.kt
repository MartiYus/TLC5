//class User{
//    val nickname: String
//    constructor(email: String) {
//        nickname = email.substringBefore('@')
//    }
//    constructor(facebookAccountId: Int) {
//        nickname = "FB$facebookAccountId"
//    }
//}

fun main(args: Array<String>){
//    val user1 = User("martina@email.com")
//    println("User1 ${user1.nickname}")
//
//    val user2 = User(12345)
//    println("User2 ${user2.nickname}")

    val user1 = User.newSubscribingUser("martina@gmail.com")
    println("User1 ${user1.nickname}")
    val user2 = User.newFacebookUser(12345)
    println("User2 ${user2.nickname}")
}


class User private constructor(val nickname: String) {
    //used as factory
    companion object {
        fun newSubscribingUser(email: String) =
            User(email.substringBefore('@'))
        fun newFacebookUser(accountId: Int) =
            User("FB$accountId")
    }
}

