import java.io.File

fun readFiles(filename: String, readmeContents: MutableList<Pair<Int, String>>): Int { 
    val easyFolder = File("./${filename}").walk()
    var numOfFiles = 0
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
                readmeContents.add(Pair(id.toInt(), "| $id | $leetcodeLink | [$ext]($f) | ${filename.capitalize()} |\n"))
                numOfFiles++
            }
    return numOfFiles
}

var readmeContents = mutableListOf<Pair<Int, String>>()

val leetcodeFolder = File("./").walk()
leetcodeFolder.maxDepth(1)
            .filter { it.isFile }
            .filter { it.extension == "jar" }
            .forEach {
                try {
                    it.deleteRecursively()
                } catch(e: Exception) {
                    println("删除失败：  ${it.absolutePath}")  
                }
            }

val easy_problems = readFiles("easy", readmeContents)

val hard_problems = readFiles("hard", readmeContents)
val medium_problems = readFiles("medium", readmeContents)

val file = File("./README.md")
file.appendText("# LeetCode\n")
file.appendText("**Total problems: ${easy_problems+medium_problems+hard_problems}, easy: ${easy_problems}, medium: ${medium_problems}, hard: ${hard_problems}**\n")
file.appendText("| # | Title | Solution | Difficulty |\n")
file.appendText("| ------ | ------ | ------ | ------ |\n")

readmeContents.sortBy( { it.first } )
readmeContents.forEach {
    file.appendText(it.second)
}
