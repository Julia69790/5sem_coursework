package `object`

import org.jetbrains.exposed.dao.id.IntIdTable

object Librarians: IntIdTable()   {
    var name = varchar("name", length = 50)
}