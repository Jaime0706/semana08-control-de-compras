import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;


public class MainControlCompras {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Producto> productos = new ArrayList<>();

        HashSet<String> categorias = new HashSet<>();

        HashMap<String, Double> totalPorCategoria = new HashMap<>();

        System.out.print("¿Cuántos productos desea registrar? (mínimo 5): ");
        int cantidadProductos = sc.nextInt();
        sc.nextLine(); // limpiar el buffer del Scanner

        for (int i = 1; i <= cantidadProductos; i++) {
            System.out.println("\n--- Producto " + i + " ---");

            System.out.print("Nombre del producto: ");
            String nombre = sc.nextLine();

            System.out.print("Categoría: ");
            String categoria = sc.nextLine();

            System.out.print("Precio unitario: ");
            double precioUnitario = sc.nextDouble();

            System.out.print("Cantidad: ");
            int cantidad = sc.nextInt();
            sc.nextLine(); // limpiar el buffer otra vez

            if (nombre.trim().isEmpty()) {
                System.out.println("Producto no registrado: el nombre no puede estar vacío.");
                continue;
            }
            if (categoria.trim().isEmpty()) {
                System.out.println("Producto no registrado: la categoría no puede estar vacía.");
                continue;
            }
            if (precioUnitario <= 0) {
                System.out.println("Producto no registrado: el precio debe ser mayor que cero.");
                continue;
            }
            if (cantidad <= 0) {
                System.out.println("Producto no registrado: la cantidad debe ser mayor que cero.");
                continue;
            }

            Producto p = new Producto(nombre, categoria, precioUnitario, cantidad);
            productos.add(p);
            categorias.add(categoria);

            double subtotal = p.calcularSubtotal();

            if (totalPorCategoria.containsKey(categoria)) {
                double totalActual = totalPorCategoria.get(categoria);
                totalPorCategoria.put(categoria, totalActual + subtotal);
            } else {
                totalPorCategoria.put(categoria, subtotal);
            }

            System.out.println("Producto registrado correctamente.");
        }

        System.out.println("\n===== RESUMEN DE COMPRAS =====\n");

        double totalGeneral = 0;
        Producto productoMayorGasto = null;
        Producto productoMenorGasto = null;

        for (Producto p : productos) {
            double subtotal = p.calcularSubtotal();

            System.out.println(p.getNombre() + " | " + p.getCategoria() + " | Q"
                    + String.format("%.2f", p.getPrecioUnitario()) + " x " + p.getCantidad()
                    + " | Subtotal: Q" + String.format("%.2f", subtotal));

            totalGeneral += subtotal;

            if (productoMayorGasto == null || subtotal > productoMayorGasto.calcularSubtotal()) {
                productoMayorGasto = p;
            }
            if (productoMenorGasto == null || subtotal < productoMenorGasto.calcularSubtotal()) {
                productoMenorGasto = p;
            }
        }

        System.out.println("\nCategorías registradas:");
        System.out.println(categorias);

        System.out.println("\nTotal por categoría:");
        for (String cat : categorias) {
            System.out.println(cat + ": Q" + String.format("%.2f", totalPorCategoria.get(cat)));
        }

        System.out.println("\nProductos registrados: " + productos.size());
        System.out.println("\nTotal general: Q" + String.format("%.2f", totalGeneral));

        if (productoMayorGasto != null) {
            System.out.println("\nProducto con mayor gasto:");
            System.out.println(productoMayorGasto.getNombre() + " - Q"
                    + String.format("%.2f", productoMayorGasto.calcularSubtotal()));
        }

        if (productoMenorGasto != null) {
            System.out.println("\nProducto con menor gasto:");
            System.out.println(productoMenorGasto.getNombre() + " - Q"
                    + String.format("%.2f", productoMenorGasto.calcularSubtotal()));
        }

        String categoriaMayorGasto = null;
        double montoMayorCategoria = 0;

        for (String cat : totalPorCategoria.keySet()) {
            double monto = totalPorCategoria.get(cat);
            if (categoriaMayorGasto == null || monto > montoMayorCategoria) {
                categoriaMayorGasto = cat;
                montoMayorCategoria = monto;
            }
        }

        System.out.println("\nCategoría con mayor gasto:");
        System.out.println(categoriaMayorGasto + " - Q" + String.format("%.2f", montoMayorCategoria));

        System.out.print("\nIngrese una categoría para consultar: ");
        String categoriaConsultada = sc.nextLine();

        if (totalPorCategoria.containsKey(categoriaConsultada)) {
            System.out.println("Total gastado en " + categoriaConsultada + ": Q"
                    + String.format("%.2f", totalPorCategoria.get(categoriaConsultada)));
        } else {
            System.out.println("La categoría ingresada no se encuentra registrada.");
        }

        sc.close();
    }
}