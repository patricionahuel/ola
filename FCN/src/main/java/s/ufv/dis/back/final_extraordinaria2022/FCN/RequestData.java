package s.ufv.dis.back.final_extraordinaria2022.FCN;

import java.util.ArrayList;

public class RequestData {
    protected String entity;
    protected int id;
    protected Object data; // Puede ser un objeto People o Starship

    public RequestData(String entity, int id, Object data) {
        this.entity = entity;
        this.id = id;
        this.data = data;
    }

    // Getters y setters
    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    // Método toString
    @Override
    public String toString() {
        return "RequestData{" +
                "entity='" + entity + '\'' +
                ", id=" + id +
                ", data=" + data +
                '}';
    }
}

