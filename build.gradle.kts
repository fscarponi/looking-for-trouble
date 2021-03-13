import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.30"
    application
    `maven-publish`
}

group = "com.github.fscarponi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven("https://dl.bintray.com/lamba92/com.github.lamba92")
}

dependencies {

    val telegrambotsktxversion: String by project
    val kodeinVersion: String by project
    val logbackVersion: String by project
    val ktor_version: String by project

    implementation(kotlin("stdlib"))

    implementation("com.github.lamba92:kotlingram-core:$telegrambotsktxversion")
    implementation("com.github.lamba92:kotlingram-bot-builder:$telegrambotsktxversion")

    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation ("io.ktor:ktor-client-cio:$ktor_version")
    implementation("ch.qos.logback:logback-classic:1.2.3")

    api("org.kodein.di", "kodein-di", kodeinVersion)
    api("ch.qos.logback", "logback-classic", logbackVersion)

    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
