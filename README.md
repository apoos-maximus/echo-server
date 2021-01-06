# echo-server

instructions to run Concurrent TCP server/client : 

#### Server
```
cd tcp-server
mvn clean package
cd target
java -cp *.jar multi.MultiTCPServer
```
#### Client
```
cd tcp-client
mvn clean package
cd target
java -cp *.jar multi.MultiTCPClient
```

>multiple instances of the client can be spawend by running the client in multiple terminals