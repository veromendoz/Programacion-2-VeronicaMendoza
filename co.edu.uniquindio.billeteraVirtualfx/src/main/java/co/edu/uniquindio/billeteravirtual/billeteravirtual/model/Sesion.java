package co.edu.uniquindio.billeteravirtual.billeteravirtual.model;


public class Sesion {
        public static Sesion INSTANCIA;

        private Usuario usuario;

        private Sesion(){

        }
        public static Sesion getInstance(){
            if(INSTANCIA == null){
                INSTANCIA = new Sesion();
            }
            return INSTANCIA;
        }

        public void cerrearSesion(){
            usuario = null;
        }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
