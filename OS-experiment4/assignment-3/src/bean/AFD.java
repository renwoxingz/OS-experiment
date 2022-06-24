package bean;

import java.util.ArrayList;
import java.util.List;

public class AFD {
    private List<File> list;

    public AFD() {
        list = new ArrayList<>();
    }

    public AFD(List<File> list) {
        this.list = list;
    }

    public List<File> getList() {
        return list;
    }

    public void setList(List<File> list) {
        this.list = list;
    }
}
