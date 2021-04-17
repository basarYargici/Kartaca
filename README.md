# Kartaca Çekirdekten Yetişenler 2021

<h4>Java Spring Boot - MySQL - Apache Kafka - Docker</h4>
 
<h4>Anahtar Kod:</h4>
gAAAAABgUH5-8nF5PJBTXf_qjrJngiImF5R-UfDdhsGr6gcpBfcfbLojoT_XbrBt4bLlsHW83JPLjZZng7lgCugKOdBmSgktE6HcccN5Z-LbZqzIQZH3VEMHwYF5TQNhnLz8736a5QVdMt0KJCBynP9h-ul2eGSgYUEkrnfumDRaskUOe3OFc3YPDm3q55Maq3WP8wvcopNKz8ZvAMf7p_WwUvxWzk-r8w==
<br/><br/>

# Zip Görev Çözümü
[Zip Çözüm Dosyası](https://github.com/basarYargici/Kartaca/tree/dev/src/main/java/SolveZIP) <br>
[Zip İçeriği](https://github.com/basarYargici/Kartaca/blob/dev/src/main/java/SolveZIP/ZIPContent.txt)

# Uygulamanın Kullanımı
Spring boot uygulaması başlatılmadan önce kafkanın logları okuyabilmesi için zookeeper ile kafkanın çalıştırılmış olması gerekmektedir.<br>
Kullanıcının Windows kullanıcısı olduğunu ve Kafka dosyasının "D:\kafka_2.13-2.7.0" adresine kurulu olduğunu varsayarak:<br>
zookeeper başlatmak için <br>
``.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties``
 
kafkayı başlatmak için <br>
 ``.\bin\windows\kafka-server-start.bat .\config\server.properties``
<br>
komutlarını girmesi gereklidir.

   <h3> Uygulamayı başlatma adımları:</h3>
    <ul>
        <li> Zookeeper'ı başlatmak
            ![zookeeper_başlat](https://github.com/basarYargici/Kartaca/blob/dev/assets/(3)%20zookeeper%20work.png)</li>
        <li> Kafka'yı başlatmak
            ![kafka_başlat](https://github.com/basarYargici/Kartaca/blob/dev/assets/(2)%20kafka%20work.png)</li>
        <li> Spring boot application'ı başlatmak 
            ![spring_boot_başlat](https://github.com/basarYargici/Kartaca/blob/dev/assets/(1)%20spring%20work.png)</li>
     </ul>

<h4>Arayüz adresi: localhost:8080</h4>
<h3>Servis Endpoint'lerine İstek Atma:</h3>
  
  <h4>Endpoint adresine istek atmanın yolları:</h4>
  <ul>
   <li> http://localhost:8080/api/cities üzerinden tüm şehirlere JSON formatında ulaşılabilir 
       ![şehirler](https://github.com/basarYargici/Kartaca/blob/dev/assets/(4)%20get%20all%20cities.png)</li>
   <li> http://localhost:8080/api/cities/{id} üzerinden id si belirtilen şehire JSON formatında ulaşılabilir 
       ![şehir](https://github.com/basarYargici/Kartaca/blob/dev/assets/(7)%20get%20city%20by%20id.png)</li>
   <li> http://localhost:8080/api/cities/add üzerinden veritabanına yeni şehir eklenebilir 
       ![şehir_ekle](https://github.com/basarYargici/Kartaca/blob/dev/assets/(8)%20add%20city.png)</li>
   <li> http://localhost:8080/api/cities/delete üzerinden veritabanından şehir sillinebilir 
       ![şehir_sil](https://github.com/basarYargici/Kartaca/blob/dev/assets/(8)%20add%20city.png)</li>
   <li> http://localhost:8080/api/cities/update üzerinden veritabanındaki bir şehir güncellenebilir 
       ![şehir_güncelle](https://github.com/basarYargici/Kartaca/blob/dev/assets/(8)%20add%20city.png)</li>
   <li> bu işlemler aynı zamanda log verileri ile de yapılabilir
       ![loglar](https://github.com/basarYargici/Kartaca/blob/dev/assets/(12)%20all%20logs.png)</li>
   <li>Postman, Swagger vb. uygulamalar kullanılabilir.</li>
  </ul>

<h3> Tüm bu request işlemleri gerçekleşirken arkada gerçekleşen işlemler:</h3>
    <li>Loglar istenen şekilde ( "{metot tipi},{istek cevaplama ms},{timestamp}" ) local bir dosyaya kaydedilir
          ![log_dosyası](https://github.com/basarYargici/Kartaca/blob/master/assets/(13)%20LogContent.log%20file.png)
    <li>Loglar istenen şekilde ( "{metot tipi},{istek cevaplama ms},{timestamp}" ) veritabanına kaydedilir
          ![log_veritabanı](https://github.com/basarYargici/Kartaca/blob/dev/assets/(14)%20log%20table.png)
    <li>Bu sırada kafka requestleri real time dinler ve topic'e logları kaydeder
          ![topic](https://github.com/basarYargici/Kartaca/blob/dev/assets/(6)%20consumer%20real%20time%20logs2.png)
    <li>http://localhost:8080/api/graph adresine atılan istek sonucunda grafiğe ulaşılır.
          ![grafik](https://github.com/basarYargici/Kartaca/blob/dev/assets/(15)%20graph.png)
          
# Uygulamayı Çalıştırma
Docker implementasyonu için gereken zamanı sağlık sorunlarımdan kaynaklı bulamadım. Veritabanı bağlantısında sorun yaşadım ve daha fazla üzerinde duramadım. Bundan dolayı uygulamayı kendi programınızda derleyip çalıştıramazsınız. Ancak kendi bilgisayarımda çalışır halde olduğu için ekran görüntüleri ile burada anlatmaya çalıştım.

# Proje hakkında
Verilen bu görev ile birlikte 2 hafta içerisinde daha önce edinmediğim tecrübeler edindim. Kendi adıma ilkler dizisi oldu bu görev. 
 <ul>
    <li>Spring Boot ile ilk kez bir proje çıkardım ve JAVA ile ilk kez REST API yazdım</li>
    <li>Apache Kafka'yı bu proje ile birlikte ilk kez duydum ve projemde kullanarak producer-consumer yapısını kurdum</li>
    <li>Her ne kadar tamamlayamasam da Docker ile de ilk tanışmam ve üzerinde kafa yormam bu proje ile gerçekleşti</li>
 </ul> 
