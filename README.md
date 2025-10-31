# Práctica Estados - Gonzalo Romero Bernal

---

# 📑 Índice

1. [Creación del proyecto](#creación-del-proyecto)
2. [Ejercicio 1 — Ficha de producto](#ejercicio-1--ficha-de-producto)
3. [Ejercicio 2 — Acciones principales en una barra](#ejercicio-2--acciones-principales-en-una-barra)
4. [Ejercicio 3 — Cambiando colores con estado](#ejercicio-3--cambiando-colores-con-estado)
5. [Ejercicio 4 — Contador doble](#ejercicio-4--contador-doble)
6. [Ejercicio 5 — Interruptor de visibilidad](#ejercicio-5--interruptor-de-visibilidad)
7. [Ejercicio 6 — Tarjeta de evento interactiva](#ejercicio-6--tarjeta-de-evento-interactiva)


---

## Creación del proyecto
**Nombre del proyecto:** practicaLayout2
**Tipo:** Empty Activity  
**Lenguaje:** Kotlin  
**Min SDK:** API 21 (Android 5.0)

---

## Ejercicio 1 — Ficha de producto
**Explicación:** Lo que se ha pedido en este ejercicio es una foto de perfil con texto superpuesto, lo que he hecho ha sido un box, introduciendole una foto, con otra caja en la que se incluyan los textos de la tarjeta de perfil.

**Foto:**

**Código:**
https://github.com/gromber05/practicaLayout2/blob/0027e279e7cace8fc7c202719c8e84ce04b80fb2/app/src/main/java/com/gromber05/practicalayout2/Ejercicios/Ejercicio01FichaProducto.kt#L23-L94

---

## Ejercicio 2 — Acciones principales en una barra

**Explicación:** En este ejercicio, lo que he hecho ha sido crear configuraciones, metiendole entre ellas un HorizontalDivider para crear la linea que divide entre cada elemento de la lista de configuraciones. He metido un row por cada elemento en la lista, para agregarle en el inicio de esta el texto, y luego en el final el botón/switch.

**Foto**:

**Código:**
https://github.com/gromber05/practicaLayout2/blob/0027e279e7cace8fc7c202719c8e84ce04b80fb2/app/src/main/java/com/gromber05/practicalayout2/Ejercicios/Ejercicio02AccionesPrincipales.kt#L19-L54

---

## Ejercicio 3 — Cambiando colores con estado

**Explicación:** Para crear la lista y mostrar los productos, lo que he hecho ha sido aplicarles un valor a las cadenas de texto que tengo en la lista, así, puedo usar el painterResource para pintar las imagenes guardadas en los valores de la lista.

**Foto:**


**Código:**
https://github.com/gromber05/practicaLayout2/blob/0027e279e7cace8fc7c202719c8e84ce04b80fb2/app/src/main/java/com/gromber05/practicalayout2/Ejercicios/Ejercicio03ColoresEstado.kt#L25-L62

---

## Ejercicio 4 — Contador doble

**Explicación:** En este código, lo que he usado han sido los espaciadores 'Spacer' que me permiten crear espacios dentro de mi contenido. Para pegar el botón al fondo, lo que he hecho ha sido aplicarle "peso" al espaciador.

**Foto:**


**Código:**
https://github.com/gromber05/practicaLayout2/blob/0027e279e7cace8fc7c202719c8e84ce04b80fb2/app/src/main/java/com/gromber05/practicalayout2/Ejercicios/Ejercicio04ContadorDoble.kt#L20-L39

---

## Ejercicio 5 — Interruptor de visibilidad

**Explicación:** Para este ejercicio, se han pedido varias cajas de distintos colores y tamaños en distintas configuraciones, lo que he hecho para poder colocar las cajas en distintos sitios es usar el weight, una propiedad del modifier que me permite mover las cajas a mi antojo y luego las he coloreado jugando con el fondo.

**Foto:**


**Código:**
https://github.com/gromber05/practicaLayout2/blob/0027e279e7cace8fc7c202719c8e84ce04b80fb2/app/src/main/java/com/gromber05/practicalayout2/Ejercicios/Ejercicio05Visibilidad.kt#L19-L36

---

## Ejercicio 6 — Tarjeta de evento interactiva

**Explicación:** Para crear este código, se requiere el uso de un `ConstraintLayout`. Se ha pedido la creación de una tarjeta de perfil, para ello, se ha empleado una Card, en la que dentro se ha implementado el ConstraintLayout, luego dentro, se han establecido las referencias de posición de los distintos elementos.

**Foto:**

**Código:**
https://github.com/gromber05/practicaLayout2/blob/0027e279e7cace8fc7c202719c8e84ce04b80fb2/app/src/main/java/com/gromber05/practicalayout2/Ejercicios/EjercicioExtra/Main.kt#L12-L25

https://github.com/gromber05/practicaLayout2/blob/0027e279e7cace8fc7c202719c8e84ce04b80fb2/app/src/main/java/com/gromber05/practicalayout2/Ejercicios/EjercicioExtra/components/EventCard.kt#L26-L208
