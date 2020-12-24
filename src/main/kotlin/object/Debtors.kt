package `object`

import model.LendedBook
import org.jetbrains.exposed.dao.id.IntIdTable

object Debtors: IntIdTable() {
    var sumBooks = integer("sumBooks")
    var fine = integer ("fine")

}