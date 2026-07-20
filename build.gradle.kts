import org.jetbrains.intellij.platform.gradle.TestFrameworkType

plugins {
    id("org.jetbrains.changelog")
    id("org.jetbrains.intellij.platform")
    kotlin("jvm") version "2.4.10"
}

// Read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin.html
dependencies {
    implementation(libs.javafaker)
    testImplementation(libs.junit)

    // IntelliJ Platform Gradle Plugin Dependencies Extension - read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-dependencies-extension.html
    intellijPlatform {
        intellijIdea("2026.2")
        testFramework(TestFrameworkType.Platform)

        // Add plugin dependencies for compilation here, for example:
        // bundledPlugin("com.intellij.java")
    }
    testImplementation(kotlin("test"))
}
repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories() // Pulls necessary releases and dependencies
    }
}
kotlin {
    jvmToolchain(21)
}