val library_version: String by extra
val kotlin_version = extra["kotlin.version"] as String

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
    id("kotlin-parcelize")
}

kotlin {
    android()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material3)
                api("com.arkivanov.essenty:parcelable:0.10.0")
                implementation("org.jetbrains.compose.components:components-resources:1.4.0-alpha01-dev942")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.jrte"
    compileSdk = 33
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
}
dependencies {
    implementation("androidx.compose.ui:ui-text:1.3.3")
    implementation("androidx.compose.ui:ui-unit:1.3.3")
}
