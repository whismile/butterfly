import java.io.File
import java.io.FileReader
import java.nio.charset.Charset
import java.util.StringTokenizer

class FileDriver {
    fun initGraph(graph: BipartiteGraph, _file: String) {
        val path = System.getProperty("user.dir")
        val file = File(path + "/src/main/kotlin/" + _file)
        val reader = FileReader(file)

        val line = reader.readText().split("\n")
        graph.setLeftSide(ArrayList(line[0].split(" ").map { Node(it) }))
        graph.setRightSide(ArrayList(line[1].split(" ").map { Node(it) }))

        for (ln in line.subList(3, line.lastIndex)) {
            
        }
    }
}