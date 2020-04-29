// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    val kotlinVersion by extra("1.3.40")
    val retrofitVersion by extra("2.6.0")
    val coroutineVersion by extra("1.3.0-M2")
    val roomVersion by extra("2.1.0")
    val navigationVersion by extra("2.1.0-alpha05")
    val moshiVersion by extra("1.8.0")
    val koinVersion by extra("2.0.1")
    val groupieVersion by extra("2.3.0")

    repositories {
        google()
        jcenter()
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:8.2.0")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        
    }
}

tasks.create(
    "clean",
    type = Delete::class
) {
    delete(rootProject.buildDir)
}
