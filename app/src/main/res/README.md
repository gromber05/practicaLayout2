Perfecto ✅ Aquí tienes el contenido de tu PDF **“Actividad 1 - Tema 1 | Gonzalo Romero Bernal 2DAM”** convertido en un formato **README.md** profesional y bien estructurado para subirlo a GitHub:

---

````markdown
# Actividad 1 - Tema 1  
**Autor:** Gonzalo Romero Bernal  
**Curso:** 2º DAM  

---

## 📘 Creación de Interfaces en Kotlin

Este proyecto tiene como objetivo afianzar los conceptos aprendidos de **Jetpack Compose** mediante la creación de una interfaz sencilla en **Kotlin**, utilizando funciones `@Composable`, previsualizaciones con `@Preview` y modificadores para personalizar la apariencia y disposición de los elementos.

---

## 🧩 1. Objetivo de la práctica

El propósito de la práctica es practicar la creación de interfaces con **Jetpack Compose**, aplicando conceptos de:
- Modularidad con funciones `@Composable`.
- Previsualizaciones mediante `@Preview`.
- Uso de modificadores (`Modifier`) para ajustar tamaño, color, márgenes y comportamiento.

---

## 🚀 2. Creación del proyecto

Se creó un nuevo proyecto en **Android Studio** con las siguientes características:
- Tipo de plantilla: **Empty Activity**.  
- Nombre del proyecto: `act2`.  
- Lenguaje: **Kotlin**.  
- Versión mínima de Android: **API 21 (Android 5.0)**.

---

## 🧱 3. Primer composable

Se definió una función `@Composable` llamada **Saludar**, que recibe un parámetro `texto` para hacerla reutilizable.

```kotlin
@Composable
fun Saludar(texto: String) {
    Text(text = texto)
}
````

Esta función se llama desde el método `setContent`, estableciendo el tema principal de la aplicación.

---

## 🧪 4. Vista preview

Para visualizar los composables sin ejecutar la app, se emplean las anotaciones `@Preview`:

```kotlin
@Preview(
    name = "Saludo pequeño",
    showBackground = true
)
@Composable
fun PreviewSaludoPequenio() {
    MaterialTheme {
        Saludar("Hola!")
    }
}

@Preview(
    name = "Saludo grande",
    showBackground = true,
    widthDp = 300,
    heightDp = 100
)
@Composable
fun PreviewSaludoGrande() {
    MaterialTheme {
        Surface {
            Saludar("Hola!")
        }
    }
}
```

---

## 🎨 5. Uso de modificadores

Se añadieron modificadores para controlar tamaño, color, padding y comportamiento:

```kotlin
@Composable
fun EjemploTamanioYMargen() {
    Box(
        modifier = Modifier
            .size(150.dp)
            .padding(20.dp)
            .background(Color(0xFFBBDEFB))
    )
}

@Composable
fun EjemploClic() {
    var contador by remember { mutableStateOf(0) }

    Text(
        text = "Has hecho clic $contador veces",
        modifier = Modifier
            .padding(16.dp)
            .background(Color(0xFFFFF59D))
            .clickable { contador++ }
            .padding(8.dp)
    )
}
```

---

## 🗂️ 6. Estructura del código

Las funciones `Composable` con modificadores se movieron a un archivo separado dentro del paquete `modifiers`.
Esto mejora la **organización**, **mantenibilidad** y **legibilidad** del código.

---

## 🌗 7. Previsualización avanzada

Se probaron distintas configuraciones de `@Preview`, incluyendo temas oscuros y grupos de visualización.

```kotlin
@Preview(
    name = "Oscuro",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    group = "Tema"
)
@Composable
fun PreviewOscuro() {
    Act2Theme(darkTheme = true) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            Saludar("Hola!")
        }
    }
}
```

---

## 💭 8. Reflexión final

**Jetpack Compose** simplifica enormemente la creación de interfaces respecto a XML.
Sus ventajas principales son:

* Modularidad mediante funciones `Composable`.
* Reutilización y separación clara de vistas y lógica.
* Modificadores para control detallado de diseño y estilo.
* `@Preview` agiliza el desarrollo sin necesidad de compilar constantemente.
* Separar las vistas en distintos archivos facilita la escalabilidad del proyecto.

---

## 📂 Estructura del proyecto

```
app/
 ├── java/
 │   └── com.example.act2/
 │        ├── MainActivity.kt
 │        ├── Saludar.kt
 │        └── modifiers/
 │             ├── EjemploTamanioYMargen.kt
 │             └── EjemploClic.kt
 └── res/
     └── values/
         └── themes.xml
```

---

## 🛠️ Tecnologías utilizadas

* **Kotlin**
* **Android Studio**
* **Jetpack Compose**
* **Material 3**

---

## ✨ Autor

**Gonzalo Romero Bernal**
*2º DAM – Desarrollo de Aplicaciones Multiplataforma*

```

---

¿Quieres que lo adapte con estilo Markdown más visual (con emojis y secciones de color tipo portfolio) o lo dejo en este formato académico estándar?
```
