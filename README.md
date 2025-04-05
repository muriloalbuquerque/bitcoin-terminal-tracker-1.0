# Bitcoin Price Monitor in Kotlin (Terminal App)

This is a simple project developed in **pure Kotlin** that monitors the current price of Bitcoin (BTC) using a public API. The value is updated automatically every minute and displayed in the terminal.

---

## Objective

This project is designed to help you learn how to:

- Make HTTP requests using `HttpURLConnection`
- Read data from the web using `InputStream` and `BufferedReader`
- Extract information from a JSON response using regular expressions (without external libraries)
- Implement loops with timing using `Thread.sleep()`

---

## Technologies and Tools Used

| Technology              | Description                                                       |
|-------------------------|-------------------------------------------------------------------|
| **Kotlin**              | The primary programming language for the project                  |
| **HttpURLConnection**   | Used to make HTTP GET requests to the API                         |
| **Regex**               | Extracts the value from the JSON response without external libraries|
| **CoinCap API**         | Provides current Bitcoin price data in USD                        |
| **Terminal**            | Displays the real-time data                                       |

---

## Project Structure

/monitor-bitcoin-terminal │ ├── src │ └── Main.kt # Main source code of the app │ └── README.md # Project documentation (this file)

yaml
Copy
Edit

---

## Data Source (API)

This project uses the [CoinCap API](https://api.coincap.io/v2/assets/bitcoin) to retrieve the Bitcoin price.

API URL:
https://api.coincap.io/v2/assets/bitcoin

markdown
Copy
Edit

The API response is a JSON object that contains, among other details, a field called `priceUsd`, which is extracted using a regular expression.

---

## How to Run on Your Machine

### Prerequisites

- **Java SDK** (version 8 or higher)
- **Kotlin** installed on your machine  
  > You can install it via [SDKMAN!](https://sdkman.io) or through the [official website](https://kotlinlang.org/docs/command-line.html)
- Access to a terminal (Command Prompt, PowerShell, bash, etc.)

### Steps to Run

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/your-username/monitor-bitcoin-terminal.git
   cd monitor-bitcoin-terminal
Compile the Project:

Assuming the source code is located in src/Main.kt:

bash
Copy
Edit
kotlinc src/Main.kt -include-runtime -d MonitorBitcoin.jar
Run the Program:

bash
Copy
Edit
java -jar MonitorBitcoin.jar
The terminal will display something like:

pgsql
Copy
Edit
Connection established successfully!
Current Bitcoin Price: US$ 65,432.12
The value will update automatically every minute.

How It Works
The program runs an infinite loop that:

Sends an HTTP GET request to the CoinCap API.

Reads the API response and converts it into a string.

Uses a regular expression to extract the priceUsd value from the JSON.

Displays the formatted price in the terminal.

Waits for 60 seconds (Thread.sleep(60000)) before repeating the process.

Complete Source Code
kotlin
Copy
Edit
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

// Project: Bitcoin Price Monitor in Terminal (Pure Kotlin)

fun main() {
    while (true) {
        val bitcoinPrice = fetchBitcoinPrice()
        println("Current Bitcoin Price: $bitcoinPrice")
        try {
            Thread.sleep(60000)
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
        connection.setRequestProperty("User-Agent", "Mozilla/5.0")
        println("Connection established successfully!")

        val inputStream = if (connection.responseCode == 200) {
            connection.inputStream
        } else {
            connection.errorStream
        }

        if (connection.responseCode != 200) {
            return "Error ${connection.responseCode}: ${connection.responseMessage}"
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
            "Price not found"
        }
    } catch (e: Exception) {
        e.printStackTrace()
        return "Error obtaining Bitcoin price"
    }
}
What You Will Learn from This Project
How to perform simple HTTP requests in Kotlin using HttpURLConnection

How to read and manipulate web responses using BufferedReader and InputStreamReader

How to use regular expressions to extract data from a JSON response without external libraries

How to implement an infinite loop with timing using Thread.sleep()

Best practices for error handling and output formatting

Future Improvements (Ideas)
Use a JSON library: Integrate libraries like Gson, Moshi, or org.json for robust JSON parsing.

Support multiple cryptocurrencies: Extend the project to monitor other cryptocurrencies like Ethereum (ETH), Solana (SOL), etc.

Graphical Interface: Add a GUI using JavaFX or Swing.

Alerts and Notifications: Implement alerts when the price reaches a certain threshold or experiences significant changes.

Historical Data: Save the price data to a CSV file or database for later analysis.

Author
Murilo
Developer in progress, focused on practical projects and continuous learning.

LinkedIn • GitHub

License
This project is licensed under the MIT License. See the LICENSE file for details.

sql
Copy
Edit

Feel free to modify the GitHub and LinkedIn links as needed. This README.md file contains all the necessary i
