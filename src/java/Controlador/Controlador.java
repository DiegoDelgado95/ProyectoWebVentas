/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexiones.dbCliente;
import Conexiones.dbProducto;
import Conexiones.dbVenta;
import Modelo.Cliente;
import Modelo.Producto;
import Modelo.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego
 */
public class Controlador extends HttpServlet {

   Cliente client = new Cliente();
   dbCliente dbclient = new dbCliente();
   
   Producto prod = new Producto();
   dbProducto dbProd = new dbProducto();
   
   List<Venta> lista = new ArrayList<>();
   int item;
   int totalPagar;
   
   String NumSerie;
   
   Venta vent = new Venta();
   dbVenta dbVent = new dbVenta();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String menu = request.getParameter("menu");
            String accion = request.getParameter("accion");
            
            if(menu.equals("Principal")){
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }
            
            if(menu.equals("Producto")){
                switch(accion){
                    case "listar":
                        List<Producto>listap = new ArrayList<>();
                        listap = dbProd.Listar();
                        
                        request.setAttribute("listaProducto", listap);
                        break;
                    case "nuevoProducto":
                        prod = new Producto();
                        
                        String nombre = request.getParameter("nombre");
                        String codigo = request.getParameter("codigo");
                        int precio = Integer.parseInt(request.getParameter("precio"));
                        int stock = Integer.parseInt(request.getParameter("stock"));
                        
                        prod.setNombre(nombre);
                        prod.setCodigo(codigo);
                        prod.setPrecio(precio);
                        prod.setStock(stock);
                        
                        dbProd.insertar(prod);
                        
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=listar").forward(request, response);
                        break;
                        
                    case "editar":
                        int id = Integer.parseInt(request.getParameter("id"));
                        prod = dbProd.listarID(id);
                        
                        request.setAttribute("editProducto", prod);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=listar").forward(request, response);
                        break;
                    
                    case "eliminar":
                        int idp = Integer.parseInt(request.getParameter("id"));
                        dbProd.eliminar(idp);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=listar").forward(request, response);
                        break;
  
                    default:
                        request.getRequestDispatcher("Producto.jsp").forward(request, response);
                }
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
            }
            
            if(menu.equals("Cliente")){
                switch(accion){
                    case "listarCliente":
                        List<Cliente>lista = new ArrayList<>();
                        lista = dbclient.listar();
                        request.setAttribute("listaCliente", lista);
                        break;
                        
                    case "nuevoCliente":
                        client = new Cliente();
                        
                        client.setNombre(request.getParameter("nombre"));
                        client.setDni(Integer.parseInt(request.getParameter("dni")));
                        client.setDireccion(request.getParameter("ciudad"));
                        
                        dbclient.insert(client);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=listarCliente").forward(request, response);
                        break;
                        
                    case "editar":
                        int id = Integer.parseInt(request.getParameter("id"));
                        
                        client = new Cliente();
                        client = dbclient.buscarID(id);
                        
                        request.setAttribute("cliente", client);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=listarCliente").forward(request, response);
                        break;
                        
                    case "eliminar":
                        int id1 = Integer.parseInt(request.getParameter("id"));
                        dbclient.eliminar(id1);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=listarCliente").forward(request, response);
                        break;
                        
                    case "buscarCliente":
                        int dni = Integer.parseInt(request.getParameter("dni"));
                        
                        break;
                    default:
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=listarCliente").forward(request, response);
                }
                request.getRequestDispatcher("Cliente.jsp").forward(request, response);
            }
            
            if(menu.equals("NuevaVenta")){
               switch(accion){
                    case "BuscarCliente":
                        int dni = Integer.parseInt(request.getParameter("codigoCliente"));
                       // client.setDni(dni);
                        client = dbclient.buscar(dni);
                        
                        request.setAttribute("nserie",NumSerie);
                        request.setAttribute("c", client);
                        break;
                        
                    case "BuscarProducto":
                        int id = Integer.parseInt(request.getParameter("codigoProducto"));
                        prod = dbProd.listarID(id);
                        
                        request.setAttribute("nserie",NumSerie);
                        request.setAttribute("c", client);
                        request.setAttribute("p", prod);
                        request.setAttribute("lista", lista);
                        request.setAttribute("totalPagar",totalPagar);
                        
                        break;
                        
                    case "Agregar":
                        totalPagar=0;
                        item = item + 1;
                        int cod = prod.getIdProducto();
                        String descripcion = request.getParameter("nombreproducto");
                        int precio = Integer.parseInt(request.getParameter("precio"));
                        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                        int subTotal = precio * cantidad;
                        
                        Venta v = new Venta();
                        v.setItem(item);
                        v.setIdProducto(cod);
                        v.setDescripcion(descripcion);
                        v.setPrecio(precio);
                        v.setCantidad(cantidad);
                        v.setSubTotal(subTotal);
                        lista.add(v);
                        
                        for (int i = 0; i < lista.size(); i++ ){
                            totalPagar = totalPagar + lista.get(i).getSubTotal();
                        }
                        
                        request.setAttribute("nserie",NumSerie);
                        request.setAttribute("c", client);
                        request.setAttribute("totalPagar",totalPagar);
                        request.setAttribute("lista", lista);
                        
                        break;
                    case "GenerarVenta":
                        //Actualizar stock
                        for (int i=0; i<lista.size(); i++){
                            Producto p = new Producto();
                            dbProd = new dbProducto();
                            
                            int cant = lista.get(i).getCantidad();
                            int idp = lista.get(i).getIdProducto();
                            
                            p = dbProd.listarID(idp);
                            int stock = p.getStock() - cant;
                            dbProd.actualizarStock(idp, stock);

                        }
                        
                        
                        //Guardo datos de la Venta
                        vent.setIdCliente(client.getIdCliente());
                        vent.setFechaVenta("27-04-2019");
                        vent.setMonto(totalPagar);
                        vent.setEstado("Disponible");
                        vent.setNumero(Integer.parseInt(NumSerie));
                        dbVent.insertVenta(vent);
                        
                        //Guardo los datos del detalle
                        int idv = dbVent.IDVenta();
                        for(int i=0;i<lista.size();i++){
                            v = new Venta();
                            v.setIdVenta(idv);
                            v.setIdProducto(lista.get(i).getIdProducto());
                            v.setCantidad(lista.get(i).getCantidad());
                            v.setSubTotal(lista.get(i).getSubTotal());
                            dbVent.InsertarDetalleVenta(v);
                        }
                        
                        break;
                    default: 
                        NumSerie = dbVent.GenerarSerie();
                        if( NumSerie == null){
                            NumSerie="0000000"+"1";
                        }
                        else{
                            int incrementar = Integer.parseInt(NumSerie);
                            GenerarSerie gs = new GenerarSerie();
                            NumSerie = gs.NumeroSerie(incrementar);
                            request.setAttribute("nserie",NumSerie);
                        }
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                }
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
