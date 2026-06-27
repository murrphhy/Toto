rootProject.name = "Toto"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    // Permite que Gradle descargue automáticamente el JDK que pide jvmToolchain(...) del server
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
    versionCatalogs {
        // Catálogo oficial de Ktor que usa el módulo :server (referenciado como ktorLibs.*)
        create("ktorLibs").from("io.ktor:ktor-version-catalog:3.5.0")
    }
}

include(":androidApp")
include(":shared")
include(":server")