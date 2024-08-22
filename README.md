# SpringAIAgent
AI Agents y Spring AI

# Introducción: El futuro de los sistemas de información inteligentes con agentes IA

La evolución de los sistemas de información en las empresas se está orientando cada vez más hacia la integración de agentes IA (Inteligencia Artificial). Estos agentes están diseñados para automatizar tareas, mejorar la eficiencia y optimizar los procesos de toma de decisiones en las empresas.

## 1. **Agentes IA en los Sistemas de Información**
- Las futuras versiones de los modelos de lenguaje (LLMs) estarán fuertemente orientadas hacia los agentes IA.
- Estos agentes permitirán a las aplicaciones empresariales aprovechar la IA para automatizar diversas tareas en los sistemas de información.

## 2. **Automatización de Tareas**
- El uso de la inteligencia artificial permitirá automatizar tareas complejas, reduciendo así la carga de trabajo manual.
- Esta automatización proporcionará mayor precisión, rapidez y coherencia en la gestión de procesos.

## 3. **Uso de Herramientas en los Agentes IA**
- Las herramientas (tools) son el núcleo de los agentes IA. Pueden incluir servicios, funciones e incluso solicitudes a servicios externos.
- Por ejemplo, una herramienta puede configurarse para realizar búsquedas en la web o conectarse a fuentes externas como los mercados financieros para recuperar datos en tiempo real.

## 4. **Aplicaciones Prácticas**
- El agente IA puede utilizar estos datos para generar informes en tiempo real que proporcionen indicadores clave para la toma de decisiones.
- El objetivo principal es facilitar y mejorar el proceso de toma de decisiones en las empresas utilizando indicadores basados en datos actualizados y relevantes.

## Conclusión
La integración de agentes IA en los sistemas de información representa un avance significativo hacia la automatización inteligente de tareas y la mejora de los procesos de toma de decisiones en las empresas. Estas tecnologías permitirán a las empresas mantenerse competitivas al optimizar sus sistemas de información para el futuro.


# Explicación de la class `Tool1` :

Este código es un ejemplo de cómo utilizar Spring para crear una herramienta ("tool"), que es esencialmente una función encapsulada dentro de un servicio de Spring. Este servicio se puede usar para manejar solicitudes específicas en el contexto de una aplicación.

## 1. **Declaración de la clase `Tool1`**
- La clase `Tool1` está anotada con `@Service`, lo que indica a Spring que esta clase debe ser gestionada como un servicio de Spring. Los servicios en Spring son componentes de la aplicación que contienen la lógica de negocio.

## 2. **Implementación de la interfaz `Function`**
- `Tool1` implementa la interfaz `Function` de Java, que toma dos tipos genéricos: un tipo para la entrada (`Request`) y un tipo para la salida (`Response`).
- Esta interfaz tiene un método abstracto `apply` que se implementa para definir la lógica de transformación entre la entrada y la salida.

## 3. **Definición de las clases internas `Request` y `Response`**
- **Request**: Un record que contiene un solo campo `company` de tipo `String`. Este es el dato de entrada que recibirá tu función.
- **Response**: Un record con cuatro campos: `company` (el nombre de la empresa), `country` (el país de la empresa), `domain` (el dominio de la empresa), y `foundationYear` (el año de fundación). Esta es la respuesta que devuelve tu función.

## 4. **Método `apply`**
- El método `apply` recibe una instancia de `Request` como entrada y devuelve una instancia de `Response`.
- En este ejemplo, el método `apply` devuelve valores estáticos (por ejemplo, `"info1"` para `country` y `domain`, y `1923` para `foundationYear`). En una aplicación real, esta información probablemente se obtendría de una base de datos u otra fuente de información.

## 5. **Anotación de descripción**
- El código menciona agregar una anotación de descripción para la herramienta. Esta anotación permite proporcionar metadatos que describen la función, lo cual es esencial cuando se trabaja con modelos de lenguaje (LLM) u otros sistemas que necesitan comprender la función de manera semántica.
- Esta descripción podría incluir información sobre los tipos de datos manejados, las transformaciones realizadas, etc.

## 6. **Uso en un contexto más amplio**
- En un contexto de uso con un LLM, esta función podría registrarse y exponerse bajo el nombre `countryIdentityInfo`, permitiendo así que una aplicación o modelo sepa qué información puede proporcionar esta función.
- Cuando se envía un prompt al LLM, la función se llama con la información pertinente, y el resultado se utiliza para completar la tarea solicitada.

## 7. **Prueba y validación**
- El código menciona la realización de una prueba para verificar si la función es reconocida correctamente y si funciona en el contexto de Spring y del LLM.

## 8. **Evolución del código**
- El ejemplo muestra que este servicio es solo un punto de partida. Se podrían agregar otras funciones para ampliar las capacidades de la aplicación. Cada función adicional también se describiría para ser comprensible por el LLM u otros sistemas.

Este código demuestra cómo encapsular una lógica de negocio simple dentro de un servicio de Spring, y cómo describir este servicio para que pueda ser utilizado en sistemas más amplios, potencialmente impulsados por modelos de lenguaje. Esto constituye una base para la creación de servicios más complejos e interactivos en un entorno Spring.

# Explicación del Código: Bucle Dinámico con LLM y Spring

En este ejemplo, estás utilizando un enfoque que combina **Spring** y **LLM** (Modelos de Lenguaje Grande) para ejecutar funciones de manera dinámica. La idea principal es crear un bucle que interactúe continuamente con el LLM para obtener y ejecutar funciones, luego procesar los resultados y repetir el ciclo según sea necesario.

## 1. **Descripción del Bucle Dinámico**
- **Interacción con LLM**: El proceso comienza enviando una solicitud al LLM. El LLM devuelve las funciones que se pueden ejecutar.
- **Ejecución de Funciones**: A continuación, el sistema llama a las funciones indicadas, obtiene los resultados y los procesa.
- **Bucle Continuo**: Este proceso se repite en un bucle, donde cada interacción con el LLM puede generar nuevas funciones a ejecutar. Este ciclo permite una interacción continua y dinámica con el LLM.

## 2. **Manejo de Funciones con LLM y Spring**
- Si el LLM no admite directamente herramientas o funciones específicas, es necesario implementar este bucle manualmente. En un entorno como **Python**, se debe manejar manualmente la recuperación del nombre de la función, la ejecución de la función, y la recolección de la respuesta.

## 3. **Implementación en Código**
- A continuación se muestra un ejemplo de cómo se puede implementar este proceso en Java utilizando Spring:

   ```java
   public String analisisReport(String company) {
       return chatClient
               .prompt()
               .system(systemMessagePrompt)
               .user("Company : " + company)
               .functions("tool1", "tool2")
               .call().content();
   }
Descripción del Código:
prompt(): Inicia una nueva solicitud al LLM.
system(systemMessagePrompt): Especifica el mensaje del sistema que debe guiar al LLM en la ejecución de las funciones.
user("Company : " + company): Pasa la entrada del usuario (en este caso, el nombre de la empresa) al LLM.
functions("tool1", "tool2"): Indica al LLM qué funciones están disponibles para ser llamadas.
call().content(): Ejecuta el prompt y devuelve el contenido de la respuesta del LLM.
4. Implementación de un Bucle en Python
   Si se trabaja en Python, se tendría que implementar un bucle que haga lo siguiente:
   Enviar una solicitud al LLM.
   Recuperar el nombre de la función desde la respuesta.
   Ejecutar la función y evaluar los resultados.
   Generar un nuevo mensaje basado en la respuesta.
   Añadir el mensaje a la lista de mensajes y repetir el ciclo.

Este enfoque permite a las aplicaciones empresariales interactuar de manera dinámica y continua con un LLM, utilizando Spring para orquestar la ejecución de funciones. Implementar este bucle en el código es esencial para que el agente pueda tomar decisiones y ejecutar tareas de forma autónoma, lo cual es fundamental en la automatización de sistemas de información inteligentes.


Este resumen explica el concepto del bucle dinámico en la interacción con un LLM utilizando Spring y da una idea clara de cómo se podría implementar en Python si fuera necesario.
