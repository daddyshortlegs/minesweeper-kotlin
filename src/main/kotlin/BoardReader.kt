class BoardReader {

    private val BOARD_DIMENSIONS = Regex("([0-9]) ([0-9])")

    fun readBoards(input: String): List<Board> {
        if (input.isEmpty()) {
            throw NoBoardsException()
        }

        val lines = cleanUpInput(input)
        return createBoards(lines)
    }

    private fun cleanUpInput(input: String): List<String> {
        val trimEnd = input.trimEnd('\n')
        return trimEnd.split("\n")
    }

    private fun createBoards(lines: List<String>): ArrayList<Board> {
        var index = 0
        var boards: ArrayList<Board> = ArrayList()

        do {
            val height = readDimensions(lines[index])
            if (height == 0) return boards
            index++
            val board = readBoard(index, height, lines)
            index += height

            boards.add(board)
        } while (index < lines.size)
        return boards
    }


    private fun readDimensions(line: String): Int {
        if (BOARD_DIMENSIONS.matches(line)) {
            val result = BOARD_DIMENSIONS.find(line)
            if (result != null) {
                var (height, _) = result.destructured
                return height.toInt()
            }
        }
        return 0
    }

    private fun readBoard(index: Int, height: Int, lines: List<String>): Board {
        var board = ""
        for (i in index until index + height) {
            board += lines[i] + "\n"
        }

        return Board(board)
    }
}

