import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BoxTest {
    @Test
    fun `it should put object in the box`() {
        val book = Book("The Wings of Fire", 180)
        val box = Box<Book>()

        box.putObject("top", book)

        assertEquals(book, box.partitions["top"])
    }

    @Test
    fun `it should get object from the box`() {
        val book = Book("The Wings of Fire", 180)
        val box = Box<Book>()

        box.putObject("top", book)
        val obj = box.getObject("top")

        assertEquals(book, obj)
    }

    @Test
    fun `it should remove object from the box`() {
        val book = Book("The Wings of Fire", 180)
        val box = Box<Book>()

        box.putObject("top", book)
        box.removeObject("top")

        assertEquals(null, box.partitions["top"])
    }

    @Test
    fun `it should iterate objects in the box`() {
        val bookTop = Book("Atomic Habits", 320)
        val bookMiddle = Book("The Secret", 198)
        val bookBottom = Book("The Wings of Fire", 180)
        val box = Box<Book>()

        box.putObject("top", bookTop)
        box.putObject("middle", bookMiddle)
        box.putObject("bottom", bookBottom)

        val iteratedItems = mutableListOf<Book?>()
        for (item in box) {
            iteratedItems.add(item)
        }

        assertEquals(iteratedItems, mutableListOf<Book?>(bookTop, bookMiddle, bookBottom))
    }

    @Test
    fun `it should sort books in the box`() {
        val bookTop = Book("Atomic Habits", 320)
        val bookMiddle = Book("The Secret", 198)
        val bookBottom = Book("The Wings of Fire", 180)
        val box = Box<Book>()

        box.putObject("top", bookTop)
        box.putObject("middle", bookMiddle)
        box.putObject("bottom", bookBottom)

        box.sortObjects()

        assertEquals(bookBottom, box.partitions["top"])
        assertEquals(bookMiddle, box.partitions["middle"])
        assertEquals(bookTop, box.partitions["bottom"])
    }

    @Test
    fun `it should sort balls in the box`() {
        val ballTop = Ball("Red", "S")
        val ballMiddle = Ball("Green", "M")
        val ballBottom = Ball("Black", "L")
        val box = Box<Ball>()

        box.putObject("top", ballTop)
        box.putObject("middle", ballMiddle)
        box.putObject("bottom", ballBottom)

        box.sortObjects()

        assertEquals(ballBottom, box.partitions["top"])
        assertEquals(ballMiddle, box.partitions["middle"])
        assertEquals(ballTop, box.partitions["bottom"])
    }
}
