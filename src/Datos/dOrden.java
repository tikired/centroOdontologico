package Datos;

public class dOrden {
    private int idOrdenProducto;
    private int cantidad;
    private int idProducto;
    private int idOrdenPedido;
    
    public dOrden(){   
    }

    public dOrden(int idOrdenProducto, int cantidad, int idProducto, int idOrdenPedido) {
        this.idOrdenProducto = idOrdenProducto;
        this.cantidad = cantidad;
        this.idProducto = idProducto;
        this.idOrdenPedido = idOrdenPedido;
    }

    public int getIdOrdenProducto() {
        return idOrdenProducto;
    }

    public void setIdOrdenProducto(int idOrdenProducto) {
        this.idOrdenProducto = idOrdenProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdOrdenPedido() {
        return idOrdenPedido;
    }

    public void setIdOrdenPedido(int idOrdenPedido) {
        this.idOrdenPedido = idOrdenPedido;
    }
    
    
}
