import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    application
}

group = "com.github.fscarponi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application{
    mainClass.set("MainKt")
}

dependencies {

    val telegramBotDSLVersion: String by project
    val kodeinVersion: String by project
    val logbackVersion: String by project
    val ktorVersion: String by project

    implementation(kotlin("stdlib"))

    implementation("dev.inmo:tgbotapi:$telegramBotDSLVersion")

    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation ("io.ktor:ktor-client-cio:$ktorVersion")


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
