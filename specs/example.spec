#Examples

* Send slack message to "https://hooks.slack.com/services/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"

## Example 1

* Log "*******Test Başladı*******"
* Yeni bir api isteği tanımla
* Add Headers
    |Key           |Value            |
    |--------------|-----------------|
    |Content-Type  |application/json |
    |Connection    |keep-alive       |
* Add log filter with errorStatus
    |Status Codes|
    |400         |
    |415         |
    |404         |
* Log "*******Test Bitti*******"

## Testt....

* Define new request
* Add log filter with errorStatus
     |Status Codes|
     |400         |
     |405         |
     |415         |
* Add as a header "content-type" = "application/json"
* Add base url "https://petstore.swagger.io"
* Add endpoint "/v2/pet"
* Add payload as String from resource "payloads/example.json"
* Post request
* Check if status code is "200"
* Get response time as milliseconds and compare it, is it less then "22000"?
* Get response time as seconds and compare it, is it less then "5"?
* Get "tags[1].name" from response and store it with "tagName" during scenario
* Get "tags[1].name" from response and then compare with "adana", Are they equals?

## Document examples tr

* Yeni bir api isteği tanımla
* Senaryo boyunca "payloads/example.json" içeriğini "json_body" anahtarı ile sakla
* Senaryo boyunca değişkeni sakla "pat_name" = "karabaş"
* "json_body" anahtarı ile saklanan body'den, "name" değerini al, kayıtlı "pat_name"'in değeri ile güncelle
* Senaryo kayıtlı verisinden istek body'si ekle, kayıt anahtarı "json_body"

## Document examples en

* Define new request
* Store "payloads/example.json"'s value from classpath with "json_body" during scenario
* Store variable "pat_name" = "karabaş" during scenario
* Get body with "json_body" from scenario data and update "name" as "pat_name" from scenario data
* Add payload from scenario store with "json_body"

## json schema 

* Define new request
* Add log filter with errorStatus
     |Status Codes|
     |400         |
     |405         |
     |415         |
* Add as a header "content-type" = "application/json"
* Add base url "https://petstore.swagger.io"
* Add endpoint "/v2/pet"
* Add payload as String from resource "payloads/example.json"
* Post request
* Check if status code is "200"
* Validate response json with schema "schemas/petSchema.json"
* Store response as string with "response1" during scenario
* Validate json "response1" from the scenario stored data with schema "schemas/petSchema.json" in classpath
* Get "id" from response and then compare with "25", Are they equals?

## test sleep
* Sleep for "100" milliSecond