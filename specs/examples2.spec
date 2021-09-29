Specification Heading
=====================
Created by testinium on 29.09.2021

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
* Add base url "https://petstore.swagger.io"


Scenario Heading
----------------
* Add Headers 
 |key          | value          |
 |-------------|----------------|
 |accept       |application/json|
 |Content-Type |application/json|
 |Cache-Control|max-age=0       |
* Add endpoint "/v2/pet"
* Add payload as file from resource "payloads/petPost.json"
* Add log filter with errorStatus
 |Status Code |
 |405         |
 |400         |
* Post request
* Check if status code is "200"
* Get "id" from response and then compare with "2020202112", Are they equals?
* Get "category.name" from response and then compare with "Dog", Are they equals?
* Get "tags[0].id" from response and then compare with "2", Are they equals?
* Get "id" from response and store it with "pathId" during scenario
* Define new request
* Add Headers 
 |key          | value          |
 |-------------|----------------|
 |accept       |application/json|
 |Content-Type |application/json|
 |Cache-Control|max-age=0       |
* Endpoint ekle "/{version}/pet/{pathId}"
* Add path parameter "version" = "v2".
* Add path parameter from scenario store with "pathId"
* Get request
* Statü kodunu kontrol et "200" mü?