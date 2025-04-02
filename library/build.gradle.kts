import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.vanniktech.mavenPublish)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    `maven-publish` // Add the standard maven-publish plugin
}

group = "io.github.andresarangoa"
version = "0.1.0-beta01" // Using beta version for testing

kotlin {
    // Your existing configuration
    jvm()
    androidTarget {
        publishLibraryVariants("release")
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()


    sourceSets {
        // Your existing dependencies
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.ui)
                implementation(compose.materialIconsExtended)
                implementation(compose.material3)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

android {
    namespace = "io.github.andresarangoa.flowcomponents"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

// Keep vanniktech config for Maven Central (comment out for beta releases)
mavenPublishing {
    // For beta testing, comment these out
    // publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    // signAllPublications()

    coordinates(group.toString(), "flow-components", version.toString())

    pom {
        name = "flow-components"
        description = "A Kotlin Multiplatform UI components library for Compose"
        inceptionYear = "2024"
        url = "https://github.com/andresarangoa/flow-components"
        licenses {
            license {
                name = "XXX"
                url = "YYY"
                distribution = "ZZZ"
            }
        }
        developers {
            developer {
                id = "XXX"
                name = "Andrés Arango"
                url = "ZZZ"
            }
        }
        scm {
            url = "https://github.com/andresarangoa/flow-components"
            connection = "scm:git:git://github.com/andresarangoa/flow-components.git"
            developerConnection = "scm:git:ssh://git@github.com/andresarangoa/flow-components.git"
        }
    }
}

// Add GitHub Packages configuration using standard maven-publish plugin
publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/andresarangoa/flow-components")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}