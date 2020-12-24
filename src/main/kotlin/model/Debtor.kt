package model

import `object`.*
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Debtor(
        id: EntityID<Int>
): IntEntity(id) {
    companion object : IntEntityClass<Debtor>(Debtors)
    var sumBooks by Debtors.sumBooks
    var fine by Debtors.fine
    var reader by Reader via ReaderDebtor
}