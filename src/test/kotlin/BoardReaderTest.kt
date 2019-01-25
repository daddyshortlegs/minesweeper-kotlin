import org.junit.Assert.*
import org.junit.Test

class BoardReaderTest {

    @Test(expected=NoBoardsException::class)
    fun `should throw error if no input`() {
        val boardReader = BoardReader()
        boardReader.readBoards("")
    }

    @Test
    fun `should read board of 4 by 4 dimensions`() {
        val boardReader = BoardReader()

        val expectedBoard = "*...\n" +
                "....\n" +
                ".*..\n" +
                "....\n"

        val input = "4 4\n" + expectedBoard

        var board = boardReader.readBoards(input)

        assertEquals(expectedBoard, board[0].toString())
    }

    @Test
    fun `should read board of 3 by 5 dimensions`() {
        val boardReader = BoardReader()

        val expectedBoard = "*..\n" +
                "...\n" +
                ".*.\n" +
                "...\n" +
                ".*.\n"

        val input = "3 5\n" + expectedBoard

        var board = boardReader.readBoards(input)

        assertEquals(expectedBoard, board[0].toString())
    }


    @Test
    fun `should read 2 boards`() {
        val boardReader = BoardReader()

        val board1 = "*...\n" +
                "....\n" +
                ".*..\n" +
                "....\n"

        val board2 = "*..\n" +
                "...\n" +
                ".*.\n" +
                "...\n" +
                ".*.\n"

        val input = "4 4\n" + board1 +
                "3 5\n" + board2

        val boards = boardReader.readBoards(input)

        assertFalse(boards.isEmpty())
        assertEquals(2, boards.size)
        assertEquals(board1, boards[0].toString())
        assertEquals(board2, boards[1].toString())

    }



}