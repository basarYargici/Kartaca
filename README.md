# Kartaca


* start zookeeper and kafka  <br>
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties <br>
.\bin\windows\kafka-server-start.bat .\config\server.properties


* send message <br>
curl -X POST http://localhost:9000/kafka/publish -d message='I am publishing a message!'.


* get all data from kafkaTopic<br>
D:\kafka_2.13-2.7.0\bin\windows>kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic kafkaTopic --from-beginning<br>
