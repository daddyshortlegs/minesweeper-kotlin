class Minesweeper(val input: String) {
    fun execute(): String {

        BoardReader()



        val board = Board(input)
        return board.generate()
    }
}
