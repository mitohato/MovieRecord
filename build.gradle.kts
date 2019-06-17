// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    val kotlinVersion by extra("1.3.31")
    val retrofitVersion by extra("2.3.0")
    val coroutineVersion by extra("1.2.0")
    val roomVersion by extra("1.1.1")
    val navigationVersion by extra("1.0.0-rc02")
    val moshiVersion by extra("1.5.0")
    val koinVersion by extra("2.0.0-rc-2")
    val groupieVersion by extra("2.3.0")

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("android.arch.navigation:navigation-safe-args-gradle-plugin:$navigationVersion")
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
