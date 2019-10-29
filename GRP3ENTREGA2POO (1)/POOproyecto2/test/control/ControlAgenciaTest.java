package control;

//AUTOGENERADOS
import control.ControlAgencia;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import model.Cliente;
import model.Reserva;
import model.ServicioAdicional;
import model.Tour;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
//IMPORTS MANUALES
import model.Cliente;
import model.Concierto;
import model.Ecologico;
import model.Empresarial;
import model.Reserva;
import model.ServicioAdicional;
import model.TipoEmpresa;
import model.TipoTransporte;
import model.Tour;
import model.Transporte;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDateTime;


public class ControlAgenciaTest {
    
    //RELACIONES
    
    private ControlAgencia control = new ControlAgencia();
    
    public ControlAgenciaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ParseException {
        
        //CREACION DE TOURS
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            Date fechaSalida1 = sdf.parse("2019-01-01");
            Date fechaLlegada1 = sdf.parse("2019-01-05");
            Date fechaSalida2 = sdf.parse("2019-01-06");
            Date fechaLlegada2 = sdf.parse("2019-01-15");
            Date fechaSalida3 = sdf.parse("2019-02-01");
            Date fechaLlegada3 = sdf.parse("2019-02-05");
            Date fechaSalida4 = sdf.parse("2019-03-01");
            Date fechaLlegada4 = sdf.parse("2019-03-05");
            Date fechaSalida5 = sdf.parse("2019-04-01");
            Date fechaLlegada5 = sdf.parse("2019-04-05");
            Date fechaSalida6 = sdf.parse("2019-05-01");
            Date fechaLlegada6 = sdf.parse("2019-05-11");
            
            Tour tour1 = new Tour(1001, "Paraiso Travel", "Medellin", "5:00", 100.0, fechaSalida1, fechaLlegada1);
            Tour tour2 = new Tour(1002, "Adventure Time", "Bogota", "22:00", 300.0, fechaSalida2, fechaLlegada2);
            Ecologico tourEco1 = new Ecologico(true ,20.0 ,true ,2001, "Trip verde", "Ibague", "5:00", 400.0, fechaSalida3, fechaLlegada3);
            Ecologico tourEco2 = new Ecologico(true, 20.0, false,2002, "Fumaratto", "Honda", "0:00", 100.0, fechaSalida4, fechaLlegada4);
            Empresarial tourEmp1 = new Empresarial("Tiobe", true, TipoEmpresa.TECNOLOGIA, 3001, "Wall Street Paisa", "Cartagena", "23:00", 500.0, fechaSalida5, fechaLlegada5);
            Empresarial tourEmp2 = new Empresarial("Aviatur", true, TipoEmpresa.TURISMO, 3002, "Cancun Full", "Bogota", "23:00", 1000.0, fechaSalida6, fechaLlegada6);
            
            //CREACION DE CLIENTES
            
            Cliente cliente1 = new Cliente(10001, "Armando Bronca", "3165317");
            Cliente cliente2 = new Cliente(20002, "Elver Galarga", "3165318");
            Cliente cliente3 = new Cliente(30003, "Jacko Miste", "3165319");
            Cliente cliente4 = new Cliente(40004, "Aide Mora", "3165301");
            Cliente cliente5 = new Cliente(50005, "Elsa Badillo", "3165302");
            Cliente cliente6 = new Cliente(60006, "Juan C. Mata", "3165303");
            
            //CREACION DE SERVICIOS ADICIONALES
            
            Concierto serv1 = new Concierto("Weird Al", "Royal Center", "7pm", 3333, "Concierto Loko", 100.0);
            Concierto serv2 = new Concierto("Vicentico", "Dowtown Majestic", "1pm", 4444, "Concierto Folclor", 100.0);
            Transporte serv3 = new Transporte(5.0, TipoTransporte.TAXI, 4, 5555, "Taxi los Canarios", 25.0);
            Transporte serv4 = new Transporte(3.0, TipoTransporte.MINIVAN, 7, 6666, "(ans)^1/2", 35.0);
            
            //CREACION DE RESERVAS
            
            int dia, mes, anio;
            
            ArrayList<ServicioAdicional> servicios = new ArrayList<>();
            servicios.add(serv1);
            servicios.add(serv2);
            servicios.add(serv3);
            servicios.add(serv4);

            ArrayList<ServicioAdicional> sinServicios = new ArrayList<>();
            
            
            dia = 10; mes = 12; anio = 2018;
            LocalDateTime fecha = LocalDateTime.of(anio, mes, dia, 8, 0);
           
            Reserva reserva1 = new Reserva(sinServicios, 900, fecha, true, 5, cliente1, tour1);
            Reserva reserva2 = new Reserva(servicios, 901, fecha, true, 5, cliente2, tourEco1);
            Reserva reserva3 = new Reserva(sinServicios, 902, fecha, true, 10, cliente3, tourEmp1);
            Reserva reserva4 = new Reserva(sinServicios, 903, fecha, false, 10, cliente4, tourEmp1);
            Reserva reserva5 = new Reserva(sinServicios, 904, fecha, false, 10, cliente5, tourEmp2);
            Reserva reserva6 = new Reserva(sinServicios, 905, fecha, false, 10, cliente6, tourEco2);
            
            //SE CREAN LAS COLECCIONES
            
            HashMap <Integer, Tour> tours = new HashMap<>();
            HashMap <Integer, Cliente> clientes = new HashMap<>();
            ArrayList<Reserva> reservas = new ArrayList<>();
            
            //SE LLENAN LAS COLECCIONES
            
            tours.put(1001, tour1);
            tours.put(1002, tour2);
            tours.put(2001, tourEco1);
            tours.put(2002, tourEco2);
            tours.put(3001, tourEmp1);
            tours.put(3002, tourEmp2);
            
            clientes.put(10001, cliente1);
            clientes.put(20002, cliente2);
            clientes.put(30003, cliente3);
            clientes.put(40004, cliente4);
            clientes.put(50005, cliente5);
            clientes.put(60006, cliente6);
            
            reservas.add(reserva1);
            reservas.add(reserva2);
            reservas.add(reserva3);
            reservas.add(reserva4);
            reservas.add(reserva5);
            reservas.add(reserva6);
            
            //SE COMPLETA EL CONTROLADOR
            
            control.setListaTours(tours);
            control.setListaClientes(clientes); 
            control.setReservas(reservas);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAgregarReserva() throws Exception
    {
        control.agregarReserva(906, LocalDateTime.of(2018, 12, 10, 8, 0), true , 25, control.getListaTours().get(1001), control.getListaClientes().get(10001));
        
        assertEquals(25, control.getReservas().get(control.getReservas().size()-1).getCantidadPersonas());
        System.out.println("agregarReserva OK"); 
        
        /*PRUEBA NO EXITOSA:
        if(25 != control.getReservas().get(control.getReservas().size()-1).getCantidadPersonas())
        {
            fail("ERROR: EL VALOR ESPERADO NO COINCIDE CON EL RESULTADO");
        }
        */ 
    }

    @Test
    public void testCostoReservaSinAdicionales() throws Exception 
    { 
        double resultado;
        
        resultado = control.costoReservaSinAdicionales(901);
        
        assertEquals(2420, resultado, 1e-8);
        System.out.println("costoReservaSinAdicionales OK");
        
        /*PRUEBA NO EXITOSA:
        if(2420 != resultado)
        {
            fail("ERROR: EL VALOR ESPERADO NO COINCIDE CON EL RESULTADO");
        }
        */    
    }

    @Test
    public void testCostoReservaConAdicionales() throws Exception 
    {
         double resultado;
        
        resultado = control.costoReservaConAdicionales(901);
        
        assertEquals(2970, resultado, 1e-8);
        System.out.println("costoReservaConAdicionales OK");
        
        /*PRUEBA NO EXITOSA:
        if(2970 != resultado)
        {
            fail("ERROR: EL VALOR ESPERADO NO COINCIDE CON EL RESULTADO");
        }
        */ 
    }

    @Test
    public void testAgregarServicioAdicional() throws Exception 
    {
        Concierto elConcierto = new Concierto("KISS", "El campin", "4pm", 1951, "BogRock", 50.0);
        
        control.agregarServicioAdicional(900, elConcierto);
        
        assertTrue(control.getReserva(900).getServiciosAdicionales().size() == 1); //ANTES 0
        System.out.println("agregarServicioAdicional OK");
        
        /*PRUEBA NO EXITOSA:
        if(control.getReserva(900).getServiciosAdicionales().size() != 1)
        {
            fail("ERROR: EL TAMANIO DEBERIA SER DE 1 AL AGREGAR UN SERVICIO ADICIONAL A ESA RESERVA");
        }
        */  
    }

    @Test
    public void testCostoServiciosAdicionales() throws Exception 
    {
        double resultado;
        
        resultado = control.costoServiciosAdicionales(901);
        
        assertEquals(550, resultado, 1e-8);
        System.out.println("costoServiciosAdicionales OK");
        
        /*PRUEBA NO EXITOSA:
        if(550 != resultado)
        {
            fail("ERROR: EL VALOR ESPERADO NO COINCIDE CON EL RESULTADO");
        }
        */ 
    }

    @Test
    public void testEliminarServicioAdicional_long_Reserva() throws Exception 
    {
        
        control.eliminarServicioAdicional(3333, control.getReserva(901));
        control.eliminarServicioAdicional(4444, control.getReserva(901));
        
        assertTrue(control.getReserva(901).getServiciosAdicionales().size() == 2); //ANTES 4
        System.out.println("eliminarServicioAdicional OK");
        
        /*PRUEBA NO EXITOSA:
        if(control.getReserva(901).getServiciosAdicionales().size() != 2)
        {
            fail("ERROR:EL TAMANIO DEBERIA SER DE 2 AL ELIMINAR DOS SERVICIOS ADICIONALES DE ESA RESERVA");
        }
        */ 
    }

    @Test
    public void testRetornarEcologicos() throws Exception 
    {
        HashMap <Integer, Tour> miMapa = new HashMap<>();
        
        miMapa = control.retornarEcologicos();
        
        assertFalse(miMapa.size() != 2); //SOLO PARA USAR OTRO ASSERT DISTINTO, EQUIVALENTE A assertTrue(miMapa.size() == 2)
        System.out.println("retornarEcologicos OK");
        
        /*PRUEBA NO EXITOSA:
        if(miMapa.size() != 2)
        {
            fail("ERROR:EL TAMANIO DEBERIA SER DE 2");
        }
        */ 
    }

    @Test
    public void testFiltrarAsociadasEmpresarial() throws Exception 
    {
        ArrayList<Reserva> asociadas = new ArrayList<>();
        
        asociadas = control.filtrarAsociadasEmpresarial();
        
        assertTrue(asociadas.size() == 3); //HAY 3 RESERVAS ASOCIADAS A TOURS EMPRESARIALES
        System.out.println("filtrarAsociadasEmpresarial OK"); 
        
        /*PRUEBA NO EXITOSA:
        if(asociadas.size() != 3)
        {
            fail("ERROR:EL TAMANIO DEBERIA SER DE 3");
        }
        */ 
    }

    @Test
    public void testPrecioReservasToursEcologicosPorFecha() throws Exception 
    {
        double resultado;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date inicial = sdf.parse("2019-01-05"); Date fFinal = sdf.parse("2019-04-05");
        
        resultado = control.precioReservasToursEcologicosPorFecha(inicial, fFinal);
        
        assertEquals(3390, resultado, 1e-8);
        System.out.println("precioReservasToursEcologicosPorFecha OK");
        
        /*PRUEBA NO EXITOSA:
        if(3390 != resultado)
        {
            fail("ERROR: EL VALOR ESPERADO NO COINCIDE CON EL RESULTADO");
        }
        */ 
    }
    
}

