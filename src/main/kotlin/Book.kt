data class Book(val bookName: String, val numberOfPages: Int) : Comparable<Book> {
    override fun compareTo(other: Book): Int {
        return numberOfPages.compareTo(other.numberOfPages)
    }
}
