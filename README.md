
# ReviewApplication

Web application & Restful API for search and edit reviews.

## Getting Started
First of all you need to have docker installed first.
then follow step below.

1.Open project with Spring Tool Suite.

2.Right Click Project >Run as>Maven Build..

[![step1.jpg](https://i.postimg.cc/gjQcfQwK/step1.jpg)](https://postimg.cc/bS0jn69G)

3.Type package at Goals and click Run

[![step2.jpg](https://i.postimg.cc/4NcXY87r/step2.jpg)](https://postimg.cc/F7hMqVxZ)

4.Look at console build sucess >Refresh Project >Go to Target to check Jar file was build.

[![step3.jpg](https://i.postimg.cc/Zq5Rv8hp/step3.jpg)](https://postimg.cc/fV1Z60yR)

[![step5.jpg](https://i.postimg.cc/zf2fCyJM/step5.jpg)](https://postimg.cc/CZDYYLnH)

5.Open Power shell with administrater.
And use comand cd <your project path> >

[![step5.jpg](https://i.postimg.cc/zf2fCyJM/step5.jpg)](https://postimg.cc/CZDYYLnH)

7.Use command docker-compose -f docker-compose.yml up -d
for use docker run app

[![step6.jpg](https://i.postimg.cc/4NRxQkgJ/step6.jpg)](https://postimg.cc/ThQxTs1S)

8.Enter url  http://localhost:5555 in browser.

[![web1.jpg](https://i.postimg.cc/Wz3hR05s/web1.jpg)](https://postimg.cc/njyHB98W)


## API Document

http://localhost:5555/swagger-ui.html#/review45rest45controller

### Unit test

there're two Unit test class in package com.demo.review.testing

-ReviewServiceControllerTest.java

-ReviewServiceDataMongoTest.java
(***This class I put @Ignore annotation because is need to connect db you can remove it to run.***)


## Built With

* Spring Tool Suite4
* Maven
* Java
* Spring boot
* Docker
* MongoDb

## Authors

* **Chocogem** - *Initial work* - [chocogem](https://github.com/chocogem)

