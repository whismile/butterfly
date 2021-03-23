fun main() {
    val graph: BipartiteGraph = BipartiteGraph()
    val driver = FileDriver()
    driver.initGraph(graph, "dbpedia.tsv")
    graph.showInfo()
    graph.showMaxLeftDegreesInfo()
    graph.showUniqueEdge()
    println(graph.getButterfly())
}