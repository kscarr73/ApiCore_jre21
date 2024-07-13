# ApiModels: ApiCore

ApiObject is the main implementation of ApiModels.  This is the Runtime object for the Models.  It can be processed using various formats, and has helper functions for most field types.

# ApiObject Features

## Example Setting Fields

ApiObject has various functions to handle setting various field types.  The format is `field` and `value` for most field types. Example: `obj.setString("field", "value");`

```java
ApiObject testObj = new ApiObject();

// Default Usage
testObj.setString("name", "Scott");
testObj.setInteger("age", 18);
testObj.setDateTime("birthday", OffsetDateTime.now());

// Fluent Usage
testObj.createObject("devices")
   .setString("email", "test@example.com")
   .setString("phone", "111-111-1111");

// Arrays
testObj.createList("root");

ApiObject objFirst = testObj.getListAdd("root");

objFirst.setString("field1", "entry");
objFirst.setString("field2", "entry");

testObj.getListAdd("root")
    .setString("field1", "email")
    .setString("field2", "Scott");
```

## Example Accessing Fields

Using the example in the Setting Fields, here is how you would access fields in an ApiObject

```java
String strName = testObj.getString("name");

Integer age = null;

if (testObj.isSet("age")) {
    age = testObj.getInteger("age");
}

// Access Array Entries via JSONPath like handling
String field1 = testObj.getString("root[0].field1");

// Access Array via a search field
String entryScott = testObj.getString("root[field1=email].field2");

// Access Array and return first matching object
ApiObject row2 = testObj.getObject("root[field1=email]");

// Access and object and return a field value
String email = testObj.getString("devices.email");
```