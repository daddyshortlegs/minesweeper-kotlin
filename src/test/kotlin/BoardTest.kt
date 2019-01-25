import org.junit.Assert.assertEquals
import org.junit.Test

class BoardTest {

    @Test
    fun shouldConvertStringToArray() {
        val input = "*.\n" +
                "..\n"

        val board = Board(input)
        print(board)
    }


    @Test
    fun calculateValue() {
        val board = Board(".*.")
        val result = board.calculateAtPoint(charArrayOf('.', '*', '.', '*'), 2)
        assertEquals(2, result)
    }

    @Test
    fun calculateValueOnLeftBounds() {
        val board = Board(".*.")
        val result = board.calculateAtPoint(charArrayOf('.', '*', '.', '*'), 0)
        assertEquals(1, result)
    }

    @Test
    fun calculateValueOnRightBounds() {
        val board = Board(".*.")
        val result = board.calculateAtPoint(charArrayOf('.', '*', '*', '.'), 3)
        assertEquals(1, result)
    }

    @Test
    fun countLineBelow() {
        val input = "*...\n" +
                "....\n" +
                "*...\n" +
                "....\n"

        val board = Board(input)
        val result = board.countBelow(1, 0)

        assertEquals(0, result)
    }

    @Test
    fun countLineBelowAgain() {
        val input = "....\n" +
                "***.\n" +
                "*...\n" +
                "....\n"

        val board = Board(input)
        val result = board.countBelow(1, 0)

        assertEquals(3, result)
    }

}