package model

import `object`.Librarians
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Librarian(
        id: EntityID<Int>
): IntEntity(id) {
    companion object : IntEntityClass<Librarian>(Librarians)
    var name by Librarians.name

    fun addBook( title:String,author: String, annotation: String,quantity:Int){
        val book = Book.new{
            this.title = title
            this.author = author
            this.annotation = annotation
            this.quantity = quantity
        }
    }


    fun addReader (name:String){
        val reader = Reader.new{
            this.name = name
            //this.phoneNumber = phoneNumber
        }
    }

    /*fun addDebtors(reader: Reader,fineInDay: Int ){
        val needBack = reader.lendedBook.mapNotNull{
                    if(it.deadlineCount<=0)
                        it
                    else
                       null
                }
        needBack.map{
            val debtor = Debtor.new{
                this.sumBooks = it.reader
            }
        }
    }*/
}