plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.21"  // Specify a version
    id("java-gradle-plugin")
    id("maven-publish")
    id("com.gradle.plugin-publish") version "1.2.1" // Use the latest version
}

group = "com.buzzebees.sdk"
version = "1.0.0"

gradlePlugin {
    vcsUrl.set("https://github.com/BzbsAndroid") // Replace with actual repo
    website.set("https://crm.buzzebees.com/")
    plugins {
        create("services_plugin") {
            id = "com.buzzebees.sdk.services"
            displayName = "Buzzebees Services Plugin"
            description = "A Gradle plugin for integrating Buzzebees SDK services."
            implementationClass = "com.buzzebees.sdk.services.BuildConfigGeneratorPlugin"
            tags.set(listOf("sdk", "buzzebees", "android", "configuration", "gradle-plugin"))
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("buzzebeesServicesPluginPublication") {
            from(components["java"])  // Gradle plugin component

            // Customize groupId, artifactId, and version
            groupId = "com.buzzebees.sdk"
            artifactId = "services"   // You can override this
            version = "1.0.0"             // You can override this version
        }
    }
}



dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.json) // For handling JSON files
    // 🔥 Add Android Gradle Plugin API to access `AppExtension` & `LibraryExtension`
    implementation(libs.gradle) // Ensure it's the correct AGP version

}
