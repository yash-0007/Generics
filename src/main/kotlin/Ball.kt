data class Ball(val color: String, val size: String) : Comparable<Ball> {
    override fun compareTo(other: Ball): Int {
        return size.compareTo(other.size)
    }
}
