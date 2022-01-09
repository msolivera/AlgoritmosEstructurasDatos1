
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Parcial {

    public static void main(String[] args) throws IOException {

        // instanciar curso BasicoIng...
        Conjunto<Alumno> BasicoIng = new Conjunto<>();

        File archivo;
        FileReader fr;
        BufferedReader br;
        String lineas;
        try {
            archivo = new File("src\\basico-ing.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            while ((lineas = br.readLine()) != null) {

                String[] contenido;

                //separa los datos deparados por ,
                contenido = lineas.split(",");

                int id = Integer.valueOf(contenido[0]);
                String nombre = contenido[1];

                Alumno alumno = new Alumno(id, nombre);
                Nodo<Alumno> nodo = new Nodo(alumno.getCodigo(), alumno);
                BasicoIng.insertar(nodo);

            }

            br.close();
            fr.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en la carga" + e);
        }

        // instanciar curso BasicoEmp...
        Conjunto<Alumno> BasicoEmp = new Conjunto<>();
        File archivo2;
        FileReader fr2;
        BufferedReader br2;
        String lineas2;
        try {
            archivo2 = new File("src\\basico-emp.txt");
            fr2 = new FileReader(archivo2);
            br2 = new BufferedReader(fr2);

            while ((lineas2 = br2.readLine()) != null) {

                String[] contenido;

                //separa los datos deparados por ,
                contenido = lineas2.split(",");

                int id = Integer.valueOf(contenido[0]);
                String nombre = contenido[1];

                Alumno alumno = new Alumno(id, nombre);
                Nodo<Alumno> nodo = new Nodo(alumno.getCodigo(), alumno);
                BasicoEmp.insertar(nodo);

            }

            br2.close();
            fr2.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en la carga" + e);
        }

        // generar el curso "integrador101" con los alumnos que están en condiciones de cursarlo  
        Conjunto integrador101 = new Conjunto();
        integrador101 = BasicoIng.union(BasicoEmp);
        System.out.println("Alumnos que cursaron una o ambas asignaturas: " + integrador101.cantElementos());
        // guardar en un archivo "integrador101.txt"  - IDEALMENTE ordenados por código de alumno -
        FileWriter fw;
        try {
            fw = new FileWriter("src\\integrador101.txt", true);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                Nodo<Alumno> nodo = integrador101.getPrimero();
                while (nodo != null) {

                    String linea = String.valueOf(nodo.getDato().getCodigo()).concat(",").concat(nodo.getDato().getNombre());
                    bw.write(linea);
                    bw.newLine();

                    nodo = nodo.getSiguiente();
                }
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo ");

        }

        // generar el curso "exigente102" con los alumnos que están en condiciones de cursarlo 
        Conjunto exigente102 = new Conjunto();
        exigente102 = BasicoEmp.interseccion(BasicoIng);
        System.out.println("Alumnos que cursaron ambas asignaturas: " + exigente102.cantElementos());

        // guardar en un archivo "exigente102.txt" - IDEALMENTE ordenados por código de alumno -
        FileWriter fw2;
        try {
            fw2 = new FileWriter("src\\exigente102.txt", true);
            try (BufferedWriter bw = new BufferedWriter(fw2)) {
                Nodo<Alumno> nodo = exigente102.getPrimero();
                while (nodo != null) {

                    String linea = String.valueOf(nodo.getDato().getCodigo()).concat(",").concat(nodo.getDato().getNombre());
                    bw.write(linea);
                    bw.newLine();

                    nodo = nodo.getSiguiente();
                }
            }
            fw2.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo ");

        }
    }

}
