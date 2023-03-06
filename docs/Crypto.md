# Crypto osztály használata

```java
//128 bites kulcs (16 darab kar.)
String key = "343834839224af82";

Crypto c = new Crypto();
String cryptText = c.encrypt("titok", key);
System.out.println(cryptText);
String plainText = c.decrypt(cryptText, key);
System.out.println(plainText);
```
