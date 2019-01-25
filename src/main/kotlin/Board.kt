class Board(private val input: String) {
    init {
        convertToArray()
    }

    var size: Int = 0

    lateinit var board: Array<CharArray>

    fun convertToArray() : Array<CharArray> {
        val trimEnd = input.trimEnd('\n')
        val lines = trimEnd.split("\n")
        size = lines.size
        board = Array(size, {CharArray(size)})

        for (i in 0..size - 1) {
            for (j in 0..(size - 1)) {
                board[i][j] = lines[i][j]
            }
        }

        return board
    }

    override fun toString(): String {
        var result = ""
        for (i in 0..size - 1) {
            for (j in 0..size - 1) {
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
        val rowBelow = y + 1
        val startX = x - 1
        val endX = startX + 3
        var count = 0

        for (i in startX..endX - 1) {
            val c = board[rowBelow][i]
            if (c == '*') {
                count++
            }
        }

        return count
    }

}
