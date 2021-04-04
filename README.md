# Kartaca




# Çekirdekten Yetişenler 2021 - Uygulama ve Servis Geliştirme Görevi
<h4>Kartaca - Çekirdekten Yetişenler 2021 - Uygulama ve Servis Geliştirme Görevi. Java Spring - MongoDB Çözümü.</h4>

{github_user_name}/{repo_name}/{branch}/.github/images/{aset_name}.{asset_extension}

![image](https://raw.githubusercontent.com/basarYargici/Kartaca-dd41b700-94f2-11eb-9ac5-559755036f29.png)

<h4>Anahtar Kod:</h4>
gAAAAABgUMFncaQC0bE6YwAYOoll4iwFHSV38hj5YcKokvqxQdXLWQRoHwkYpKaloACOmAJJuqTO8O91UawmOeQ0j7CU2Dch-FAWl5mUOUuwZ0hv1j_6yY2Uxy7uIZ4mLIX4o_f4wGrQsLbrdDdntUqHvZiS93ig_p2wr0g5zq2ssnU_Nqg6fEwcNu7pDwoUXvwSpmPnOYvW
<br/><br/>

# Görev İçeriğine Ulaşırken Kullanılan Kod
Görev içeriğinin çıkartıldığı klasörde;

```
$ for ((i=0 ; i < $(ls -1q | wc -l); i++)); do printf $i | base64 -w 4| xargs cat | perl -ape '$_=pack"(B8)*",@F'; done
```
Kodda kullanılan perl komutu sadece 8-bit karakterleri ASCII formata çevirmeye yarıyor. Bu durumda Türkçe karakterleri yanlış çeviriliyor. Kod bu şekilde anlaşılabilir sonuç veriyor ama yine de bütün karakterlerin çevirilmesi istenirse pipe ile utf-16 karakterleri çevirebilen bir script kullanılabilir.

# Uygulamayı Çalıştırma
Uygulama aşağıdaki kod ile derlenip çalışır hale getirilebilir;
```
$ docker-compose --file docker_compose.yml up --build
```
Kod çalıştırıldıktan sonra 1.5 - 3 dakika içinde uygulama hazır olacaktır.

# Uygulamanın Kullanımı
<h4>Arayüz adresi: localhost:8080</h4>
<h4>Servis Endpoint Adresi: localhost:8080/requestHandler</h4>
<h3>Servis Endpoint'lerine İstek Atma:</h3>
  
  <h4>Endpoint adresine istek atmanın yollarının bazıları:</h4>
  <ul>
    <li>cURL kullanarak aşağıdaki kod ile istek atılabilir;
      
      $ curl -X {istek-tipi} localhost:8080/requestHandler
      
   <li>Postman, Swagger vb. uygulamalar kullanılabilir.
   <li>Arayüzdeki butonlar ile istek atılabilir.
  </ul>
  
# Notlar
<ul> 
<li>Uygulama hazır olduktan sonra 1dk içerisinde Kafka ile bağlantısını tamamlar. Kafka ile bağlantısı tamamlandıktan sonra gelen istekler doğru şekilde veritabanına ve grafiğe yazılır</li>
<li>Uygulama isteğin gönderildiği anın zaman bilgisini (timestamp) yazar. Cevaplandığı anın zaman bilgisini yazdırmak için WriteLog() fonksiyonunun parametrelerinin sıralaması düzenlenebilir</li>
<li>Grafiğin son kaç milisaniyenin verilerini gerçek zamanlı göstereceği "src/main/resources/static/dashboard.js" üzerinde 86. satırdaki duration değerinin düzenlenmesi ile değiştirilebilir (Güncel değer 3600000 milisaniye (1 Saat))
</ul>
