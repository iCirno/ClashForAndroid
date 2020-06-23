plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

val gCompileSdkVersion: String by project
val gBuildToolsVersion: String by project

val gMinSdkVersion: String by project
val gTargetSdkVersion: String by project

val gVersionCode: String by project
val gVersionName: String by project

val gKotlinVersion: String by project
val gAndroidKtxVersion: String by project
val gAppCompatVersion: String by project
val gMaterialDesignVersion: String by project

android {
    compileSdkVersion(gCompileSdkVersion)
    buildToolsVersion(gBuildToolsVersion)

    defaultConfig {
        minSdkVersion(gMinSdkVersion)
        targetSdkVersion(gTargetSdkVersion)

        versionCode = gVersionCode.toInt()
        versionName = gVersionName

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":common"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$gKotlinVersion")
    implementation("androidx.appcompat:appcompat:$gAppCompatVersion")
    implementation("androidx.core:core-ktx:$gAndroidKtxVersion")
    implementation("com.google.android.material:material:$gMaterialDesignVersion")
}
