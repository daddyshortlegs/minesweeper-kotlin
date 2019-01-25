class Minesweeper(val input: String) {
    fun execute(): String {
        val board = Board(input)
        return board.generate()
    }
}
