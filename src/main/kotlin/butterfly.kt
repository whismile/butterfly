fun main() {
    val graph: BipartiteGraph = BipartiteGraph()
    val driver = FileDriver()
    driver.initGraph(graph, "test.txt")
    println(graph.getButterfly())
}