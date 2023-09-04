# Spring-boot-security-https

Project is a Spring Boot application that has been secured using HTTPS protocol with an SSL/TLS certificate.

## HTTPS Security

The application has been secured using an SSL/TLS certificate, ensuring secure connections to the server. We use a keystore file for securing the application.

### Keystore Information

- Keystore file: `keystore.p12`
- Keystore password: `password`


## Technologies

- Spring Boot 3.1.3
- Spring Security 6.1.3
- H2DB


## Running the Application

1. Clone the repository:
2. Open your web browser and go to:
```
https://localhost:443
```

## How to Use

```
/api/admin - admin panel
/api/admin/user-form - new user
/api/admin/users-list - users list
/api/admin/user-delete/{id} - delete user

/api/users/profile-json - profile (JSON)
/api/users/profile - profile
```

## Additional Information

- U can log as:
```
admin/123
user/123
``` 
