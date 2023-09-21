@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(ThunderbirdPlugins.Library.android)
    alias(libs.plugins.kotlin.parcelize)
}

dependencies {
    api(projects.mail.common)
    api(projects.backend.api)
    api(projects.app.htmlCleaner)
    api(projects.core.android.common)

    implementation(projects.plugins.openpgpApiLib.openpgpApi)

    api(libs.koin.android)

    api(libs.androidx.annotation)

    implementation(libs.okio)
    implementation(libs.commons.io)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.work.ktx)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.localbroadcastmanager)
    implementation(libs.jsoup)
    implementation(libs.moshi)
    implementation(libs.timber)
    implementation(libs.mime4j.core)
    implementation(libs.mime4j.dom)

    testApi(projects.core.testing)
    testImplementation(projects.mail.testing)
    testImplementation(projects.backend.imap)
    testImplementation(projects.mail.protocols.smtp)
    testImplementation(projects.app.storage)
    testImplementation(projects.app.testing)

    testImplementation(libs.kotlin.test)
    testImplementation(libs.kotlin.reflect)
    testImplementation(libs.robolectric)
    testImplementation(libs.androidx.test.core)
    testImplementation(libs.jdom2)
}

android {
    namespace = "com.fsck.k9.core"

    buildFeatures {
        buildConfig = true
    }
}
