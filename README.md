Java Google Search
==================================

## Installation

```
$ git clone https://github.com/OMARoun/googlesearch.git
$ mvn clean install
```

## Configuration

#### Maven dependency

```xml
<dependency>
  <groupId>ma.omaroun.snippet</groupId>
  <artifactId>googlesearch</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Use
#### Start a google search
```java
GoogleSearchResult result = GoogleSearch.search("omar el alaoui aboufaris", 5);
```
#### Retrieve search results
```java
result.getItems();
```
#### Display the result
```java
System.out.println(result);
```
##### Your output will be like this
```
query : omar el alaoui aboufaris
wanted fetched results : 5
fetched results : 4
results size : 2000
Omar EL ALAOUI ABOUFARIS, RCAR - Groupe CDG - Maroc | Viadeo
::::::::http://ma.viadeo.com/fr/profile/omar.elalaouiaboufaris
Omar EL ALAOUI ABOUFARIS | LinkedIn
::::::::https://ma.linkedin.com/in/omar-el-alaoui-aboufaris-9b433a92
Omar EL ALAOUI ABOUFARIS - YouTube
::::::::https://www.youtube.com/user/einegnu
Omar El Alaoui | Free Listening on SoundCloud
::::::::https://soundcloud.com/omar-elalaoui-0
```
