package `object`

import org.jetbrains.exposed.sql.Table

object ReaderLendedBooks: Table("reader_books") {
    val reader = reference("reader", Readers)
    val lendedBooks = reference("debtor", LendedBooks)
    override val primaryKey =  PrimaryKey(reader,lendedBooks, name = "PK_READER_BOOKS")
}