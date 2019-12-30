import java.io.File

fun main(args: Array<String>) {
    val file = File("./README.md")
    file.writeText("# LeetCode\n")
    file.appendText("| # | Title | Solution | Difficulty |\n")
    file.appendText("| ------ | ------ | ------ | ------ |\n")

    var readmeContents = mutableListOf<Pair<Int, String>>()

    val leetcodeFolder = File("./").walk()
    leetcodeFolder.maxDepth(1)
                .filter { it.isFile }
                .filter { it.name != "GenerateReadMe.jar" && it.extension == "jar" }
                .forEach {
                    try {
                        it.deleteRecursively()
                    } catch(e: Exception) {
                        println("删除失败：  ${it.absolutePath}")  
                    }
                }

    val easyFolder = File("./easy").walk()
    easyFolder.maxDepth(1)
            .filter { it.isFile }
            .filter { it.extension == "kt" || it.extension == "cpp"}
            .forEach { f ->
                val ext = if (f.extension == "kt") "Kotlin" else "C++"
                val name = f.name
                val firstDotIndex = name.indexOf('.', 0)
                val id = name.substring(0, firstDotIndex)
                val title = name.substring(firstDotIndex+1, name.length-3)
                val leetcodeLink = "[$title](https://leetcode.com/problems/$title/description/)"
                readmeContents.add(Pair(id.toInt(), "| $id | $leetcodeLink | [$ext]($f) | Easy |\n"))
            }

    val mediumFolder = File("./medium").walk()
    mediumFolder.maxDepth(1)
            .filter { it.isFile }
            .filter { it.extension == "kt" || it.extension == "cpp"}
            .forEach { f ->
                val ext = if (f.extension == "kt") "Kotlin" else "C++"
                val name = f.name
                val firstDotIndex = name.indexOf('.', 0)
                val id = name.substring(0, firstDotIndex)
                val title = name.substring(firstDotIndex+1, name.length-3)
                val leetcodeLink = "[$title](https://leetcode.com/problems/$title/description/)"
                readmeContents.add(Pair(id.toInt(), "| $id | $leetcodeLink | [$ext]($f) | Medium |\n"))
            }

    val hardFolder = File("./hard").walk()
    hardFolder.maxDepth(1)
            .filter { it.isFile }
            .filter { it.extension == "kt" || it.extension == "cpp"}
            .forEach { f ->
                val ext = if (f.extension == "kt") "Kotlin" else "C++"
                val name = f.name
                val firstDotIndex = name.indexOf('.', 0)
                val id = name.substring(0, firstDotIndex)
                val title = name.substring(firstDotIndex+1, name.length-3)
                val leetcodeLink = "[$title](https://leetcode.com/problems/$title/description/)"
                readmeContents.add(Pair(id.toInt(), "| $id | $leetcodeLink | [$ext]($f) | Hard |\n"))
            }
    readmeContents.sortBy( { it.first } )
    readmeContents.forEach {
        file.appendText(it.second)
    }
}
