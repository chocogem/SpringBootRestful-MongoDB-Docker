
# ReviewApplication

Web application & Restful API for search and edit reviews.

[![web1.jpg](https://i.postimg.cc/c4ghnzSM/web1.jpg)](https://postimg.cc/QHDcL0VH)

## Getting Started

First of all you need to have docker installed first then follow step below.

1.Open project with Spring Tool Suite.


2.Right Click Project >Run as>Maven Build..
[![web1.jpg](https://i.postimg.cc/Wz3hR05s/web1.jpg)](https://postimg.cc/njyHB98W)


3.Type package at Goals and click Run

[![step2.jpg](https://i.postimg.cc/Qtm4fK4Q/step2.jpg)](https://postimg.cc/tZ1NTJHJ)


4.Look at console build sucess >Refresh Project >Go to Target to check Jar file was build.

[![step3.jpg](https://i.postimg.cc/XvcQvy0R/step3.jpg)](https://postimg.cc/bGrQCrrg)


[![step5.jpg](https://i.postimg.cc/zf2fCyJM/step5.jpg)](https://postimg.cc/CZDYYLnH)


5.Open Power shell with administrater.
And use comand cd <your project path> >

[![step5.jpg](https://i.postimg.cc/zf2fCyJM/step5.jpg)](https://postimg.cc/CZDYYLnH)


7.Use command docker-compose -f docker-compose.yml up -d
for use docker run app

[![step7.jpg](https://i.postimg.cc/QtzNKCQb/step7.jpg)](https://postimg.cc/ftxQ6wgt)


8.Enter url  http://localhost:5555 in browser.

[![web1.jpg](https://i.postimg.cc/c4ghnzSM/web1.jpg)](https://postimg.cc/QHDcL0VH)


## API Document

[![1-2.png](https://i.postimg.cc/FzJPNCFZ/1-2.png)](https://postimg.cc/9wCPBp7R)

[![2.png](https://i.postimg.cc/KvfGt0Dj/2.png)](https://postimg.cc/Tpyv6qSv)

[![3.png](https://i.postimg.cc/26nmyG5z/3.png)](https://postimg.cc/Q9Nvnp5P)

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

