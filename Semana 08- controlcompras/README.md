# Semana 08 - Control de Compras

Aplicación en Java que permite registrar y analizar las compras realizadas en un hogar
durante una semana, utilizando programación orientada a objetos y colecciones.

## Descripción

El programa permite:
- Registrar productos (nombre, categoría, precio unitario y cantidad).
- Validar los datos antes de guardarlos (nombre y categoría no vacíos, precio y cantidad mayores que cero).
- Calcular el subtotal de cada producto.
- Mostrar un resumen con el total general, el total gastado por categoría,
  el producto de mayor y menor gasto, y la categoría con mayor gasto.
- Consultar el total gastado en una categoría específica.

## Colecciones utilizadas

| Colección              | Responsabilidad                                         |
|-------------------------|----------------------------------------------------------|
| `ArrayList<Producto>`   | Almacena todos los productos registrados, en orden.       |
| `HashSet<String>`       | Almacena las categorías registradas, sin duplicados.       |
| `HashMap<String,Double>`| Acumula el total gastado por cada categoría.               |

## Estructura del proyecto

```
semana-08-control-compras/
├── src/
│   ├── Producto.java
│   └── MainControlCompras.java
├── evidencias/
│   └── Evidencias_Control_Compras_NombreApellido.docx
├── README.md
└── .gitignore
```

## Cómo compilar y ejecutar

Desde la carpeta `src`:

```bash
javac *.java
java MainControlCompras
```

## Autor

Nombre Apellido - Curso de Programación
