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
