package qbit

import org.junit.Test
import qbit.ns.root
import qbit.schema.Attr
import qbit.schema.ScalarAttr

class ValidationTest {

    @Test(expected = QBitException::class)
    fun testUniqueConstraintViolationWithinTrx() {
        val attr = ScalarAttr(root["unique"], QString, true)
        val db = dbOf(attr)
        validate(db, listOf(Fact(EID(0, 0), attr, 0), Fact(EID(0, 1), attr, 0)))
    }
}
