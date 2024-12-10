# Conversor de Monedas en Java 💱

## Descripción del Proyecto

Este es un proyecto de Conversor de Monedas desarrollado en Java que permite a los usuarios convertir entre diferentes divisas utilizando tasas de cambio en tiempo real mediante una API externa.

## Características ✨

- Conversión en tiempo real de divisas
- Soporte para múltiples monedas (USD, BRL, ARS, COP)
- Interfaz de usuario por consola
- Manejo de errores y excepciones
- Consumo de API de tasas de cambio

## Requisitos Previos 🛠️

- Java 11 o superior
- Conexión a Internet
- Biblioteca JSON (org.json o Gson)

## Dependencias 📦

### Maven
```xml
<dependencies>
    <dependency>
        <groupId>org.json</groupId>
        <artifactId>json</artifactId>
        <version>20230618</version>
    </dependency>
</dependencies>
```

### Gradle
```groovy
dependencies {
    implementation 'org.json:json:20230618'
}
```

## Funcionalidades 🔄

- Conversión de USD a BRL
- Conversión de BRL a USD
- Conversión de USD a ARS
- Conversión de ARS a USD
- Conversión de USD a COP
- Conversión de COP a USD

## Cómo Usar 🚀

1. Ejecuta el programa
2. Selecciona la opción de conversión deseada
3. Ingresa el monto a convertir
4. Observa el resultado de la conversión

## Ejemplo de Uso

```
--- Conversor de Monedas ---
1. Convertir USD a BRL
2. Convertir BRL a USD
3. Convertir USD a ARS
4. Convertir ARS a USD
5. Convertir USD a COP
6. Convertir COP a USD
7. Salir
Elija una opción: 1
Ingrese el valor a convertir: 100
100.00 USD = 495.50 BRL
```

## Consideraciones de Seguridad 🔒

- La clave de API utilizada es temporal
- En un entorno de producción, se recomienda proteger las credenciales

## Mejoras Futuras 🌟

- Añadir más monedas
- Implementar interfaz gráfica
- Guardar histórico de conversiones
- Manejo más robusto de errores de red