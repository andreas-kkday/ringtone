plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    `maven-publish`
}

publishing {
    publications {
        create<MavenPublication>("release") {
            // This maps the library's output to the publication
            afterEvaluate {
                from(components["release"])
            }

            pom {
                name.set("來電鈴聲使用")
                description.set("Pixabay Content License")

                licenses {
                    license {
                        comments.set("https://pixabay.com/sound-effects/ringtone-023-376906/")
                        name.set("Pixabay Content License")
                        url.set("https://pixabay.com/service/license-summary/")
                        distribution.set("repo")
                    }
                }
            }
        }
    }
}

android {
    namespace = "com.one111.ringtone"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}