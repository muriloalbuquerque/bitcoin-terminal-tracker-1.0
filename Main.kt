# Bitcoin Terminal Tracker 1.0

📈 **Bitcoin Terminal Tracker** é um aplicativo de terminal desenvolvido em **Kotlin**, que permite acompanhar o preço atual do Bitcoin em tempo real diretamente no terminal.

## 🔥 Tecnologias utilizadas

- **Kotlin** — Linguagem principal do projeto
- **API de preço do Bitcoin** — Utiliza a API pública da CoinCap para obter o preço
- **HTTP Requests** — Para buscar as informações da API
- **Aplicação de Terminal** — Interface simples e direta para o terminal

## 🚀 Como rodar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/muriloalbuquerque/bitcoin-terminal-tracker-1.0.git
   ```
2. Abra o projeto no seu IDE preferido (recomendo o IntelliJ IDEA).
3. Execute a aplicação.

## ✨ Funcionalidades

- Consulta em tempo real do preço do Bitcoin
- Atualizações automáticas a cada 3 minutos
- Interface simples e direta no terminal

## 📚 Objetivos do projeto

Este projeto foi criado para praticar:
- Consumo de APIs em Kotlin
- Desenvolvimento de aplicações para terminal
- Estruturação e organização de código limpo e eficiente

## ⚙️ Como funciona

A cada 3 minutos, o programa faz uma requisição para a API da **CoinCap** e obtém o preço atual do Bitcoin em USD. O preço é exibido no terminal em um formato de fácil leitura. Em caso de erro na requisição ou falha na obtenção dos dados, uma mensagem de erro será exibida.

## 📝 Exemplo de saída no terminal

```
Preço atual do Bitcoin: US$ 56,345.67
Aguardando 3 minutos para próxima atualização...
```

## 🤝 Contribuições

Contribuições são bem-vindas! Se você encontrar algum erro ou tiver sugestões de melhorias, fique à vontade para abrir uma issue ou enviar um pull request.

---

