class Minesweeper(val input: String) {
    fun execute(): String {
        val boardReader = BoardReader()
        val boards = boardReader.readBoards(input)
        return generateOutput(boards)
    }

    private fun generateOutput(boards: List<Board>): String {
        var result = ""
        var index = 1
        for (board in boards) {
            if (index > 1) { result += "\n" }
            result += "Field #$index:\n"
            result += board.generate()
            index++
        }
        return result
    }
}
