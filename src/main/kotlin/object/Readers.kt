package `object`

import org.jetbrains.exposed.dao.id.IntIdTable

object Readers: IntIdTable() {
    var name = varchar("name", length = 50)
    //var phoneNumber = integer("phoneNumber")
}