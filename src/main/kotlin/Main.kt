package org.example

fun minimumPath(triangle: List<List<Int>>): Int {
    val n = triangle.size
    val lastRow = IntArray(n)

    for (i in 0 until n) {
        lastRow[i] = triangle[n - 1][i]
    }

    for (row in n - 2 downTo 0) {
        for (column in 0..row) {
            lastRow[column] = minOf(lastRow[column], lastRow[column + 1]) + triangle[row][column]
        }
    }

    return lastRow[0]
}

fun main() {
    getData().forEach { triangle ->
        val result = minimumPath(triangle)
        println("Result: $result")
    }
}

fun getData() =
    listOf(
        listOf(
            listOf(2),
            listOf(3, 4),
            listOf(6, 5, 7),
            listOf(4, 1, 8, 3)
        ),

        listOf(
            listOf(2),
            listOf(4, 3),
            listOf(6, 5, 2),
            listOf(4, 1, 8, 3)
        ),

        listOf(
            listOf(2),
            listOf(4, 5),
            listOf(7, 5, 6),
            listOf(4, 7, 8, 5)
        ),

        listOf(
            listOf(2),
            listOf(4, 5),
            listOf(5, 7, 6),
            listOf(7, 4, 8, 5)
        )
    )