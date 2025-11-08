package com.is1.proyecto.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

@Table("Professors")
public class Professor extends Model {

    public String getName() { return getString("name"); }
    public void setName(String name) { set("name", name); }

    public String getApellido() { return getString("apellido"); }
    public void setApellido(String apellido) { set("apellido", apellido); }

    public String getPassword() { return getString("password"); }
    public void setPaswword(String password) { set("password", password); }

    public String getCorreo() { return getString("correo"); }
    public void setCorreo(String correo) { set("correo", correo); }

    public String getDni() { return getString("dni"); }
    public void setDni(String dni) { set("dni", dni); }
}
