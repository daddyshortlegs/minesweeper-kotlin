class Board(private val input: String) {
    init {
        convertToArray()
    }

    private var size: Int = 0

    private lateinit var board: Array<CharArray>

    private fun convertToArray() : Array<CharArray> {
        val trimEnd = input.trimEnd('\n')
        val lines = trimEnd.split("\n")
        size = lines.size
        board = Array(size, {CharArray(size)})

        for (i in 0 until size) {
            for (j in 0 until size) {
                board[i][j] = lines[i][j]
            }
        }

        return board
    }

    override fun toString(): String {
        var result = ""
        for (i in 0 until size) {
            for (j in 0 until size) {
                result += board[i][j]
            }
            result += "\n"
        }

        return result
    }

    fun calculateAtPoint(boardArray: CharArray, i: Int) : Int {
        var count = 0

        if (i > 0) {
            val pointLeft = boardArray[i - 1]
            if (pointLeft == '*') {
                count++
            }
        }

        if (i < boardArray.size - 1) {
            val pointRight = boardArray[i + 1]
            if (pointRight == '*') {
                count++
            }
        }

        return count
    }

    fun countBelow(x: Int, y: Int): Int {
        return countRow(x, y + 1)
    }

    fun countAbove(x: Int, y: Int): Int {
        return countRow(x, y - 1)
    }

    private fun countRow(x: Int, row: Int): Int {
        if (row < 0) return 0
        if (row >= board.size) return 0

        var startX = x - 1
        var endX = startX + 3
        if (x == 0) {
            startX = 0
            endX = startX + 2
        }

        if (endX >= board[row].size) {
            endX = board[row].size - 1
        }

        var count = 0

        for (i in startX until endX) {
            if (board[row][i] == '*') {
                count++
            }
        }

        return count
    }

}
