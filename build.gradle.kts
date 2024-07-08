plugins {
    kotlin("jvm") version "1.9.23"
}

group = "org.rework.uhc.api"
version = "0.1.0.0"
val name = "ReWork UHC API"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
    implementation("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<Copy>("generatePluginYml") {
    from("src/main/resources/plugin.yml.template")
    into("build/resources/main")
    rename("plugin.yml.template", "plugin.yml")
    expand("name" to project.name, "version" to project.version)
}

tasks.named("processResources") {
    dependsOn("generatePluginYml")
}

kotlin {
    jvmToolchain(17)
}
