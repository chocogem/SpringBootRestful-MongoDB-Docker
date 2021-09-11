
# Search review data web Application on docker 

Web application & Restful API for search and edit reviews.

[![web1.jpg](https://i.postimg.cc/c4ghnzSM/web1.jpg)](https://postimg.cc/QHDcL0VH)

## Getting Started

First of all you need to have docker installed first and must starting then follow step below.

1.Open project with Spring Tool Suite.


2.Right Click Project >Run as>Maven Build..

[![step1.jpg](https://i.postimg.cc/gjQcfQwK/step1.jpg)](https://postimg.cc/bS0jn69G)

3.Type package at Goals and click Run

[![step2.jpg](https://i.postimg.cc/4NcXY87r/step2.jpg)](https://postimg.cc/F7hMqVxZ)

4.Look at console build sucess >Refresh Project >Go to Target to check Jar file was build.

[![step3.jpg](https://i.postimg.cc/XvcQvy0R/step3.jpg)](https://postimg.cc/bGrQCrrg)

[![step4.jpg](https://i.postimg.cc/ZnPhJxL1/step4.jpg)](https://postimg.cc/8fCYHW9H)

[![step5.jpg](https://i.postimg.cc/zf2fCyJM/step5.jpg)](https://postimg.cc/CZDYYLnH)

5.Open Power shell with administrater.
And use comand cd <your project path> 

[![step6.jpg](https://i.postimg.cc/fT09ftR1/step6.jpg)](https://postimg.cc/PPTJtqZM)

7.Use command docker-compose -f docker-compose.yml up -d
for use docker run app

[![step7.jpg](https://i.postimg.cc/QtzNKCQb/step7.jpg)](https://postimg.cc/ftxQ6wgt)


8.Enter url  http://localhost:5555 in browser.


## API Document
Restful API

[![1-2.png](https://i.postimg.cc/wTXCN3Hk/1-2.png)](https://postimg.cc/ppdcbWm9)

[![2.png](https://i.postimg.cc/4yT84bKR/2.png)](https://postimg.cc/0McGcSdV)

[![3.png](https://i.postimg.cc/qB5gNJ4q/3.png)](https://postimg.cc/NLRQVwyv)

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
* HTML,jQurey,Ajax

## Authors

* **Chocogem** - *Initial work* - [chocogem](https://github.com/chocogem)

