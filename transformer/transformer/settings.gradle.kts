plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "transformer"
include("src:main:subcommands")
findProject(":src:main:subcommands")?.name = "subcommands"
