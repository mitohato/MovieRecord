import org.jetbrains.kotlin.gradle.dsl.Coroutines

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("androidx.navigation.safeargs")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.ict.mito.movierecord"
        minSdkVersion(22)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    dataBinding.isEnabled = true
}

dependencies {
    implementation(fileTree(mapOf(
        "dir" to ("libs"),
        "include" to listOf("*.jar")
    )))

    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    val kotlinVersion: String? by project
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion")

    implementation("androidx.appcompat:appcompat:1.1.0-beta01")
    implementation("androidx.core:core-ktx:1.2.0-alpha02")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.cardview:cardview:1.0.0")

    val moshiVersion: String? by project
    implementation("com.squareup.moshi:moshi:$moshiVersion")
    implementation("com.squareup.moshi:moshi-kotlin:$moshiVersion")

    //    navigation
    val navigationVersion: String? by project
    implementation("android.arch.navigation:navigation-common-ktx:$navigationVersion")
    implementation("android.arch.navigation:navigation-fragment:$navigationVersion")
    implementation("android.arch.navigation:navigation-ui:$navigationVersion")
    implementation("android.arch.navigation:navigation-fragment-ktx:$navigationVersion")
    implementation("android.arch.navigation:navigation-ui-ktx:$navigationVersion")

    //    lifecycle
    implementation("androidx.lifecycle:lifecycle-extensions:2.0.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.0.0")

    //    Retrofit
    val retrofitVersion: String? by project
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-moshi:$retrofitVersion")
    implementation("com.squareup.okhttp3:okhttp:3.10.0")

    //    room
    val roomVersion: String? by project
    implementation("android.arch.persistence.room:runtime:$roomVersion")
    implementation("android.arch.persistence.room:rxjava2:1.1.1")
    kapt("android.arch.persistence.room:compiler:$roomVersion")
    androidTestImplementation("android.arch.persistence.room:testing:$roomVersion")

//    Koin
    val koinVersion: String? by project
//    Koin for Android
    implementation("org.koin:koin-android:$koinVersion")
//    AndroidX (based on koin-android)
//    Koin AndroidX Scope feature
    implementation("org.koin:koin-androidx-scope:$koinVersion")
//    Koin AndroidX ViewModel feature
    implementation("org.koin:koin-androidx-viewmodel:$koinVersion")

    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test:runner:1.2.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")

    val groupieVersion: String? by project
    implementation("com.xwray:groupie:$groupieVersion")
    implementation("com.xwray:groupie-databinding:$groupieVersion")
}

kotlin { // type is KotlinJvmProjectExtension
    experimental.coroutines = Coroutines.ENABLE
}
