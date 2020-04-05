# World
CA1 - Celso Martins - 2017216

Creational Design Patterns - Justification

• BUILDER PATTERN: This pattern was implemented in an inner class at Country.java.
I believe this pattern fit the needs of the Country because it would have many attrributes as parameters which would make the creation of 
the object Country a bit messy if not this pattern.
.

• SINGLETON PATTERN (Lazy Initialisation): This pattern was implemented in the DataSourceSingleton.java for this being the access point to
the database, I believe it is a good choice of implementation because it keeps someone from inheriting anything from the class.
The method Lazy Initialisation was chosen because it only creates the instance when needed, avoiding unnecessary processing.
*It could also be applied to Menu.java
