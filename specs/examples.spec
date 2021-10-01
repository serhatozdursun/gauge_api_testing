Specification Heading
=====================
Created by testinium on 29.09.2021

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.


pet post
----------------
* Get body with "key" from scenario data and update "selector" as "key1" from scenario data
* Add base url "https://petstore.swagger.io"
* Add endpoint "/v2/pet"
* Add Headers
    |key            |value              |
    |---------------|-------------------|
    |accept         |application/json   |
    |Content-Type   |application/json   |
    |Cache-Control  |max-age=0          |
* Add log filter with errorStatus
    |Status |
    |500    |
    |400    |
    |405    |
* Add payload as file from resource "payloads/petPost.json"
* Post request
* Check if status code is "200"
* Get "id" from response and then compare with "2020202112", Are they equals?
* Get "id" from response and store it with "pathId" during scenario
* Get "tags[0].id" from response and then compare with "2", Are they equals?
* Yeni bir api isteği tanımla
* Url ekle "https://petstore.swagger.io"
* Endpoint ekle "/{version}/pet/{pathId}"
* Path parametresi ekle "version" = "v2".
* "pathId" anahtarı ile saklanan datalardan değeri al path parametresi olarak ekle.
* Header Ekle
    |key            |value              |
    |---------------|-------------------|
    |accept         |application/json   |
    |Content-Type   |application/json   |
    |Cache-Control  |max-age=0          |
* Bu statü kodları için log filtresi ekle 
    |Status |
    |500    |
    |400    |
    |405    |
* Get isteği gönder
* Statü kodunu kontrol et "200" mü?
* Yanıttan "tags[0].name" ile değer alın ve "kuçukuçu" ile eşit olduğunu doğrulayın