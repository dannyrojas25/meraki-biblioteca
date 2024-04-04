package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Libro {
    private String titulo;
    private String autor;
    private int añoPublicacion;

    public Libro(String titulo, String autor, int añoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }
}

class Usuario {
    private String nombre;
    private int id;

    public Usuario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class Biblioteca {
    List<Libro> librosDisponibles;
    List<Libro> librosPrestados;

    public Biblioteca() {
        this.librosDisponibles = new ArrayList<>();
        this.librosPrestados = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        librosDisponibles.add(libro);
    }

    public void prestarLibro(Libro libro, Usuario usuario) {
        if (librosDisponibles.contains(libro)) {
            librosDisponibles.remove(libro);
            librosPrestados.add(libro);
            System.out.println("Libro prestado correctamente a " + usuario.getNombre());
        } else {
            System.out.println("El libro no está disponible para prestar.");
        }
    }

    public void devolverLibro(Libro libro) {
        if (librosPrestados.contains(libro)) {
            librosPrestados.remove(libro);
            librosDisponibles.add(libro);
            System.out.println("Libro devuelto correctamente.");
        } else {
            System.out.println("El libro no está en préstamo.");
        }
    }

    public void mostrarCatalogoCompleto() {
        System.out.println("Catálogo completo de la biblioteca:");
        for (Libro libro : librosDisponibles) {
            System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " - " + libro.getAñoPublicacion());
        }
    }

    public void mostrarLibrosPrestados() {
        System.out.println("Libros prestados actualmente:");
        for (Libro libro : librosPrestados) {
            System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " - " + libro.getAñoPublicacion());
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        boolean mostrarMenu = true;

        while (mostrarMenu) {
            if(mostrarMenu){
                System.out.println("\n1. Agregar libro");
                System.out.println("2. Prestar libro");
                System.out.println("3. Devolver libro");
                System.out.println("4. Mostrar catálogo completo");
                System.out.println("5. Mostrar libros prestados");
                System.out.println("6. Salir");
                System.out.print("Ingrese el número de la operación que desea realizar: ");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el título del libro: ");
                        scanner.nextLine();
                        String titulo = scanner.nextLine();
                        System.out.print("Ingrese el autor del libro: ");
                        String autor = scanner.nextLine();
                        System.out.print("Ingrese el año de publicación del libro: ");
                        int añoPublicacion = scanner.nextInt();
                        biblioteca.agregarLibro(new Libro(titulo, autor, añoPublicacion));
                        System.out.println("Libro agregado al catálogo.");
                        break;
                    case 2:
                        System.out.print("Ingrese el título del libro a prestar: ");
                        scanner.nextLine();
                        String tituloPrestamo = scanner.nextLine();
                        // Supongamos que el usuario ya está registrado previamente
                        Usuario usuario = new Usuario("Danny", 1);
                        for (Libro libro : biblioteca.librosDisponibles) {
                            if (libro.getTitulo().equals(tituloPrestamo)) {
                                biblioteca.prestarLibro(libro, usuario);
                                break;
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese el título del libro a devolver: ");
                        scanner.nextLine();
                        String tituloDevolucion = scanner.nextLine();
                        for (Libro libro : biblioteca.librosPrestados) {
                            if (libro.getTitulo().equals(tituloDevolucion)) {
                                biblioteca.devolverLibro(libro);
                                break;
                            }
                        }
                        break;
                    case 4:
                        biblioteca.mostrarCatalogoCompleto();
                        break;
                    case 5:
                        biblioteca.mostrarLibrosPrestados();
                        break;
                    case 6:
                        System.out.println("Saliendo del programa...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, ingrese un número válido.");
                }
            }
        }
    }
}