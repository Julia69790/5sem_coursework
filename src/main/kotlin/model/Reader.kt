package model

import `object`.ReaderDebtor
import `object`.ReaderLendedBooks
import `object`.Readers
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.SizedCollection

class Reader(
        id: EntityID<Int>
): IntEntity(id)  {
    companion object : IntEntityClass<Reader>(Readers)
    var name by  Readers.name
    //var phoneNumber by Readers.phoneNumber

    var lendedBooks by LendedBook via ReaderLendedBooks
    var debtors by Debtor via ReaderDebtor

    fun addLendedBook(deadlineCount:Int,book: Book){
        val lendedBook = LendedBook.new{
            this.deadlineCount = deadlineCount
            this.book = book
        }
        this.lendedBooks = SizedCollection(lendedBooks + listOf(lendedBook))
    }

    fun addDebtor(lendedBook:LendedBook, sumBooks: Int, fineInDay: Int){
        if(lendedBook.deadlineCount<0) {
            val debtor = Debtor.new {
                this.sumBooks = sumBooks
                this.fine = sumBooks * (0-lendedBook.deadlineCount)*fineInDay
                this.reader = lendedBook.reader
            }
            this.debtors = SizedCollection(debtors + listOf(debtor ))
        }

    }
}