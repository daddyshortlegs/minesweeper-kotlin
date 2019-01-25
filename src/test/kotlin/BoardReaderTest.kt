import org.junit.Assert.*
import org.junit.Test

class BoardReaderTest {

    @Test(expected=NoBoardsException::class)
    fun `should throw error if no input`() {
        val boardReader = BoardReader()
        boardReader.read("")
    }

    @Test
    fun `should read board of 4 by 4 dimensions`() {
        val boardReader = BoardReader()

        val expectedBoard = "*...\n" +
                "....\n" +
                ".*..\n" +
                "....\n"

        val input = "4 4\n" + expectedBoard

        var board: Board = boardReader.read(input)

        assertEquals(expectedBoard, board.toString())
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

        var board: Board = boardReader.read(input)

        assertEquals(expectedBoard, board.toString())
    }


//    @Test
//    fun `should return 4 by 4 dimensions`() {
//        val boardReader = BoardReader()
//
//        val input = "4 4\n" +
//                "*...\n" +
//                "....\n" +
//                ".*..\n" +
//                "...."
//        val (width, height) = boardReader.readDimensions(input)
//
//        assertEquals(4, width)
//        assertEquals(4, height)
//    }



}