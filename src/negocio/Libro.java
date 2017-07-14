package negocio;

import acceso.Conexion;
import java.sql.ResultSet;

public class Libro {
    private String id_libro;
    private String numSerie;
    private String isbn;
    private String titulo;
    private String numPaginas;
    private String año;
    private String precio;
    private String idEditorial;
    private String idFactura;
    private String idEstado;
    Conexion con;
    
    public Libro(){
        con=new Conexion();
    }

    public void setId_libro(String id_libro) {
        this.id_libro = id_libro;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNumPaginas(String numPaginas) {
        this.numPaginas = numPaginas;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
    public void setAño(String año) {
        this.año = año;
    }

    public void setIdEditorial(String idEditorial) {
        this.idEditorial = idEditorial;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }
    //GET
    public String getId_libro() {
        return id_libro;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNumPaginas() {
        return numPaginas;
    }

    public String getPrecio() {
        return precio;
    }
    
    public String getAño() {
        return año;
    }

    public String getIdEditorial() {
        return idEditorial;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public String getIdEstado() {
        return idEstado;
    }
    //SQL
        public void guardar(){
        con.setExecuteUpdate("insert into libros (numero_serie,isbn,titulo,numero_paginas,precio,año_publicacion,id_editorial,id_factura,id_estado) values('"+this.getNumSerie()+"','"+this.getIsbn()+"','"+this.getTitulo()+"','"+this.getNumPaginas()+"','"+this.getPrecio()+"','"+this.getAño()+"','"+this.getIdEditorial()+"','"+this.getIdFactura()+"','"+this.getIdEstado()+"')");
    }
    public void eliminar(){
        con.setExecuteUpdate("delete from libros where id_libro='"+this.getId_libro()+"'");
    }
    public void actualizar(){
        con.setExecuteUpdate("update libros set numero_serie='"+this.getNumSerie()+"',isbn='"+this.getIsbn()+"',titulo='"+this.getTitulo()+"',numero_paginas='"+this.getNumPaginas()+"',precio='"+this.getPrecio()+"',año_publicacion='"+this.getAño()+"',id_editorial='"+this.getIdEditorial()+"',id_factura='"+this.getIdFactura()+"',id_estado='"+this.getIdEstado()+"' where id_libro='"+this.getId_libro()+"'");
    }
    public void show(){
        con.setExecuteQuery("select * from libros,editoriales,facturas,estados where libros.id_editorial=editoriales.id_editorial and libros.id_factura=facturas.id_factura and libros.id_estado=estados.id_estado");
    }
    public ResultSet getShow(){
        return con.getRs();
    }
    public void showLibro(){
        con.setExecuteQuery("select id_libro,titulo from libros");
    }
    public ResultSet getShowLibro(){
        return con.getRs();
    }
}
