# Proyecto de mensajeria Asincrona.

Un publicador sera responsable de generar mensaje o cualquier dato serializable, es decir, que le permita transformar esta informacion en este caso en JSON para que pueda ser recepcionada
por el Suscriptor.

El mensaje serializado es enviado a un tópico o canal de distribucion.

El suscriptor por su parte se encarga de "escuchar" o consultar de forma periodica al topico previa configuracion para que pueda recepcionar el mensaje enviado desde publicador.

¿Por que resulta util? La asincronia de este proceso permite resguardar la recepcion de la informacion y desaclopar responsabilidades de los sistemas puesto que ninguna de las dos
partes requiere comunicacion directa.

### Especificaciones Técnicas
+ Java v21
  + Framework:Spring Boot 3.3.0
  + Maven
+ ActiveMQ
 
### Inicio:
+ Desde consola Ejecuto ActiveMQ en mi local
  ![image](https://github.com/user-attachments/assets/64b3bf2a-b5d9-4f2d-9717-c6faf7821ec4)

+ Valido Activacion 
![image](https://github.com/user-attachments/assets/43729fff-e852-4c11-845d-cef3ab488776)

+ "Run" SpringBoot Application
  ![image](https://github.com/user-attachments/assets/e25d4c41-c0d4-482b-8b59-153127bed6fa)

+ Valido procesamiento de Preocursor  "Producer" y Suscriptor "Suscribers"
  ![image](https://github.com/user-attachments/assets/2f2a549b-fb92-4abc-bc65-5305889faa2f)



