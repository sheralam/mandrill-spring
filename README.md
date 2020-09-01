## Mandrill Spring Library
###### Active library Since August 2020

### Integration with your Project

Current Version __0.0.1__ . You are wellcome for beta testing this verion. 

Version __1.x.x__ will be released __within October'2020__. 
There will be __no__ changes on public interfaces between v1.x.x and v0.x.x. Upgrade from any 0.x.x to 1.x.x would require __Only__ change in dependancy mangement settings file (e.g pom.xml)

#### Apache Maven


```
<dependency>
  <groupId>io.github.sheralam</groupId>
  <artifactId>mandrill-spring</artifactId>
  <version>0.0.1</version>
</dependency>
```

#### Gradle Groovy DSL

```
implementation 'io.github.sheralam:mandrill-spring:0.0.1'
```

#### Gradle Kotlin DSL

```
implementation("io.github.sheralam:mandrill-spring:0.0.1")
```

#### Scala SBT

```
libraryDependencies += "io.github.sheralam" % "mandrill-spring" % "0.0.1"
```

#### Apache Ivy

```
<dependency org="io.github.sheralam" name="mandrill-spring" rev="0.0.1" />
```

#### Groovy Grape

```
@Grapes(
  @Grab(group='io.github.sheralam', module='mandrill-spring', version='0.0.1')
)
```

#### Leiningen

```
[io.github.sheralam/mandrill-spring "0.0.1"]
```

#### Maven Central Badge

```
[![Maven Central](https://img.shields.io/maven-central/v/io.github.sheralam/mandrill-spring.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.sheralam%22%20AND%20a:%22mandrill-spring%22)
```

#### PURL

```
maven_jar(
    name = "mandrill-spring",
    artifact = "io.github.sheralam:mandrill-spring:0.0.1",
    sha1 = "7957eb35361571fec9664c3c32481034134303ea",
)
```



## Functional Interfaces
###### ref. https://mandrillapp.com/api/docs/messages.JSON.html
###### MandrillClientFactory is the convenient way to get the MandrillClient, which provides different services, such as MessagesCallsService

```
MessagesCallsService messages = MandrillClientFactory.getClientForApiKey("invalid_api").getMessages();
```

#### Functional Interfaces for MessagesCallsService

Send a new transactional message through Mandrill
```
messages.send(Message message)
```


Send a new transactional message through Mandrill using a template
```
messages.sendTemplate(String templateName, TemplateContent templateContent, Message message)
```


Get the full content of a recently sent message
```
messages.content(String id)
```


Cancels a scheduled email.
```
messages.cancelScheduled(String id)
```


Get the information for a single recently sent message
```
messages.info(String id)
```


Queries your scheduled emails.
```
messages.listScheduled(String to)
```


Parse the full MIME document for an email message, returning the content of the message broken into its constituent pieces
```
messages.parse(String rawMessage)
```


Reschedules a scheduled email.
```
messages.reschedule(String id, String sendAt)
```


Search recently sent messages and optionally narrow by date range, tags, senders, and API keys. 
```
messages.search(Search searchQuery)
```


Search the content of recently sent messages and return the aggregated hourly stats for matching messages
```
messages.searchTimeSeries(SearchTimeSeries searchTimeSeries)
```


Take a raw MIME document for a message, and send it exactly as if it were sent through Mandrill's SMTP servers
```
messages.sendRaw(SendRaw sendRaw)
```

