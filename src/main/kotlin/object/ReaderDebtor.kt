package `object`

import org.jetbrains.exposed.sql.Table

object ReaderDebtor: Table("reader=debtor") {
    val reader = reference("reader", Readers)
    val debtor = reference("debtor", Debtors)
    override val primaryKey =  PrimaryKey(debtor,reader, name = "PK_DEBTOR_READER")
}