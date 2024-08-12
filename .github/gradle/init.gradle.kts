import org.gradle.github.GitHubDependencyGraphPlugin

initscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("org.gradle:github-dependency-graph-gradle-plugin:1.3.0")
    }
}

apply<GitHubDependencyGraphPlugin>()