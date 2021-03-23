class BipartiteGraph {
    private var leftside: ArrayList<Node> = ArrayList<Node>()
    private var rightside: ArrayList<Node> = ArrayList<Node>()

    fun showLeftSide() {
        for (node in leftside) {
            println(node.name)
        }
    }

    fun showRightSide() {
        for (node in rightside) {
            println(node.name)
        }
    }

    fun getButterfly() : Int {
        var butterflyCount: Int = 0
        selectPivotGraph()

        for (target in leftside) {
            val counting: HashMap<Node, Int> = HashMap<Node, Int>()
            for (neighbor in target.getConnectedNodes()) {
                for (twoNeighbor in neighbor.getConnectedNodes().filter { it != target }) {
                    if (!counting.containsKey(twoNeighbor)) {
                        counting[twoNeighbor] = 1
                    }

                    else {
                        val temp: Int = counting.getValue(twoNeighbor)
                        counting[twoNeighbor] = temp + 1
                    }
                }

            }

            var sum: Int = 0
            //println(target.name + counting.values)

            for (iter in counting.values.filter { it >= 2 }) {
                sum += combination(iter, 2)
            }

            butterflyCount += sum
            counting.clear()
        }

        return butterflyCount / 2
    }

    private fun combination(n: Int, r: Int): Int {
        return if (n == r || r == 0) 1 else combination(n - 1, r - 1) + combination(n - 1, r)
    }

    private fun selectPivotGraph() {
        var leftDegrees: Int = 0
        var rightDegrees: Int  = 0

        for (i in leftside) {
            val count = i.connected.count()
            leftDegrees += count * count
        }

        for (i in rightside) {
            val count = i.connected.count()
            rightDegrees += count * count
        }
        /*
        println("Left Side: $leftDegrees")
        println("rightDegrees: $rightDegrees")
        */
        if (leftDegrees < rightDegrees) {
            val tmp: ArrayList<Node> = leftside
            leftside = rightside
            rightside = tmp
        }
    }

    fun setLeftSide(left: ArrayList<Node>) {
        leftside = left
    }

    fun setRightSide(right: ArrayList<Node>) {
        rightside = right
    }

    fun showInfo() {
        for (n in leftside) {
            n.showConnectedList()
        }
    }

    fun showMaxLeftDegreesInfo() {
        var leftMax = 0
        var rightMax = 0

        for (node in leftside) {
            val tmp = node.connected.count()
            if (tmp > leftMax) {
                leftMax = tmp
            }
        }

        for (node in rightside) {
            val tmp = node.connected.count()
            if (tmp > rightMax) {
                rightMax = tmp
            }
        }

        println("Left Max Degree: $leftMax")
        println("Right Max Degree: $rightMax")
    }

    fun showUniqueEdge() {
        var sum = 0
        for (node in leftside) {
            sum += node.connected.count()
        }

        println("Unique edge count: $sum")
    }
}