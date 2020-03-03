# SocketChat
Tarea número uno de Datos 1, primer semestre del 2020.  

### Instalación e Instrucciones de uso.
### 1.  
El código que se encuentra en este repositorio se podría decir que está incompleto, corresponde a todo el código referente a
un cliente de la aplicación, pero para que el código funcione en primera instancia, es necesario tener ejecutándose un servidor
al cual el cliente se conectará automáticamente.
A continuación el repositorio del servidor: https://github.com/diabloget/Server

### 2.  
Una vez descargados el código correspondiente al cliente y el código del servidor, tendremos que correr en primer lugar el
servidor, luego correremos el cliente. Para tener más clientes es necesario copiar el código del cliente que ya descargamos 
tantas veces como clientes queramos, es decir, cada copia equivale a otro cliente una vez que hagamos correr su código.

### 3.  
Para iniciar un chat de un cliente a otro debemos de colocar el puerto del cliente al que queremos hablar en el buscador de 
puertos que tiene el cliente con el que escribiremos el mensaje, el se iniciará una vez que enviemos un mensaje al puerto 
buscado.  
El buscador de puertos se encuentra en la esquina superior izquierda de cada cliente, adicionalmente al lado del buscador 
encontraremos el puerto que corresponde a dicho cliente.  
  
### La mejor forma de explicar el funcionamiento a partir de aquí es con un ejemplo:   
Teniendo un cliente #1 y un cliente #2 abiertos (el # es para identíficarlos y no tiene un valor real), vamos a enviar un
mensaje del clliente #1 al #2, para ello iremos al #2 y daremos click al label que nos indica su puerto, ubicado en la parte 
superior de éste, con ésto tendremos dicho puerto copiado en el portapapeles. Posteriormente, iremos al cliente #1 y en su
buscador de puertos pegaremos el puerto del cliente #2 anteriormente copiado, tenemos que presionar la tecla enter justo después
sabremos tuvimos éxito si en el centro de la aplicación del cliente #1 el cuadro blanco se torna griz. En este punto basta con
escribir un mensaje en el textfield de la parte inferior de la ventana del cliente #1 y presionar de nuevo la tecla enter.
Veremos como la ventana del cliente #2 cambia y aparece el mensaje que enviamos desde el cliente #1.  
  
Nota: El cliente #2 está listo para mantener mensajes con el cliente #1 sin necesidad de escribir el puerto del cliente #1
ya que el cliente sabe quién le acaba de escribir y con ello se prepara para que nosotros respondamos sin mayor esfuerzo.

### ¿Qué hacer para tener diferentes conversaciones con un cliente?  
Si tenemos tres clientes y con dos de ellos le escribimos al tercer cliente, veremos como a la izquierda aparecerá el puerto
de ambos clientes listados como chats recientes, para cambiar el chat con cualquiera de ellos dos, debemos de colocar su 
respectivo puerto en el buscador y presionar enter, veremos como los mensajes correspondientes al puerto ingresado aparecen
en pantalla.
