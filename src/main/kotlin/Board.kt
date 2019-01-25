class Board(private val input: String) {
    init {
        convertToArray()
    }

    private var height: Int = 0

    private var width: Int = 0

    private lateinit var board: Array<CharArray>

    private fun convertToArray() : Array<CharArray> {
        val trimEnd = input.trimEnd('\n')
        val lines = trimEnd.split("\n")
        height = lines.size
        width = lines[0].length

        board = Array(height, {CharArray(width)})

        for (i in 0 until height) {
            for (j in 0 until width) {
                board[i][j] = lines[i][j]
            }
        }

        return board
    }

    fun generate(): String {
        for (y in 0 until height) {
            for (x in 0 until width) {
                var count = countAbove(x, y)
                count += countBelow(x, y)
                count += countSides(x, y)

                if (board[y][x] != '*') {
                    board[y][x] = convertIntToChar(count)
                }
            }
        }
        return toString()
    }

    fun countAbove(x: Int, y: Int): Int {
        return countRow(x, y - 1)
    }

    fun countBelow(x: Int, y: Int): Int {
        return countRow(x, y + 1)
    }

    private fun countRow(x: Int, row: Int): Int {
        if (row < 0) return 0
        if (row >= height) return 0

        var startX = x - 1
        var endX = startX + 3
        if (x == 0) {
            startX = 0
            endX = startX + 2
        }

        if (endX >= width) {
            endX = width - 1
        }

        return countTheRow(startX, endX, row)
    }

    private fun countTheRow(startX: Int, endX: Int, row: Int): Int {
        var count = 0

        for (i in startX until endX) {
            if (board[row][i] == '*') {
                count++
            }
        }
        return count
    }

    fun countSides(x: Int, y: Int) : Int {
        var count = countLeft(x, y)
        count += countRight(x, y)
        return count
    }

    private fun countLeft(x: Int, y: Int): Int {
        if (x > 0) {
            if (countSide(x - 1, y)) return 1
        }
        return 0
    }

    private fun countRight(x: Int, y: Int): Int {
        if (x < board[y].size - 1) {
            if (countSide(x + 1, y)) return 1
        }
        return 0
    }

    private fun countSide(x: Int, y: Int): Boolean {
        if (board[y][x] == '*') {
            return true
        }
        return false
    }

    fun convertIntToChar(count: Int) = Integer.toString(count).single()

    override fun toString(): String {
        var result = ""
        for (i in 0 until height) {
            for (j in 0 until width) {
                result += board[i][j]
            }
            result += "\n"
        }

        return result
    }

}
