Demo Jetty web-app
------

Demo Jetty based web-app which exposes a rest interface meant to handle CRUD operations against an underlying datasource.

The **restful** and **dao** layers are separated by a **facade** layer which handles most of the bussines logic, whereas the **dao** layer 
is responsible of storing its data in either *Sql* or *NoSql* fashion. 
Switching between either sql/nosql is handled through an abstract factory pattern approach.

[Hibernate] (http://hibernate.org/) and [Morphia](https://github.com/mongodb/morphia) are the weapons of choice in this regards.

The glue between the **restful** and the **facade** layer has been delegated to [Guice] (https://github.com/google/guice).
