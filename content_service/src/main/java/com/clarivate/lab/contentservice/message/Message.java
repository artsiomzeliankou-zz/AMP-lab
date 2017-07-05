package com.clarivate.lab.contentservice.message;

import java.util.Random;

public class Message {

    private long id;

    private BundleInfo bundle;

    private String status;

    public Message(){
        setRandomId();
    }

    private void setRandomId(){
        int idBound = 100000;
        this.setId(new Random().nextInt(idBound) + 1);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BundleInfo getBundle() {
        return bundle;
    }

    public void setBundle(BundleInfo bundle) {
        this.bundle = bundle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", bundle=" + bundle +
                ", status='" + status + '\'' +
                '}';
    }
}
