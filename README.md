# Virtual_Bingo

## Notes
```
- Falto realizar el frontend del juego de bingo.
- Falto realizar la integración de nodejs y java.
```

La empresa "El Gran Buda", una casa de juegos de apuestas y azar, requiere desarrollar un Bingo
virtual, bajo los siguientes requerimientos.
1. Cada persona deberá ser un usuario del sistema, usted puede usar lo que más le convenga como
por ejemplo:
- El clásico usuario y contraseña.
- Identificación con cualquier red social.
- Identificación con cuentas de correo como por ejemplo de Gmail, Outlook, entre otros.
- Identificación por medio alguna wallet como por ejemplo MetaMask (web 3.0)
2. Los usuarios (backend) serán manejados con NodeJS + MongoDB.
3. El frontend puede ser desarrollado en Angular, ReactJS, VueJS o cualquier otro framework y/o
librería, como también lo puede hacer en HTML puro producido desde NodeJS bajo la tecnolog
que usted desee escoger.
4. La comunicación entre el frontend y el backend, debe ser de forma exclusiva por medio de fetch,
axios o cualquier otro método que use la tecnología AJAX; si desea usar websockets también
puede hacer, no hay problema.
5. El backend, es decir, quien maneja la lógica del negocio, deberá ser escrita en Java con Spring
Boot.
6. La base principal debe usar MySQL, PostgreSQL, Oracle o MSSQL.
7. El backend en Java, sí requiere información de un usuario, el sistema deberá solicitarlo a NodeJ
a través del consumo de un API.

## Routes

# Autenticación

Ruta para la pagina de inicio:
```
http://localhost:3000/
```
![home](https://user-images.githubusercontent.com/63930976/158111771-6eb956dc-9b13-4ec8-9ce9-1de767eddc8e.PNG)

Ruta para el registro:
```
http://localhost:3000/signup
```
![register](https://user-images.githubusercontent.com/63930976/158111908-f5e590d9-2d1f-46f0-adab-b2c4a4d1ff8b.PNG)


Ruta para el login:
```
http://localhost:3000/signin
```
![login](https://user-images.githubusercontent.com/63930976/158111919-4dc43475-dd77-4da4-b448-935b071909e6.PNG)

Ruta para la sala del juego:
```
http://localhost:3000/bingo
```
![bingo](https://user-images.githubusercontent.com/63930976/158111928-b9bf561d-e556-4e5f-864d-78c5d389cc7e.PNG)

# Juego

GET:
Consultar los datos.
```
localhost:8080/games
localhost:8080/users
localhost:8080/ballots
```

POST:
Agregar datos
```
localhost:8080/game
localhost:8080/game/bingo/:id
localhost:8080/user
localhost:8080/ballot
```
PUT:
Actualizar datos por id
```
localhost:8080/game/:id
localhost:8080/user/:id
localhost:8080/ballot/:id
```

DELETE:
Eliminar datos por id
```
localhost:8080/game/:id
localhost:8080/user/:id
localhost:8080/ballot/:id
```

PATCH:
Actualizar al ganador por id
```
localhost:8080/game/winner/:id
```
