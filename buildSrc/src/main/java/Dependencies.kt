
object Versions {
    const val kotlinVersion = "1.7.10"
    const val kotlinxCoroutines = "1.6.4"
    const val koin = "3.2.0"
    const val apollo = "3.4.0"
    const val multiplatformPaging = "0.4.7"
    const val ktor = "2.0.3"

    const val compose = "1.2.0"
    const val composeCompiler = "1.3.0-rc01"
    const val navCompose = "2.4.2"
    const val pagingCompose = "1.0.0-alpha15"
    const val accompanist = "0.24.13-rc"
    const val coilComposeVersion = "2.1.0"

    const val junit = "4.13"
}


object AndroidSdk {
    const val min = 21
    const val compile = 32
    const val target = compile
}

object Deps {
    const val apolloRuntime = "com.apollographql.apollo3:apollo-runtime:${Versions.apollo}"
    const val apolloNormalizedCache = "com.apollographql.apollo3:apollo-normalized-cache:${Versions.apollo}"
    const val multiplatformPaging = "io.github.kuuuurt:multiplatform-paging:${Versions.multiplatformPaging}"

    object Kotlinx {
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinxCoroutines}"
    }
}

object Compose {
    const val compiler = "androidx.compose.compiler:compiler:${Versions.composeCompiler}"
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val activity = "androidx.activity:activity-compose:${Versions.compose}"
    const val uiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val foundationLayout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"
    const val material = "androidx.compose.material:material:${Versions.compose}"
    const val materialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val navigation = "androidx.navigation:navigation-compose:${Versions.navCompose}"
    const val paging = "androidx.paging:paging-compose:${Versions.pagingCompose}"
    const val coilCompose = "io.coil-kt:coil-compose:${Versions.coilComposeVersion}"
}

object Koin {
    val core = "io.insert-koin:koin-core:${Versions.koin}"
    val test = "io.insert-koin:koin-test:${Versions.koin}"
    val testJUnit4 = "io.insert-koin:koin-test-junit4:${Versions.koin}"
    val android = "io.insert-koin:koin-android:${Versions.koin}"
    val compose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
}


object ktor{
    val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    val clientJson = "io.ktor:ktor-client-json:${Versions.ktor}"
    val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    val clientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
    val clientJava = "io.ktor:ktor-client-java:${Versions.ktor}"
    val clientDarwin = "io.ktor:ktor-client-darwin:${Versions.ktor}"
    val clientOkhttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
    val clientJs = "io.ktor:ktor-client-js:${Versions.ktor}"
    const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
    const val json = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
}

