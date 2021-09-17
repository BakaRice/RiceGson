Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to
convert a JSON string to an equivalent Java object. Gson can work with arbitrary Java objects including pre-existing
objects that you do not have source-code of.

Complete Gson documentation is available at its project page
https://github.com/google/gson

Through the study of Gson source code to establish this project
# internal

```
|-- $Gson$Preconditions
|-- LazilyParsedNumber
|-- LinkedTreeMap
|-- Primitives
```


# Object

```
|JsonElement
|-- JsonArray
|-- JsonNull
|-- JsonObject
|-- JsonPritive
```

# Exception

```
|ParseException
|-- IOException
|-- SyntaxException
```
