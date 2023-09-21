@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(ThunderbirdPlugins.Library.jvm)
    alias(libs.plugins.android.lint)
}

val testCoverageEnabled: Boolean by extra
if (testCoverageEnabled) {
    apply(plugin = "jacoco")
}

dependencies {
    api(libs.jetbrains.annotations)

    implementation(libs.mime4j.core)
    implementation(libs.mime4j.dom)
    implementation(libs.okio)
    implementation(libs.commons.io)
    implementation(libs.moshi)

    // We're only using this for its DefaultHostnameVerifier
    implementation(libs.apache.httpclient5)

    testImplementation(projects.mail.testing)
    testImplementation(libs.icu4j.charset)
}
