**Creando una Interfaz Simple, y enviarla a otra Actividad.**

- **Descripción**: Crear una interfaz con componente simple, con la idea de que el usuario se comience a familiarizar con esta tecnología.
Se creará una vista principal, donde se deba introducir un nombre, un apellido, genero, fecha de nacimiento, responder si le gusta programar, y cuales lenguajes le gusta.

- **Objetivo**: Que el estudiante sea capaz de diseñar e implementar una vista con componentes simples, tales como: Button, Text view, Plan view, Sppiner, Radio button y Check box.

- **Diseño**: EL diseño de la aplicación debe quedar muy similar a las siguientes imágenes

Vista principal, donde el usuario debe introducir los datos. Figura 1

Vista secundaria, donde se le mostraran los datos al usuario. Figura 2



- **Comportamiento**: El usuario deberá realizar las siguientes acciones:

1. Introducir un nombre.
1. Introducir un apellido.
1. Seleccionar un género.
1. Establecer una fecha de nacimiento.
1. Seleccionar si le gusta programar, y cuales lenguajes.
1. Al presionar el botón enviar, la información debe ser mostrada en una segunda vista, como se muestra en la figura 2.
1. Al presionar el botón limpiar, deberá limpiar todos los campos, establecer el género en el índice 0, y la opción de le gusta programar a Si.
- **Validaciones**:

- Los campos nombre, apellido, y género, son obligatorio. En caso de que no tenga datos, debe mostrarle un mensaje al usuario.
- La fecha de nacimiento debe ser con componente DatePicker.
- Si la opción de le gusta programar esta activa, debe haber seleccionado al menos un lenguaje.
- Si la opción de le gusta programar esta inactiva, no puede seleccionar ningún lenguaje.
- Todo esto debe ser validado al presionar el botón enviar.

- Notas:

- A la inicial la aplicación debe estar todo vacío, excepto, género que debe estar en el índice 0, y la opción de le gusta programar en Si.
- Cualquier funcionalidad extra agregada, será tomada en cuenta en la calificación de la tarea.
- Se valora, cambio de color, y cambios en la presentación de los componentes.
- La ausencia del uso de los componentes principales (lo que aparecen en la figura 1) será considera como falta.