# MultiModel Demo Notes

## Before you begin

Create a Namespace - `Multimodel` - you won't need Interoperability to uncheck that

## Demo the Object Model
1. Start VS Code in this direction. 
2. Run `mvn compile exec:java -Dexec.mainClass="demo._Main"`
3. Press 1 to create the participant schema.  Observe via DBeaver the schema that's created.
4. Press 3 to populate the participants.  Observe how Address and PhoneNum are handled.

## Demo the SQL Model
1. Start DBeaver
2. Run the SQL to create the schema.  Observe that a class is now created in IRIS.
3. Populate the table

## Demo the Document Model
1. Start Postman
2. Create the DocDB.  Observe the schema.
3. Create the properties
4. Insert a single document. Observe the schema
5. Populate the table - Go back to Java and press option 5 to create a ton of dummy test results

## Demo the KeyValue Model
1. TBD

## Demo Reporting/Querying across models
1. TBD - more fancy queries in DBeaver, most likely.  Maybe option to show off ISC Reports?

## Demo Cubes
1. TBD - Create the cube, maybe switch to Hole Foods if the data just isn't very interesting?

## Discuss further
1. Reminder - the power is that data is stored in infinitely-variable globals.  Structure is given via classes.  Classes are extensible.
2. Show some neat things done by the community - graph, geospatial, color index (note embedded py)



# Random Notes

Overview
* The demo overview
* Object model
    * in Java => XEP create database. 
    * Populate database. 
    * Show that the objects are now available in IRIS
    * Show that the data is now available in SQL
    * Should we show sub-objects? - we should have good answers about when is appropriate to use XEP and when it isn't.  
    * Talk about future full binding?
    * They will ask about versioning - good answers?
    * Mention hibernate for complex structures, but it's an ORM and not really a true Object model
* Document model
    * In Postman, create the database
    * Populate the database
    * Show that the objects are not available in IRIS
    * Show that the data is now available in SQL
    * Add some properties
    * Query based on the properties in REST, then in SQL
* Key-Value model
    * Talk about the IRIS being the definition of a key-multi-value stores
    * Import the OpenAPI spec
    * See the objects are created? SQL-able?
* Relational model
    * Create tables via SQL
    * See that they are objects in IRIS
    * Do some fancy reports based on data in all the above models
* BI / Cubes
    * Ask BDB for help

Interesting things to point out
* A data model is a series of tools built on top of Globals and ObjectScript objects
* Community partners have created graph, timeseries, etc.  


# Redis API - Compares easily with COS

SET foo:bar "fido"
GET foo:bar
EXISTS foo:bar
DEL foo:bar
SET connections 10
INCR connections
DECR connections
DECRBY connections 2
EXPIRE connections 60
TTL connections <-- how much longer do you live
PERSIST connections
RPUSH friends "george"
LPUSH friends "fred"
LRANGE friends 0 -1
LPOP
RPOP
SADD superpowers "flight" "reflexes"
SREM superpowers "flight"
SISMEMBESR superpowers "flight"
They also have sorted sets (ZADD, ZDEL, ZRANGE, etc)
They also have hashes

