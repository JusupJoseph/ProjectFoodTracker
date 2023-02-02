plugins {
    id(Plugins.application)
    id(Plugins.kotlinAndroid)
    // Kapt
    id(Plugins.kapt)

    // Hilt
    id(Plugins.hilt)

    // SafeArgs
    id(Plugins.safeArgs)
}


android {
    namespace = Config.applicationId
    compileSdk = Config.compileAndTargetSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.compileAndTargetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    // ViewBinding
    buildFeatures.viewBinding = true
}

dependencies {

    // Core
    implementation(Dependencies.core)

    // Material
    implementation(Dependencies.UIComponents.material)

    // Constraint
    implementation(Dependencies.UIComponents.constraint)

    // AppCompat
    implementation(Dependencies.UIComponents.appcompat)

    // Hilt
    implementation(Dependencies.Hilt.hilt)
    kapt(Dependencies.Hilt.compiler)

    // Glide
    implementation(Dependencies.Glide.glide)
    annotationProcessor(Dependencies.Glide.glideCompiler)

    // NavComponents
    implementation(Dependencies.NavComponents.navigationUI)
    implementation(Dependencies.NavComponents.navigationFragment)

    // LifeCycle
    implementation(Dependencies.Lifecycle.lifecycleLiveData)
    implementation(Dependencies.Lifecycle.lifecycleRunTime)
    implementation(Dependencies.Lifecycle.lifecycleViewModel)

    // ViewBindingPropertyDelegate
    implementation(Dependencies.ViewBindingPropertyDelegate.viewBindingDelegate)

    // Coroutines
    implementation(Dependencies.Coroutines.coroutinesCore)
    implementation(Dependencies.Coroutines.coroutinesAndroid)

    // ViewPager
    implementation(Dependencies.viewPager)

    // DotsIndicator
    implementation(Dependencies.dotsIndicator)
}