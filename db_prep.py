import MySQLdb as mdb

con = mdb.connect('localhost','root','','svs_console')

with con:
    cur = con.cursor()
    cur.execute("Use svs_console")
    cur.execute("Drop table if exists user")
    cur.execute("Drop table if exists customer")
    cur.execute("Drop table if exists item")
    cur.execute("Drop table if exists orders")
    cur.execute("Drop table if exists orderline")

    cur.execute("Create table user(Id int primary key auto_increment, FirstName Varchar(25), LastName Varchar(25), UserName Varchar(25), Password Nvarchar(25), EntityKey Varchar(25))")
    cur.execute("Create table customer(Id int primary key auto_increment, Name Varchar(35), Address Nvarchar(35), EntityKey Varchar(25))")
    cur.execute("Create table item(Id int primary key auto_increment, Name Varchar(35), Description NVarchar(255), EntityKey Varchar(25))")
    cur.execute("Create table orders(Id int primary key auto_increment, CustomerId Varchar(25), OrderDate datetime, Comments NVarchar(75), Status bit, EntityKey Varchar(25))")
    cur.execute("Create table orderline(Id int primary key auto_increment, OrderId Varchar(25), CustomerId Varchar(25), ItemId Varchar(25), Comments Nvarchar(75), Quantity int, EntityKey Varchar(25))")
    
    cur.execute("insert into user(FirstName,LastName,UserName,Password,EntityKey) Values('Marius','Magureanu','mm','pass','11A')")
    cur.execute("insert into user(FirstName,LastName,UserName,Password,EntityKey) Values('Vasile','Selever','vs','pass','11B')")

