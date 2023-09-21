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
    api(projects.mail.common)

    implementation(libs.jzlib)
    implementation(libs.jutf7)
    implementation(libs.commons.io)
    implementation(libs.okio)

    testImplementation(projects.mail.testing)
    testImplementation(libs.okio)
    testImplementation(libs.mime4j.core)
}
