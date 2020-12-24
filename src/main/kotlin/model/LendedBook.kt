package model

import `object`.LendedBooks
import `object`.ReaderLendedBooks
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class LendedBook(
        id: EntityID<Int>
): IntEntity(id) {
    companion object : IntEntityClass<LendedBook>(LendedBooks)
    var deadlineCount by LendedBooks.deadlineCount

    //var reader by Reader referencedOn LendedBooks.reader
    var reader by Reader via ReaderLendedBooks
    var book by  Book referencedOn LendedBooks.book

}