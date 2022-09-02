# KittyAPI

👩‍🏫 *The REST API was created to learn the Spring framework.*

<h6 align="Left">Used Languages and Tools:</h6>

<a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="30" height="30"/> 
</a> 
<a href="https://spring.io/" target="_blank" rel="noreferrer"> 
<img src="https://www.svgrepo.com/show/354380/spring-icon.svg" alt="spring" width="30" height="30"/> 
</a> 
<a href="https://www.mongodb.com/" target="_blank" rel="noreferrer"> 
<img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mongodb/mongodb-original-wordmark.svg" alt="mongodb" width="30" height="30"/> 
</a> 

#

🖼️ [Frontend app](https://github.com/Norbit4/Kitty/ "Click")
#
<h3>REST API</h3>

- **Get all cats**
``` 
GET https://kitty.fly.dev/api/cat/all
```
Sample response:
``` json
[
  {
      "id": "630deaa6900398169482bf5c",
      "breed": "Persian",
      "description": null,
      "imgLink": "https://kitty.fly.dev/api/cat/getfile/c7146b94-019f-4e35-8f92-8131132a3c77",
      "imgId": "c7146b94-019f-4e35-8f92-8131132a3c77"
  },
  {
      "id": "630e0e26900398169482bf5d",
      "breed": "Scotitsh",
      "description": null,
      "imgLink": "https://kitty.fly.dev/api/cat/getfile/48abe532-50fb-4965-9384-8bc9a75bfedc",
      "imgId": "48abe532-50fb-4965-9384-8bc9a75bfedc"
  }
]

``` 

- **Get random cat**

``` 
GET https://kitty.fly.dev/api/cat/random
```
Sample response:

``` json
{
    "id": "630e0e43900398169482bf5e",
    "breed": "Manx",
    "description": null,
    "imgLink": "https://kitty.fly.dev/api/cat/getfile/6764bb54-7002-4423-9d0a-65045d64f330",
    "imgId": "6764bb54-7002-4423-9d0a-65045d64f330"
}

``` 

- **Get cat img**

```
GET https://kitty.fly.dev/api/cat/getfile/[imgId]
```
Sample response:

![image](https://user-images.githubusercontent.com/46154743/187506104-df1f284b-a7d7-4d88-a5d3-404ef2c174ae.png)


- **Post cat**
``` 
POST https://kitty.fly.dev/api/cat/add
```

Sample response:

``` json
{
    "id": "630e0e43900398169482bf5e",
    "breed": "Manx",
    "description": null,
    "imgLink": "https://kitty.fly.dev/api/cat/getfile/6764bb54-7002-4423-9d0a-65045d64f330",
    "imgId": "6764bb54-7002-4423-9d0a-65045d64f330"
}

``` 

- **Delete cat**
``` 
DELETE https://kitty.fly.dev/api/cat/delete/[id]
```

Sample response:

``` 
OK
```
