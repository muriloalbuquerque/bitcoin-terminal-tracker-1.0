import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

// Projeto: Monitor de Preço do Bitcoin em Terminal (Kotlin Puro)

fun main() {
    while (true) {
        val bitcoinPrice = fetchBitcoinPrice()
        println("Preço atual do Bitcoin: $bitcoinPrice")

        println("Aguardando 3 minutos para próxima atualização...\n")


        try {
            Thread.sleep(180000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}

fun fetchBitcoinPrice(): String {
    val apiUrl = "https://api.coincap.io/v2/assets/bitcoin"

    try {
        val url = URL(apiUrl)
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; BitcoinTracker/1.0)")


        println("Conexão feita com sucesso!")

        val inputStream = if (connection.responseCode == 200) {
            connection.inputStream
        } else {
            connection.errorStream
        }

        if (connection.responseCode != 200) {
            return "Erro ${connection.responseCode}: ${connection.responseMessage}"
        }

        val reader = BufferedReader(InputStreamReader(inputStream))
        val response = StringBuffer()

        reader.forEachLine { line -> response.append(line) }

        reader.close()
        inputStream.close()

        val responseString = response.toString()
        val priceRegex = """"priceUsd":"([\d.]+)"""".toRegex()
        val match = priceRegex.find(responseString)

        return if (match != null) {
            val price = match.groupValues[1].toDouble()
            "US$ %.2f".format(price)
        } else {
            "Preço não encontrado"
        }

    } catch (e: Exception) {
        e.printStackTrace()
        return "Erro ao obter o preço do Bitcoin"
    }
}
