package bean;

import java.util.ArrayList;
import java.util.List;

public class MDF {
    private List<UFD> list;

    public MDF() {
        list = new ArrayList<>();
        list.add(new UFD("1"));
        list.add(new UFD("2"));
        list.add(new UFD("3"));
        list.add(new UFD("4"));
        list.add(new UFD("5"));
        list.add(new UFD("6"));
        list.add(new UFD("7"));
        list.add(new UFD("8"));
        list.add(new UFD("9"));
        list.add(new UFD("10"));
    }

    public MDF(List<UFD> list) {
        this.list = list;
    }

    public List<UFD> getList() {
        return list;
    }

    public void setList(List<UFD> list) {
        this.list = list;
    }
}
