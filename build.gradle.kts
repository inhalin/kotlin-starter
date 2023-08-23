import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"

    // kotlin version
    kotlin("jvm") version "1.8.22"
    // 일부 스프링 애노테이션 사용한 클래스에 allOpen 자동 추가 - @SpringBootTest, @Cacheable, @Async, @Component, @Transactional, @Validated
    kotlin("plugin.spring") version "1.8.22"
    // 일부 JPA 애노테이션 사용한 클래스에 noArgs 자동 추가 - @Entity, @Embedabble, @MappedSuperclass
    kotlin("plugin.jpa") version "1.8.22"
}

group = "com.example"
version = "0.0.1"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")


    // kotlin - json 역직렬화시에 기본 생성자 생략 가능
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.modelmapper:modelmapper:2.4.4")

    // mysql
    runtimeOnly("com.mysql:mysql-connector-j")

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
