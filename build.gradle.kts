
allprojects {
    group = "net.codinux.collections"
    version = "1.0.0-SNAPSHOT"


    repositories {
        mavenCentral()
    }


    ext["sourceCodeRepositoryBaseUrl"] = "github.com/codinux-gmbh/ConcurrentCollections"

    ext["projectDescription"] = "Concurrent collections and atomic references implementation for Kotlin Multiplatform"
}