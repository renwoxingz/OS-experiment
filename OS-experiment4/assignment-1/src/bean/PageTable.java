package bean;

import java.util.ArrayList;
import java.util.List;

public class PageTable {
    private List<PageInfo> list;

    public List<PageInfo> getList() {
        return list;
    }

    public void setList(List<PageInfo> list) {
        this.list = list;
    }

    public PageTable() {
        this.list = new ArrayList<>();
        list.add(new PageInfo(0,1,5,0,11));
        list.add(new PageInfo(1,1,8,0,12));
        list.add(new PageInfo(2,1,9,0,13));
        list.add(new PageInfo(3,1,1,0,21));
        list.add(new PageInfo(4,0,0,0,22));
        list.add(new PageInfo(5,0,0,0,23));
        list.add(new PageInfo(6,0,0,0,121));
    }

    public PageTable(List<PageInfo> list) {
        this.list = list;
    }
}
