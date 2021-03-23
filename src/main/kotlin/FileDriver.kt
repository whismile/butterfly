import java.io.File
import java.io.FileReader
import java.nio.charset.Charset
import java.util.StringTokenizer
import kotlin.collections.Set as Set


class FileDriver {
    fun initGraph(graph: BipartiteGraph, _file: String) {
        val dataSetPath = "/home/tassway/Downloads/"
        val file = File(dataSetPath + _file)
        val reader = FileReader(file)

        var inNodesLeft = HashMap<Int, Node>()
        var inNodesRight = HashMap<Int, Node>()

        //TSV 파일을 읽어온다. 줄 단위로 나누어진 리스트를 생성
        var lines = reader.readText().split("\n")
        for (ln in lines) {
            var st = StringTokenizer(ln);
            if (!st.hasMoreTokens()) {
                break;
            }
            println(ln)
            val u = st.nextToken().toInt();
            val v = st.nextToken().toInt();

            //왼쪽노드 생성
            if (!inNodesLeft.containsKey(u)) {
                inNodesLeft[u] = Node('A' + u.toString())
            }
            //오른쪽 노드 생
            if (!inNodesRight.containsKey(v)) {
                inNodesRight[v] = Node('B' + v.toString())
            }

            if (!inNodesLeft.getValue(u).connected.contains(inNodesRight.getValue(v))) {
                //노드끼리 연결
                inNodesLeft.getValue(u).connectNode(inNodesRight.getValue(v))
                inNodesRight.getValue(v).connectNode(inNodesLeft.getValue(u))
            }
        }
        // 왼쪽 그룹과 오른쪽 그룹을 Setting
        graph.setLeftSide(ArrayList(inNodesLeft.values))
        graph.setRightSide(ArrayList(inNodesRight.values))
    }
}