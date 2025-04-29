# **📚 Library Management System**  
Este proyecto es una biblioteca en la cual se pueden buscar, crear o eliminar libros por ID o en general.

# **🛠️ Conexión a la Base de Datos**  
Para conectarse a la base de datos, copia el path de tu WalletLibrary local y pégalo en la primera línea del archivo application.properties.

# **🔐 Autenticación y Seguridad - JWT**  
Para acceder a los endpoints de la API, se implementó JWT Authentication.  
Solo usuarios autenticados pueden acceder a los recursos protegidos.

# **🧾 Login**  
🔗 POST → http://localhost:8080/api/auth/login

```json
{
  "username": "admin",
  "password": "password"
}
```

✅ Si los datos son correctos, recibirás un token JWT.  
❌ Si no, obtendrás un error de credenciales inválidas.

# **📥 Usar el Token**  
Agrega el token en el header de tus requests así:

```makefile
Authorization: Bearer [Token]
```

# **📚 Endpoints**  
🔍 Obtener todos los libros  
GET → http://localhost:8080/api/books

🔍 Obtener libro por ID  
GET → http://localhost:8080/api/books/{id}

Ejemplo:  
http://localhost:8080/api/books/1

⚠️ Si recibes error 403, asegúrate de estar autenticado correctamente.

# **🚀 Documentación Swagger**  
La API cuenta con documentación interactiva generada por Swagger.  
Puedes consultarla en:<img width="1469" alt="Screenshot 2025-04-24 at 10 49 51 p m" src="https://github.com/user-attachments/assets/c8147ab7-1664-4752-9621-9a354ca1a314" />

http://localhost:8080/swagger-ui/index.html

# **🆕 Nuevas Funcionalidades en esta Versión**  

🔐 Secure the API:  
- Se implementó autenticación con JWT.  
- Solo usuarios autenticados pueden acceder a ciertos endpoints.  
- Se creó un endpoint para emitir tokens JWT tras el login.  

📄 Swagger Integration:  
- Se integró Swagger en la aplicación Spring Boot.  
- Todos los endpoints están documentados con anotaciones Swagger.

  
# **🆕 Evidencias **  

Generación de token por autenticación:  

<img width="1469" alt="Screenshot 2025-04-24 at 10 49 51 p m" src="https://github.com/user-attachments/assets/c8147ab7-1664-4752-9621-9a354ca1a314" />

Uso de token para endpoints: 

<img width="1469" alt="Screenshot 2025-04-24 at 10 55 52 p m" src="https://github.com/user-attachments/assets/7c799693-c760-4926-8a43-68b44db35461" />

<img width="1469" alt="Screenshot 2025-04-24 at 10 56 06 p m" src="https://github.com/user-attachments/assets/d1c4dc7b-e1b8-4032-beef-dd1a5a3999ab" />

Swagger Documentation:

<img width="1469" alt="Screenshot 2025-04-24 at 10 56 59 p m" src="https://github.com/user-attachments/assets/43da77ff-be24-4efe-a090-ec85a37ab6da" />
# Web2
