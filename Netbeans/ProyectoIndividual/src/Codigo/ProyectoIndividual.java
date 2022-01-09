package Codigo;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Micaela Olivera
 */
public class ProyectoIndividual {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*mensaje inicial para la carga de datos,
        carga de los datos en el sistema*/
        System.out.println("Cargando informacion, aguarde un momento......\n");
        Libreria libreria = new Libreria();
        libreria.cargarAutores("src/DataBase/authors.csv");
        libreria.cargarLibros("src/DataBase/books.csv");
        libreria.cargarTags("src/DataBase/tags.csv");
        /*se crea Scanner para poder leer entradas de teclado del usuario*/
        Scanner sc = new Scanner(System.in);
        /*Menu de inicio con sus opciones correspondientes*/
        while (true) {
            System.out.println("Bienvenido a la libreria de UCU BOOKS \nEscriba el numero de la opcion deseada y luego presione ENTER:");
            System.out.println("1 ________ Buscar un Libro por Fecha y Nombre");
            System.out.println("2 _________Mostrar todas las Ediciones a partir de cierta fecha");
            System.out.println("3 _________Buscar un Libro por ISBN/ISBN13");
            System.out.println("4 _________Mostrar los Libros de un Autor");
            System.out.println("5 _________Mostrar los Libros de determinado Genero");
            System.out.println("6 _________Eliminar un Autor y sus Libros asociados");
            System.out.println("7 _________Buscar un Autor en el sistema");
            System.out.println("8 _________Buscar un Libro en el sistema");
            System.out.println("9 _________Mostrar lInformacion detallada de un Libro");
            System.out.println("10_________Mostrar todos los Libros del sistema");
            System.out.println("11_________Mostrar todos los Autores del sistema");
            System.out.println("12_________Mostrar todos los Generos del sistema");
            System.out.println("13_________Resumen general de datos cargados en el sistema");
            System.out.println("14_________Salir del sistema\n\n");

            int opcionSeleccionada = sc.nextInt();

            opciones(opcionSeleccionada, libreria);
            System.out.println("\n");
        }
    }
    /**
     * Metodo que recibe la opcion ingresada por el usuario mediante el Scanner
     * y posteriormente realiza la ejecucion del metodo o metodos asociados a la opcion
     * deseada.
     * @param opcion int ingresado por el usuario
     * @param libreria Objeto libreria creada al iniciar el programa, se crea por defecto.
     */
    public static void opciones(int opcion, Libreria libreria) {
        Scanner nuevoSc = new Scanner(System.in);
        switch (opcion) {
            case 1:
                System.out.println("Ingrese el año de un libro");
                int anio = nuevoSc.nextInt();
                Scanner scanTitulo = new Scanner(System.in);
                System.out.println("Ingrese el titulo de un libro");
                String titulo = scanTitulo.nextLine();
                System.out.println("Realizando Busqueda de " + titulo + " año " + anio + ".......\n");
                libreria.buscarFechaNombre(anio, titulo);
                break;
            case 2:
                System.out.println("Ingrese un año para comenzar la busqueda");
                int fecha = nuevoSc.nextInt();
                libreria.mostrarPorFecha(fecha);
                break;
            case 3:
                System.out.println("Ingrese el numero de ISBN/ISBN13 de un libro");
                String isbn = nuevoSc.nextLine();
                libreria.mostrarPorIsbn(isbn);
                break;
            case 4:
                System.out.println("Ingrese el nombre de un Autor para comenzar la busqueda");
                String autor = nuevoSc.nextLine();
                libreria.mostrarPorAutor(autor);
                break;
            case 5:
                System.out.println("Ingrese un Genero para comenzar la busqueda");
                String genero = nuevoSc.nextLine();
                libreria.mostrarPorGenero(genero);
                break;
            case 6:
                System.out.println("Ingrese el nombre de un Autor para eliminarlo del sistema, junto con sus libros asociados");
                String autorEliminar = nuevoSc.nextLine();
                libreria.eliminarLibroAutor(autorEliminar);
                break;
            case 7:
                System.out.println("Ingrese el nombre de un Autor para comenzar la busqueda");
                String autorBuscar = nuevoSc.nextLine();
                libreria.buscarAutor(autorBuscar);
                break;
            case 8:
                System.out.println("Ingrese el titulo de un Libro para comenzar la busqueda");
                String tituloLibro = nuevoSc.nextLine();
                libreria.buscarLibro(tituloLibro);
                break;
            case 9:
                System.out.println("Ingrese el titulo de un Libro para ver su informacion detallada");
                String libroDetallado = nuevoSc.nextLine();
                libreria.mostrarAutoresDeLibro(libroDetallado);
                libreria.mostrarGenerosDeLibro(libroDetallado);
                break;
            case 10:
                System.out.println("Mostrando todos los Libros del sistema.....................");
                libreria.verLibros();
                break;
            case 11:
                System.out.println("Mostrando todos los Autores del sistema.....................");
                libreria.verAutores();
                break;
            case 12:
                System.out.println("Mostrando todos los Generos del sistema.....................");
                libreria.verTags();
                break;
            case 13:
                System.out.println("Total de Libros cargados en el sistema: " + libreria.obtenerLibros().cantElementos());
                System.out.println("Total de Autores cargados en el sistema: " + libreria.obtenerAutores().cantElementos());
                System.out.println("Total de Generos cargados en el sistema: " + libreria.obtenerTags().cantElementos());
                break;
            case 14:
                System.exit(0);
                break;

        }

    }
}
