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
                val c = if (name[0] == '[') ']' else '.'
                val firstIndex = name.indexOf(c, 0)

                var id: String
                var title: String = name.substring(firstIndex+1, name.length-3)


                if (c == '.') { // coding in VS-Code
                    id = name.substring(0, firstIndex)
                } else {        // coding in IDEA
                    id = name.substring(1, firstIndex)
                    title = title.toLowerCase().split(' ').joinToString("-")
                    f.renameTo(File("./$filename/${id}.${title}.${f.extension}"))
                }
                val leetcodeLink = "[$title](https://leetcode.com/problems/$title/description/)"
                readmeContents.add(
                    Pair(
                        id.toInt(),
                        "| $id | $leetcodeLink | [$ext](./$filename/${id}.${title}.${f.extension}) | ${filename.capitalize()} |\n"
                    )
                )
                numOfFiles++
            }
    return numOfFiles
}

var readmeContents = mutableListOf<Pair<Int, String>>()
val easy_problems = readFiles("easy", readmeContents)
val hard_problems = readFiles("hard", readmeContents)
val medium_problems = readFiles("medium", readmeContents)

val file = File("./README.md")

// clear content
file.writeText("# LeetCode\n")

// append content
file.appendText("**Total problems: ${easy_problems+medium_problems+hard_problems}, easy: ${easy_problems}, medium: ${medium_problems}, hard: ${hard_problems}**\n")
file.appendText("| # | Title | Solution | Difficulty |\n")
file.appendText("| ------ | ------ | ------ | ------ |\n")

readmeContents.sortBy( { it.first } )
readmeContents.forEach {
    file.appendText(it.second)
}
