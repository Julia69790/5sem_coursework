import `object`.*
import model.*
//import objects.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.SizedCollection
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.Test
import kotlin.test.assertEquals


class MainTest {

   /* fun init() {
        val lib = Librarian.new {
            this.name = "Julia"
        }
    }*/

    @Test
    fun addBookTest() {
        Database.connect(
                "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
                driver = "org.h2.Driver"
        )
        transaction {
            SchemaUtils.create(Books, Debtors, LendedBooks, Librarians, ReaderDebtor, ReaderLendedBooks, Readers)
            val lib = Librarian.new {
                this.name = "Julia"
            }
            lib.addBook("1984","Джордж Оруэлл", "dshbfcnfasczjvc", 10)
            assertEquals("1984", Book.all().find{it.author == "Джордж Оруэлл"}?.title)
            SchemaUtils.drop(Books, Debtors, LendedBooks, Librarians, ReaderDebtor, ReaderLendedBooks, Readers)
        }
    }

    @Test
    fun addLendedBookTest() {
        Database.connect(
                "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
                driver = "org.h2.Driver"
        )
        transaction {
            SchemaUtils.create(Books, Debtors, LendedBooks, Librarians, ReaderDebtor, ReaderLendedBooks, Readers)
            val lib = Librarian.new {
                this.name = "Julia"
            }
            val reader = Reader.new {
                this.name = "Anna"
            }
            lib.addBook("1984", "Джордж Оруэлл", "dshbfcnfasczjvc", 10)
            reader.addLendedBook(12, Book.all().find { it.title == "1984" }!!)
            assertEquals(12, LendedBook[1].deadlineCount)
            SchemaUtils.drop(Books, Debtors, LendedBooks, Librarians, ReaderDebtor, ReaderLendedBooks, Readers)
        }
    }

    @Test
    fun addDebtorTest(){
        Database.connect(
                "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
                driver = "org.h2.Driver"
        )
        transaction {
            SchemaUtils.create(Books, Debtors, LendedBooks, Librarians, ReaderDebtor, ReaderLendedBooks, Readers)
            val lib = Librarian.new {
                this.name = "Julia"
            }
            val reader = Reader.new {
                this.name = "Anna"
            }
            lib.addBook("1984", "Джордж Оруэлл", "dshbfcnfasczjvc", 10)
            reader.addLendedBook(-1, Book.all().find { it.title == "1984" }!!)
            reader.addDebtor(LendedBook.all().find{it.deadlineCount==-1}!!, 3, 2)
            assertEquals(6, Debtor.all().find { it.sumBooks == 3 }?.fine)
            SchemaUtils.drop(Books, Debtors, LendedBooks, Librarians, ReaderDebtor, ReaderLendedBooks, Readers)
        }
    }


}
