package `object`

import org.jetbrains.exposed.dao.id.IntIdTable

object Books : IntIdTable() {
    var title = varchar("title", length = 50)
    var author = varchar("author", length = 50)
    var annotation = varchar("annotation", length = 500)
    var quantity = integer("quantity")
}