
# ReviewApplication

Web application & Restful API for search and edit reviews.

[![web1.jpg](https://i.postimg.cc/c4ghnzSM/web1.jpg)](https://postimg.cc/QHDcL0VH)

## Getting Started

First of all you need to have docker installed first then follow step below.

1.Open project with Spring Tool Suite.


2.Right Click Project >Run as>Maven Build..

[![step1.jpg](https://i.postimg.cc/gjQcfQwK/step1.jpg)](https://postimg.cc/bS0jn69G)

3.Type package at Goals and click Run

[![step2.jpg](https://i.postimg.cc/4NcXY87r/step2.jpg)](https://postimg.cc/F7hMqVxZ)

4.Look at console build sucess >Refresh Project >Go to Target to check Jar file was build.

[![step3.jpg](https://i.postimg.cc/XvcQvy0R/step3.jpg)](https://postimg.cc/bGrQCrrg)

[![step4.jpg](https://i.postimg.cc/ZnPhJxL1/step4.jpg)](https://postimg.cc/8fCYHW9H)


5.Open Power shell with administrater.
And use comand cd <your project path> >

[![step5.jpg](https://i.postimg.cc/zf2fCyJM/step5.jpg)](https://postimg.cc/CZDYYLnH)

[![step6.jpg](https://i.postimg.cc/4NRxQkgJ/step6.jpg)](https://postimg.cc/ThQxTs1S)

7.Use command docker-compose -f docker-compose.yml up -d
for use docker run app

[![step7.jpg](https://i.postimg.cc/QtzNKCQb/step7.jpg)](https://postimg.cc/ftxQ6wgt)


8.Enter url  http://localhost:5555 in browser.


## API Document

[![1-2.png](https://i.postimg.cc/wTXCN3Hk/1-2.png)](https://postimg.cc/ppdcbWm9)

[![2.png](https://i.postimg.cc/4yT84bKR/2.png)](https://postimg.cc/0McGcSdV)

[![3-1.png](https://i.postimg.cc/MTXcchQy/3-1.png)](https://postimg.cc/mzfZJpVD)

### Unit test

there're two Unit test class in package com.demo.review.testing

-ReviewServiceControllerTest.java

-ReviewServiceDataMongoTest.java
(***This class I put @Ignore annotation because it need to connect db you can remove it to run.***)


## Built With

* Spring Tool Suite4
* Maven
* Java
* Spring boot
* Docker
* MongoDb

## Authors

* **Chocogem** - *Initial work* - [chocogem](https://github.com/chocogem)

