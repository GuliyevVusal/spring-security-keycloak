# Keycloak ilə Təhlükəsizləşdirilmiş Spring Boot REST API

Bu layihə Spring Boot istifadə edərək REST API-nin necə yaradılacağını və Keycloak ilə təhlükəsizləşdirilməsini göstərir
Proyekt universitet və tələbə məlumatlarını idarə etmək üçün CRUD əməliyyatlarını təmin edir. Layihə həmçinin
Spring Security, JWT və MapStruct kimi texnologiyalardan istifadə edir.

## Xüsusiyyətlər:
- **Təhlükəsizlik:** Keycloak ilə OAuth2 və JWT əsasında təhlükəsizlik.
- **CRUD Əməliyyatları:** Universitet və tələbə məlumatlarının idarə edilməsi.
- **Parol Şifrələmə:** BCryptPasswordEncoder istifadə edərək parol şifrələmə.
- **DTO və Mapper:** MapStruct ilə DTO və entity map etmə.
- **CORS Konfiqurasiyası:** Global CORS konfiqurasiyası.

## Quraşdırma:
1. **Məlumat Bazası Konfiqurasiyası:** application.properties faylında MySQL məlumat bazası üçün düzgün URL istifadəçi adı və parolunu təmin edin.
2. **Keycloak Konfiqurasiyası:** keycloak.auth-server-url keycloak.realm keycloak.resource və keycloak.credentials.secret dəyərlərini öz Keycloak serverinizə uyğun olaraq dəyişdirin.
3. **Proyekti Çalışdırın:** Proyekti aşağıdakı əmr ilə çalışdırın:
      bash
    ./gradlew bootRun və ya .\kc.bat start-dev, .\kc.bat start-dev --http-port=8888 --http-management-port=9999
4. **Keycloak Konfiqurasiya faylı:**
# Basic settings for running in production. Change accordingly before deploying the server.
# Database
# The database vendor.
db=mysql
# The username of the database user.
db-username=root
# The password of the database user.
db-password=root
# The full database JDBC URL. If not provided, a default URL is set based on the selected database vendor.
db-url=jdbc:mysql://localhost:3306/education
# Observability
# If the server should expose healthcheck endpoints.
#health-enabled=true
# If the server should expose metrics endpoints.
#metrics-enabled=true
# HTTP
# The file path to a server certificate or certificate chain in PEM format.
#https-certificate-file=${kc.home.dir}conf/server.crt.pem
# The file path to a private key in PEM format.
#https-certificate-key-file=${kc.home.dir}conf/server.key.pem
# The proxy address forwarding mode if the server is behind a reverse proxy.
#proxy=reencrypt
# Do not attach route to cookies and rely on the session affinity capabilities from reverse proxy
#spi-sticky-session-encoder-infinispan-should-attach-route=false
# Hostname for the Keycloak server.
hostname=localhost
port=9999

## İstifadə:
API endpoint-ləri http://localhost:9090/security URL-i ilə mövcuddur. Məsələn:
- **Universitetlərin Siyahısı:** GET /universities
- **Tələbələrin Siyahısı:** GET /students
- **Yeni Tələbə Əlavə Etmək:** POST /students
- **Tələbə Məlumatlarını Yeniləmək:** PUT /students
- **Tələbə Silmək:** DELETE /students?id={id}
- **Tələbə Məlumatlarını ID ilə Getirmək:** GET /students/{id}

## Texnologiyalar:
- **Spring Boot**
- **Spring Security**
- **Keycloak**
- **OAuth2 ve JWT**
- **MapStruct**
- **MySQL**
- **BCryptPasswordEncoder**

![Image-4](https://github.com/GuliyevVusal/spring-security-keycloak/assets/143846119/e2529a4e-8f1f-45b4-8b64-e1b6dbdb36f3)
![Image-5](https://github.com/GuliyevVusal/spring-security-keycloak/assets/143846119/2a49eb5c-cd5a-419b-8efc-190805f0c28f)
![Image-6](https://github.com/GuliyevVusal/spring-security-keycloak/assets/143846119/5c543a3f-cf80-4fc7-a14f-0295de477df4)
![Image-7](https://github.com/GuliyevVusal/spring-security-keycloak/assets/143846119/bfcc0755-3170-4ca4-99c6-041e5f67ffad)
![Image-8](https://github.com/GuliyevVusal/spring-security-keycloak/assets/143846119/f0a90159-5069-402e-b175-5696cec19f18)
![Image-10](https://github.com/GuliyevVusal/spring-security-keycloak/assets/143846119/fda25a4f-9750-4424-984c-f60964cbe181)
![Image-11](https://github.com/GuliyevVusal/spring-security-keycloak/assets/143846119/dfb386d6-8909-44b5-b319-868318b86fdc)
![Image-12](https://github.com/GuliyevVusal/spring-security-keycloak/assets/143846119/16ae2776-5693-460d-b6a5-1ef4a87e3c43)
![Image-13](https://github.com/GuliyevVusal/spring-security-keycloak/assets/143846119/8c061cdb-4b6f-4b59-81df-7ebaa9d1d166)
![Image-16](https://github.com/GuliyevVusal/spring-security-keycloak/assets/143846119/fa043f4e-8264-49e3-b559-d1cdb4466b3a)
![Image-17](https://github.com/GuliyevVusal/spring-security-keycloak/assets/143846119/ae7be72b-cf0d-41a0-815f-34c384a43bb3)
![Image-1](https://github.com/GuliyevVusal/spring-security-keycloak/assets/143846119/6f50b096-3007-48b6-b99f-3fa9bfd953c5)
![Image-2](https://github.com/GuliyevVusal/spring-security-keycloak/assets/143846119/eb073d66-54a5-4a47-aab3-844947e8f5a1)
