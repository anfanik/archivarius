import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "2.0.0"
    kotlin("jvm") version kotlinVersion
    kotlin("kapt") version kotlinVersion

    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion

    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "me.anfanik"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    kapt("org.springframework.boot:spring-boot-configuration-processor")

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // todo: change to sqids-kotlin, issue: https://github.com/sqids/sqids-kotlin/issues/7
    implementation("org.sqids:sqids:0.1.0")

    runtimeOnly("org.postgresql:postgresql")
}

dependencyManagement {
    val springCloudVersion = "2023.0.0"
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}")
    }
}

tasks.apply {
    withType(JavaCompile::class) {
        options.encoding = "UTF-8"
        options.compilerArgs.add("-Xlint:none")
    }
    withType(KotlinCompile::class) {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }

    bootJar {
        archiveFileName.set("${project.name}.jar")
    }

    jar {
        enabled = false
    }
}