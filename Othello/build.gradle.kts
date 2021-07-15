plugins {
    application
    kotlin("jvm") version "1.5.20"
}

group = "com.ikanoshiokara"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("junit", "junit", "4.12")
}

application{
    mainClassName = "com.ikanoshiokara.othello.MainKt"
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
