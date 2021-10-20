Specification Heading
=====================
Created by testinium on 29.09.2021

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
* Send test result as slack message with webhook
pet post
----------------
* Add payload as file from resource "payloads/petPost.json"
* Add base url "https://petstore.swagger.io"
* Add relaxedHTTPSValidation
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
* Post request
* Check if status code is "200"


pet post 2
----------------
* Add payload as file from resource "payloads/petPost.json"
* Add base url "https://petstore.swagger.io"
* Add relaxedHTTPSValidation
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
* Post request
* Get response time as milliseconds and compare it, is it less then "500"?
* Sleep for "120" milliSecond
* Check if status code is "200"
