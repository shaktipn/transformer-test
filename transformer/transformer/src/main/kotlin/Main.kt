package org.example

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import org.example.subcommands.Clean

fun main(args: Array<String>) {
    Transformer().subcommands (
        Clean()
    ).main(args)
}

class Transformer: CliktCommand(help = "transformer commands", name = "transformer") {
    override fun run() {
        echo("Executing command...")
    }
}
