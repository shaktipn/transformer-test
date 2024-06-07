package org.example.helpers

import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import java.io.File
import java.io.FileOutputStream
import java.nio.file.Path
import java.text.SimpleDateFormat
import java.util.TimeZone

class GenerateFile(private val input: Path, private val output: Path) {
    fun cleanedCSV(){
        val inputTextFile = input.toFile()
        val outputCSVFile = output.toFile()
        XSSFWorkbook().use { wb ->
            val sheet = wb.createSheet("student-data")
            val data = inputTextFile.readText()
            val linesOfData = data.split("\n")
            sheet.writeHeader(linesOfData.first())
            sheet.writeContent(linesOfData.subList(fromIndex = 1, toIndex = linesOfData.size))
            wb.write(outputCSVFile)
        }
    }

    fun toParquet(){
        //this needs a local spark setup, ...
        val conf = SparkConf().setAppName("spark-parquet-creator").setMaster("local[*]")
        val spark = SparkSession
            .builder()
            .config(conf)
            .orCreate
        val dir = input.toAbsolutePath().toString()
        val ds = spark.read().option("header", true).option("inferSchema", true).csv(dir)
        val parquetFile = output.toAbsolutePath().toString()
        val codec = "parquet"
        ds.write().format(codec).save(parquetFile)
        spark.stop()
    }

    fun String.convertTimestampToISO(): String {
        val inputDateFormat = SimpleDateFormat("dd MMM yyyy HH:mm:ssZ")
        val outputDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX")
        val date = inputDateFormat.parse(this)
        val indianTimeZone = TimeZone.getTimeZone("Asia/Kolkata")
        outputDateFormat.timeZone = indianTimeZone
        return outputDateFormat.format(date)
    }

    private fun XSSFSheet.writeContent(contentStrings: List<String>) {
        var rowCount = 1
        contentStrings.forEach { contentLine ->
            val row = createRow(rowCount++)
            var colCount = 0
            contentLine.split("|").forEach{ contentValue ->
                if(row.sheet.getRow(0).cellIterator().asSequence().toList()[colCount].stringCellValue == "12th Percentage"){
                    row.createCell(colCount++).setCellValue(contentValue.getPercentage())
                }
                else if(row.sheet.getRow(0).cellIterator().asSequence().toList()[colCount].stringCellValue == "Coding Test Time"){
                    row.createCell(colCount++).setCellValue(contentValue.convertTimestampToISO())
                }
                else {
                    row.createCell(colCount++).setCellValue(contentValue)
                }
            }
        }
    }

    private fun String.getPercentage(): String{
        val chars = toCharArray()
        val digits = chars.filter { it.isDigit() }
        val ans = digits.subList(0,digits.size-1).plus(".").plus(digits.last()).plus("0")
        return ans.joinToString(separator = "")
    }

    private fun XSSFSheet.writeHeader(headerString: String){
        var colIndex = 0
        val header = createRow(0)
        val columns = headerString.split("|")
        columns.forEach {
            header.createCell(colIndex++).setCellValue(columns[colIndex-1])
        }
    }

    private fun XSSFWorkbook.write(outputFile: File) {
        FileOutputStream(outputFile).use(::write)
    }
}