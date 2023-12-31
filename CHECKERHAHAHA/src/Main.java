// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate; //libraries `import`ed
import java.util.stream.Collectors;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.stream.*;


class Main {
    static List<Empleado>empleados;
    public static void main(String[] args) throws IOException {
        cargarArchivo();
        mostrarEmpleadosGananMas();
        //mostrarEmpleadosPorDept();
        cantEmpleadosPorDept();
        cantEstudiantesPorCarHombre();
        cantEstudiantesPorCarMujer();
        //SumSalariosTotal();
        EmpleadoGanaMasPorDept();
        EmpleadoGanaMas();
        EmpleadoGanaMenos();
        promSalaryDepa();
        //promSalaryTotal();
        //SumSalarios();
    }
    static void cargarArchivo() throws IOException{ //comparor con C++ later :)
        Pattern pattern = Pattern.compile(",");
        String filename= "C:\\Users\\Santiago\\IdeaProjects\\CHECKERHAHAHA\\src\\student-scores.csv";

        try(Stream<String> lines = Files.lines(Path.of(filename))){
            empleados=lines.skip(1).map(line->{
                String[]arr=pattern.split(line);
                return new Empleado(arr[1],arr[2],Integer.parseInt(arr[10]),arr[9],arr[3],arr[4],Boolean.parseBoolean(arr[5]),Integer.parseInt(arr[6]),Boolean.parseBoolean(arr[7]),Integer.parseInt(arr[8]),Integer.parseInt(arr[11]),Integer.parseInt(arr[12]),Integer.parseInt(arr[13]),Integer.parseInt(arr[14]),Integer.parseInt(arr[15]), Integer.parseInt(arr[16]));
            }).collect(Collectors.toList());
            empleados.forEach(System.out::println);
        }
    }
    static Predicate<Empleado> cuatroASeisMil =
            e -> (e.getmath_grade() >= 0 && e.getmath_grade() <= 100);

    static void mostrarEmpleadosGananMas(){
        System.out.printf(
                "%nEmpleados que ganan $4000-$7000 mensuales ordenados por salario:%n"); //EDIT LATER FRGMENT CODE
        empleados.stream()
                .filter(cuatroASeisMil)
                .sorted(Comparator.comparing(Empleado::getmath_grade))
                .forEach(System.out::println);
    }
    //static void mostrarEmpleadosPorDept(){
        //System.out.printf("%nEmpleados por departamento:%n");
        //Map<String, List<Empleado>> agrupadoPorDepartamento =
               // empleados.stream()
                       // .collect(Collectors.groupingBy(Empleado::getDepartamento));
        //agrupadoPorDepartamento.forEach(
                //(departamento, empleadosEnDepartamento) ->
                {
                    //System.out.println(departamento);
                   // empleadosEnDepartamento.forEach(
                           // empleado -> System.out.printf(" %s%n", empleado));
                }
       // );
    //}
    static void cantEmpleadosPorDept(){
        // cuenta el número de empleados en cada departamento (editted for counting student career)
        System.out.printf("%nConteo de empleados por departamento:%n");
        Map<String, Long> conteoEmpleadosPorDepartamento =
                empleados.stream()
                        .collect(Collectors.groupingBy(Empleado::getDepartamento,
                                TreeMap::new, Collectors.counting()));
        conteoEmpleadosPorDepartamento.forEach(
                (departamento, conteo) -> System.out.printf(
                        "%s tiene %d aspirante(s)%n", departamento, conteo));
    }
    static void cantEstudiantesPorCarHombre(){ //copypastehombre
        // cuenta el número de empleados en cada departamento (editted for counting student career)
        System.out.printf("%nConteo de empleados por departamento:%n");
        Map<String, Long> conteoEmpleadosPorDepartamento =
                empleados.stream().filter(empleado ->empleado.getGenero().equals("male"))
                        .collect(Collectors.groupingBy(Empleado::getCarrera,
                                TreeMap::new, Collectors.counting()));
        conteoEmpleadosPorDepartamento.forEach(
                (departamento, conteo) -> System.out.printf(
                        "%s tiene %d aspirante(s) Hombre %n", departamento, conteo));
    }
    static void cantEstudiantesPorCarMujer(){ //copypastemujer
        // cuenta el número de empleados en cada departamento (editted for counting student career)
        System.out.printf("%nConteo de empleados por departamento:%n");
        Map<String, Long> conteoEmpleadosPorDepartamento =
                empleados.stream().filter(empleado ->empleado.getGenero().equals("female"))
                        .collect(Collectors.groupingBy(Empleado::getCarrera,
                                TreeMap::new, Collectors.counting()));
        conteoEmpleadosPorDepartamento.forEach(
                (departamento, conteo) -> System.out.printf(
                        "%s tiene %d aspirante(s) Mujer %n", departamento, conteo));
    }

    //static void SumSalariosTotal(){   //Estudiante mejor nota
        //Map<String, List<Empleado>> agrupadoPorDepartamento =
                //empleados.stream()
                       // .collect(Collectors.groupingBy(Empleado::getDepartamento));
        //System.out.printf(
                //"%nNomina de cada departamento  %n");
        //agrupadoPorDepartamento.forEach(
                //(departamento, empleadosEnDepartamento) ->
               // {
                   // System.out.print(departamento+": ");
                   // System.out.println(empleadosEnDepartamento.
                            //stream().
                           // mapToDouble(Empleado::getSalario)
                            //.sum());
               // });
   // }
    static void EmpleadoGanaMasPorDept(){ //
        Function<Empleado, Integer> porSalario = Empleado::getmath_grade;
        Comparator<Empleado> SalarioDescendete =
                Comparator.comparing(porSalario);
        System.out.printf("%nEmpleados por departamento: %n");
        Map<String, List<Empleado>> agrupadoPorDepartamento =
                empleados.stream()
                        .collect(Collectors.groupingBy(Empleado::getCarrera));
        agrupadoPorDepartamento.forEach(
                (departamento, empleadosEnDepartamento) ->
                {
                    System.out.print(departamento+": ");
                    Empleado empleadoMas=empleadosEnDepartamento.stream().sorted(SalarioDescendete.reversed())
                            .findFirst()
                            .get();
                    System.out.println(empleadoMas.getPrimerNombre()+" "+empleadoMas.getApellidoPaterno()+
                            " ///Nota: "+empleadoMas.getmath_grade());
                }
        );
    }
    static void EmpleadoGanaMas(){
        Function<Empleado, Integer> porSalario = Empleado::getmath_grade;
        Comparator<Empleado> SalarioDescendete =
                Comparator.comparing(porSalario);
        Empleado empleadoMas=empleados.stream()
                .sorted(SalarioDescendete.reversed())
                .findFirst()
                .get();
        System.out.printf(
                "%nEmpleado que gana mas: %s %s %s %s%s%n",
                empleadoMas
                        .getPrimerNombre(),
                empleadoMas
                        .getApellidoPaterno()," ///Cuanto money? ==> money: ",
                empleadoMas
                        .getmath_grade()," $$$");
    }
    static void EmpleadoGanaMenos(){
        Function<Empleado, Integer> porSalario = Empleado::getmath_grade;
        Comparator<Empleado> SalarioDescendete =
                Comparator.comparing(porSalario);
        Empleado empleadoMenos=empleados.stream()
                .sorted(SalarioDescendete)
                .findFirst()
                .get();
        System.out.printf(
                "%nEmpleado que gana menos: %s %s %s %s%s%n",
                empleadoMenos.getPrimerNombre(),empleadoMenos.getApellidoPaterno()," ///Cuanto money? ==> money: ",
                empleadoMenos.getmath_grade(),"$$$");
    }
    static void promSalaryDepa(){
        Map<String, List<Empleado>> agrupadoPorDepartamento =
                empleados.stream()
                        .collect(Collectors.groupingBy(Empleado::getCarrera));
        System.out.println("\nPromedio de notas de los estudiantes por Carrera:");
        agrupadoPorDepartamento.forEach((departamento, empleadosporDepa)-> {
        System.out.print(departamento+": ");
            System.out.println(empleadosporDepa
                    .stream()
                    .mapToInt(Empleado::getmath_grade)
                    .average()
                    .toString());
        });


    //}
    //static void promSalaryTotal(){
    //    System.out.printf("\nPromedio de salarios de todos los depas: %.2f%n",
    //            empleados.stream()
    //                    .mapToDouble(Empleado::getmath_grade)
    //                    .average()
    //                    .getAsDouble());

    //}
    ///static void SumSalarios(){
    ///    System.out.printf(
   ///             "%nSuma de todos los salarios: %.2f%n",
    ///            empleados.stream()
    ///                    .mapToDouble(Empleado::getSalario)
    ///                    .sum());
    }


}
