package org.example.subcommands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.UsageError
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.path
import org.example.helpers.GenerateFile
import java.nio.file.Path

class Clean: CliktCommand(name = "clean", help = "clean the file") {
    val input: Path? by option("--input").path()
    val output: Path? by option("--output").path()

    override fun run() {
        if(input == null || output == null){
            throw UsageError("Paths are null...")
        }
        val inputPath = input
        val outputPath = output

        inputPath?.let {
            outputPath?.let {
                GenerateFile(
                    input = inputPath,
                    output = outputPath
                ).cleanedCSV()
            }
        }
    }
}

