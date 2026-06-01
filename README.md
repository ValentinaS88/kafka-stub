# Kafka HTTP Stub

Заглушка на Spring Boot для приёма HTTP‑запросов и отправки сообщений в Kafka. 

## Функциональность

Приложение:
* принимает POST‑запросы на эндпоинте `/post-message`;
* извлекает поле `msg_id` из JSON‑тела запроса;
* формирует JSON‑сообщение с полями:
  * `msg_id` — ID сообщения из запроса;
  * `timestamp` — текущее время (unix timestamp в миллисекундах);
  * `method` — HTTP‑метод (`POST`);
  * `uri` — путь запроса (`/post-message`);
* отправляет сформированное сообщение в указанный топик Kafka;
* возвращает ответ:
  * `200 OK` — если сообщение успешно отправлено в Kafka;
  * `500 Internal Server Error` — если произошла ошибка (например, Kafka недоступна).


## Настройка и запуск

### 1. Запустить Kafka и ZooKeeper

```bash
# ZooKeeper
bin\windows\zookeeper-server-start.bat config\zookeeper.properties

# Kafka
bin\windows\kafka-server-start.bat config\server.properties
```

### 2. Создать топик

```bash
bin\windows\kafka-topics.bat --create --topic postedmessages --bootstrap-server localhost:9092
```

### 📤 Отправить запрос

```bash
curl -X POST http://localhost:8080/post-message -H "Content-Type: application/json" -d "{\"msg_id\":\"1234567890\"}"
```

:white_check_mark: **Ожидаемый ответ:** `200 OK` 

:x:  **Ошибка:**
Если Kafka недоступна → 500 Internal Server Error 


   
