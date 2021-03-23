class Node constructor(_name: String){
    var connected = ArrayList<Node>()        // 해당 노드와 연결된 노드들을 담아놓은 ArrayList
    val name: String = _name                 // 노드의 이름

    // Node 사이의 edge를 생성한다.
    fun connectNode(node: Node) {
        connected.add(node)
    }

    // Node와 연결된 Node들을 출력한다.
    fun showConnectedList() {
        println("-----Start------\n" + name + " is connected with ... ")
        for(node in connected) {
            print(node.name + ' ')
        }
        println("\n--------End--------")
    }

    fun getConnectedNodes(): ArrayList<Node> {
        return connected
    }
}