class Minesweeper(val input: String) {
    fun play(): String {
        val boardReader = BoardReader()
        val boards = boardReader.readBoards(input)
        return generateOutput(boards)
    }

    private fun generateOutput(boards: List<Board>): String {
        var result = ""
        var index = 1
        for (board in boards) {
            if (index > 1) { result += "\n" }
            result += generateSingleBoard(index++, board)
        }
        return result
    }

    private fun generateSingleBoard(index: Int, board: Board): String {
        return "Field #$index:\n${board.generate()}"
    }
}
