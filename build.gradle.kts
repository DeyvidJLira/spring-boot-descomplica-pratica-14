plugins {
	java
	id("org.springframework.boot") version "2.7.12"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "com.deyvidjlira"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_16

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-security")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	implementation("org.springdoc:springdoc-openapi-data-rest:1.7.0")
	implementation("org.springdoc:springdoc-openapi-ui:1.7.0")
	implementation("org.springdoc:springdoc-openapi-kotlin:1.7.0")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springframework.security:spring-security-test")
	implementation("com.auth0:java-jwt:3.19.2")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
