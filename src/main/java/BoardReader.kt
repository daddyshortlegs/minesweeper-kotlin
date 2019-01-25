data class Dimensions(val width: Int, val height: Int)


class BoardReader {
    fun read(input: String): Board {
        if (input.isEmpty()) {
            throw NoBoardsException()
        }

        val trimEnd = input.trimEnd('\n')
        val lines = trimEnd.split("\n")


        var index = 0

        val line = lines[index]

        val (width, height) = readDimensions(line)
        index++

        var board = ""
        for (i in index until index + height) {
            board += lines[i] + "\n"
            index++
        }

        println("board = $board")

        return Board(board)
    }

    private fun readDimensions(line: String): Dimensions {
        val regex = Regex("([0-9]) ([0-9])")
        if (regex.matches(line)) {
            // is header
            val result = regex.find(line)
            if (result != null) {
                var (width, height) = result.destructured
                return Dimensions(Integer.parseInt(width), Integer.parseInt(height))
            }
        }
        return Dimensions(0, 0)
    }

}

