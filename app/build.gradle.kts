import org.jetbrains.kotlin.gradle.dsl.Coroutines

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")
    id("org.jlleitschuh.gradle.ktlint")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.ict.mito.movierecord"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField(
            "String",
            "MOVIE_DB_BASE_URL",
            System.getProperty("movie_db_base_url")
        )
        buildConfigField(
            "String",
            "MOVIE_DB_IMAGE_BASE_URL",
            System.getProperty("movie_db_image_base_url")
        )
        buildConfigField(
            "String",
            "MOVIE_DB_API_KEY_V3",
            System.getProperty("movie_db_api_key_v3")
        )
        buildConfigField(
            "String",
            "MOVIE_DB_API_KEY_V4",
            System.getProperty("movie_db_api_key_v4")
        )
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
    implementation(
        fileTree(
            mapOf(
                "dir" to ("libs"),
                "include" to listOf("*.jar")
            )
        )
    )

    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    val kotlinVersion: String? by project
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion")

    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.core:core-ktx:1.5.0-alpha01")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.cardview:cardview:1.0.0")

    val moshiVersion: String? by project
    implementation("com.squareup.moshi:moshi:$moshiVersion")
    implementation("com.squareup.moshi:moshi-kotlin:$moshiVersion")
    implementation("com.squareup.moshi:moshi-adapters:$moshiVersion")

    //    navigation
    val navigationVersion: String? by project
    implementation("androidx.navigation:navigation-common-ktx:$navigationVersion")
    implementation("androidx.navigation:navigation-fragment-ktx:$navigationVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navigationVersion")

    //    lifecycle
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")

    //    Retrofit
    val retrofitVersion: String? by project
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-moshi:$retrofitVersion")
    implementation("com.squareup.okhttp3:okhttp:3.14.1")
    implementation("com.squareup.okhttp3:logging-interceptor:3.11.0")

    //    room
    val roomVersion: String? by project
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-rxjava2:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    androidTestImplementation("androidx.room:room-testing:$roomVersion")

//    Koin
    val koinVersion: String? by project
//    Koin for Android
    implementation("org.koin:koin-android:$koinVersion")
//    AndroidX (based on koin-android)
//    Koin AndroidX Scope feature
    implementation("org.koin:koin-androidx-scope:$koinVersion")
//    Koin AndroidX ViewModel feature
    implementation("org.koin:koin-androidx-viewmodel:$koinVersion")

    testImplementation("junit:junit:4.13")
    androidTestImplementation("androidx.test:runner:1.2.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")

    val groupieVersion: String? by project
    implementation("com.xwray:groupie:$groupieVersion")
    implementation("com.xwray:groupie-databinding:$groupieVersion")

    implementation("com.squareup.picasso:picasso:2.71828")

    //    Rx
    implementation("io.reactivex.rxjava2:rxjava:2.2.14")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxkotlin:2.2.0")

    debugImplementation("com.willowtreeapps.hyperion:hyperion-core:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-attr:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-build-config:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-crash:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-disk:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-geiger-counter:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-measurement:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-phoenix:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-recorder:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-shared-preferences:0.9.27")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-timber:0.9.27")
}

kotlin {
    // type is KotlinJvmProjectExtension
    experimental.coroutines = Coroutines.ENABLE
}

ktlint {
    version.set("0.31.0")
    android.set(true)
    reporters.set(setOf(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE))
    ignoreFailures.set(true) // NOTE: エラーで中断させないための設定
}
