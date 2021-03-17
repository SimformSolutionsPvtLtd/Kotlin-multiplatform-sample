import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.RepositoryHandler
import java.net.URI

/**
 * Extension to add file tree dependency
 */
fun Project.defaultFileTree() = fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar")))

/**
 * Adds preference maven repository.
 */
fun RepositoryHandler.jitpack() = maven { url = URI(Urls.JITPACK) }
