package bean;

import java.util.ArrayList;
import java.util.List;

public class InstructSet {
    private List<Instruct> list = new ArrayList<>();

    public InstructSet() {
        list.add(new Instruct('+', 0, 70));
        list.add(new Instruct('+', 1, 50));
        list.add(new Instruct('*', 2, 15));
        list.add(new Instruct('存', 3, 21));
        list.add(new Instruct('取', 0, 56));
        list.add(new Instruct('-', 6, 40));
        list.add(new Instruct('移', 4, 53));
        list.add(new Instruct('+', 5, 23));
        list.add(new Instruct('存', 1, 37));
        list.add(new Instruct('取', 2, 78));
        list.add(new Instruct('+', 4, 1));
        list.add(new Instruct('存', 6, 84));
    }

    public List<Instruct> getList() {
        return list;
    }

    public void setList(List<Instruct> list) {
        this.list = list;
    }
}
