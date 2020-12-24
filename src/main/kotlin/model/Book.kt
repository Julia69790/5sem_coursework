package model

import `object`.Books
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Book (
        id: EntityID<Int>
): IntEntity(id){
    companion object : IntEntityClass<Book>(Books)
    var title by Books.title
    var author by Books.author
    var annotation by Books.annotation
    var quantity by Books.quantity
}