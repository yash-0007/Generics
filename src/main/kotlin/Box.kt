class Box<T : Comparable<T>> {
    var partitions: MutableMap<String, T?> = mutableMapOf(
        "top" to null,
        "middle" to null,
        "bottom" to null,
    )

    fun getObject(partition: String): T? {
        return partitions[partition]
    }

    fun putObject(partition: String, item: T) {
        partitions[partition] = item
    }

    fun removeObject(partition: String) {
        partitions[partition] = null
    }

    operator fun iterator(): Iterator<T?> {
        return partitions.values.iterator()
    }

    fun sortObjects() {
        val sortedPartitions = partitions.toList().sortedBy { it.second }.toMap()
        putObject("top", sortedPartitions.values.elementAt(0)!!)
        putObject("middle", sortedPartitions.values.elementAt(1)!!)
        putObject("bottom", sortedPartitions.values.elementAt(2)!!)
    }
}
