plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.tbd.servicemanager.android"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")


    //ktor
    implementation(ktor.clientAndroid)

    //Compose
    implementation(Compose.compiler)
    implementation(Compose.ui)
    implementation(Compose.runtime)
    implementation(Compose.activity)
    implementation(Compose.uiGraphics)
    implementation(Compose.uiTooling)
    implementation(Compose.foundationLayout)
    implementation(Compose.material)
    implementation(Compose.materialIconsExtended)
    implementation(Compose.navigation)
    implementation(Compose.paging)
    implementation(Compose.coilCompose)


}