object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        var left = 0
        var right = list.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            val midValue = list[mid]

            when {
                midValue == item -> return mid
                midValue < item -> left = mid + 1
                else -> right = mid - 1
            }
        }

        throw NoSuchElementException("Item not found")
    }
}
