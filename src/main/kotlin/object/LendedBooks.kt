package `object`

import org.jetbrains.exposed.dao.id.IntIdTable

object LendedBooks: IntIdTable()  {
    var deadlineCount = integer ("deadlineCount")

    //var reader = reference("reader", Readers)
    var book = reference ("book", Books)
}