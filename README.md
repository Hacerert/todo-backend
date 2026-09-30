# Todo App Backend

Spring Boot ile geliştirilmiş Todo uygulaması backend servisi.

## Teknolojiler

- Java 27
- Spring Boot
- Spring Data JPA
- PostgreSQL
- JWT Authentication
- Docker

## Özellikler

- Kullanıcı kayıt olma
- Kullanıcı giriş yapma
- JWT token üretme
- Todo ekleme
- Todo listeleme
- Todo güncelleme
- Todo silme

## Çalıştırma

### Maven

```bash
mvn spring-boot:run
```

### Docker

```bash
docker build -t todo-backend .
docker run -p 8080:8080 todo-backend
```

## API

Backend varsayılan olarak:

```text
http://localhost:8080
```

adresinde çalışır.
