# Kartaca Çekirdekten Yetişenler 2021 - Uygulama ve Servis Geliştirme Görevi
<h4>Kartaca - Çekirdekten Yetişenler 2021 - Java Spring - MySQL - Apache Kafka - Docker Çözümü.</h4>

<h4>Anahtar Kod:</h4>
gAAAAABgUH5-8nF5PJBTXf_qjrJngiImF5R-UfDdhsGr6gcpBfcfbLojoT_XbrBt4bLlsHW83JPLjZZng7lgCugKOdBmSgktE6HcccN5Z-LbZqzIQZH3VEMHwYF5TQNhnLz8736a5QVdMt0KJCBynP9h-ul2eGSgYUEkrnfumDRaskUOe3OFc3YPDm3q55Maq3WP8wvcopNKz8ZvAMf7p_WwUvxWzk-r8w==
<br/><br/>
![image](https://github.com/basarYargici/Kartaca/blob/dev/assets/(1)%20spring%20work.png)

# Zip Görev Çözümü
[Zip Çözüm Dosyası](https://github.com/basarYargici/Kartaca/tree/dev/src/main/java/SolveZIP)
[Zip İçeriği](https://github.com/basarYargici/Kartaca/blob/dev/src/main/java/SolveZIP/ZIPContent.txt)

# Uygulamanın Kullanımı
Spring boot uygulaması başlatılmadan önce kafkanın logları okuyabilmesi için zookeeper ile kafkanın çalıştırılm
ış olması gerekmektedir.
Kullanıcının Windows kullanıcısı olduğunu ve Kafka dosyasının "D:\kafka_2.13-2.7.0" adresine kurulu olduğunu varsayarak:
zookeeper başlatmak için '''.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties'''
kafkayı başlatmak için '''.\bin\windows\kafka-server-start.bat .\config\server.properties'''
komutlarını girmesi gereklidir.


<h4>Arayüz adresi: localhost:8080</h4>
<h4>Servis Endpoint Adresi: localhost:8080/world</h4>
<h3>Servis Endpoint'lerine İstek Atma:</h3>
  
  <h4>Endpoint adresine istek atmanın yolları:</h4>
  <ul>
   <li> http://localhost:8080/api/cities üzerinden tüm şehirlere JSON formatında ulaşılabilir 
       ![image](https://github.com/basarYargici/Kartaca/blob/dev/assets/(4)%20get%20all%20cities.png)</li>
   <li> http://localhost:8080/api/cities/{id} üzerinden id si belirtilen şehire JSON formatında ulaşılabilir 
       ![image](https://github.com/basarYargici/Kartaca/blob/dev/assets/(7)%20get%20city%20by%20id.png)</li>
   <li> http://localhost:8080/api/cities/add üzerinden veritabanına yeni şehir eklenebilir 
       ![image](https://github.com/basarYargici/Kartaca/blob/dev/assets/(8)%20add%20city.png)</li>
   <li> http://localhost:8080/api/cities/delete üzerinden veritabanından şehir sillinebilir 
       ![image](https://github.com/basarYargici/Kartaca/blob/dev/assets/(8)%20add%20city.png)</li>
   <li> http://localhost:8080/api/cities/update üzerinden veritabanındaki bir şehir güncellenebilir 
       ![image](https://github.com/basarYargici/Kartaca/blob/dev/assets/(8)%20add%20city.png)</li>
   <li> bu işlemler aynı zamanda log verileri ile de yapılabilir
       ![image](https://github.com/basarYargici/Kartaca/blob/dev/assets/(12)%20all%20logs.png)</li>
   <li>Postman, Swagger vb. uygulamalar kullanılabilir.</li>
  </ul>

<h3> Tüm bu request işlemleri gerçekleşirken arkada gerçekleşen işlemler:</h3>
    <li>Loglar istenen şekilde ( "{metot tipi},{istek cevaplama ms},{timestamp}" ) local bir dosyaya kaydedilir
          ![image](https://github.com/basarYargici/Kartaca/blob/dev/assets/(12)%20all%20logs.png)
    <li>Loglar istenen şekilde ( "{metot tipi},{istek cevaplama ms},{timestamp}" ) veritabanına kaydedilir
          ![image](https://github.com/basarYargici/Kartaca/blob/dev/assets/(14)%20log%20table.png)
    <li>Bu sırada kafka requestleri real time dinler ve topic'e logları kaydeder
          ![image](https://github.com/basarYargici/Kartaca/blob/dev/assets/(6)%20consumer%20real%20time%20logs2.png)
    <li>http://localhost:8080/api/graph adresine atılan istek sonucunda grafiğe ulaşılır.
          ![image](https://github.com/basarYargici/Kartaca/blob/dev/assets/(15)%20graph.png)
# Uygulamayı Çalıştırma
Uygulama aşağıdaki kod ile derlenip çalışır hale getirilebilir;
Docker implementasyonu için gereken zamanı sağlık sorunlarımdan kaynaklı bulamadım. Veritabanı bağlantısında sorun ya
şadım ve daha fazla üzerinde duramadım. Bundan dolayı uygulamayı derleyip çalıştıramazsınız. Ancak bilgisayarımda çal
ışır halde olduğu için ekran görüntüleri ile burada anlatmaya çalışacağım.  

