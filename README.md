# Gauge Api Testing Framework
- [Gauge Api Testing Framework](#gauge-api-testing-framework)
    * [Overview](#overview)
        + [Requirements](#requirements)
        + [How to use this project within another project](#how-to-use-this-project-within-another-project)
    * [Step explanations](#step-explanations)
        + [Defining new request](#createRequest)
        + [Adding Headers](#adding-headers)

<a name="overview"></a>
## Overview
This project is developed for testing API services, microservices etc.
<a name="requirements"></a>
### Requirements

1- Java 11 jdk
2- Gauge 1.1.8

``` Gauge Java plugin 0.7.15 ```

``` Gauge html-report plugin (4.0.12) ```

``` Gauge xml-report (0.2.3) ```

<a name="how-to-use-this-project-within-another-project"></a>
### How to use this project within another project

First, you can download this project to your local. Then you can compile the project after that you'll see a created target folder. You could copy the jar file from this folder, and you can add the jar file to your project as an external library.

<a name="step-explanations"></a>
## Step explanations

<a name="createRequest"></a>
### Defining new request:

This step creates only a new request. Without this step, you can not create a request. You have to use this step to create a new request.

### Adding Headers

* Add as a header \<key> = \<value>

You can add headers by one by with using this step.

The "key" variable is the header key
The "value" variable is the header value

* Add Headers \<table>

You can add headers as a table 

*example*
* Add Headers
  
  |Key           |Value            |
  |--------------|-----------------|
  |Content-Type  |application/json |
  |Connection    |keep-alive       |

* Add multi-part data as content-type to header with default boundary \<boundary>

With help this step you can give multipart content type as header. It calculates boundary automatically

* Add SOAPAction \<action>

With help this step you can set soap action as header.