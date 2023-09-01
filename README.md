# client

# Создайте базу данных client в Mysql

# Запустите приложение

# Для Создания клиента отправьте POST запрос на 
# /api/v1/client
# в формате JSON переменную name
{
  "name" : "testName"
}

# ![image](https://github.com/babakanov/client/assets/51857869/c36305ce-ea32-4929-9192-51bec8df267b) пример на POSTMAN

# для создания контактов клиента  нужно отправить запрос на 
# /api/v1/contacts/{clientId} где clientId это ID клиента
{
  "email": "string",
  "phoneNumber": "string"
}

# ![image](https://github.com/babakanov/client/assets/51857869/2824f1a5-a574-45dc-8e55-28cbe0ab2672) пример на POSTMAN

# для получения списка всех клиентов нужно отправить GET запрос на 
# /api/v1/client/all

# для получения списка всех контактов нужно отправить GET запрос на 
# /api/v1/contacts/all

# для получения списка всех контактов по клиенту нужно отправить GET запрос 
# /api/v1/contacts/all-by-client/{clientId} где clientId это ID клиента 
# ![image](https://github.com/babakanov/client/assets/51857869/fc05c0ef-316d-4ce8-8378-d3493961996b) пример на POSTMAN

# для получения информации о клиенте нужно отправить GET запрос 
# /api/v1/client/{id} где id это ID клиента 
# ![image](https://github.com/babakanov/client/assets/51857869/7dc0f4b8-a757-4f69-9837-3c131ca5de54) пример на POSTMAN

# для получения информации о контакте нужно отправить GET запрос 
# /api/v1/contacts/{id} где id это ID контакта 
# ![image](https://github.com/babakanov/client/assets/51857869/6bee5257-f0a4-4fe6-813e-7c2bf5d6a86b) пример на POSTMAN
