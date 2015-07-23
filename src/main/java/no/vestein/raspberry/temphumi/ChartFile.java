package no.vestein.raspberry.temphumi;

import java.io.FileOutputStream;

public class ChartFile {

    private final String name;

    public ChartFile(String name) {
        this.name = name;
    }

    public boolean updateFile(String s) {
        try {
            FileOutputStream stream = new FileOutputStream(name);
            stream.write(s.getBytes());
            stream.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
