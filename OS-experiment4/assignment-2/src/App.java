import bean.Instruct;
import bean.InstructSet;
import bean.PageInfo;
import bean.PageTable;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        PageTable pageTable = new PageTable();
        List<PageInfo> list = pageTable.getList();
        InstructSet instructSet = new InstructSet();
        List<Integer> LRUList = new ArrayList<>();
        LRUList.add(0);
        LRUList.add(1);
        LRUList.add(2);
        LRUList.add(3);
        List<Integer> freeMemory = new ArrayList<>();
        int cnt = 0;
        for (Instruct instruct : instructSet.getList()) {
            cnt++;
            System.out.println("正在执行第" + cnt + "条指令");
            boolean flag = false;
            char opt = instruct.getOpt();
            int pageNumber = instruct.getPageNumber();
            int offset = instruct.getOffset();

            PageInfo pageInfo = list.get(pageNumber);
            if (pageInfo.getFlag() != 1)  {
                if (LRUList.size() < 4) {
                    pageInfo.setFlag(1);
                    pageInfo.setMemoryNumber(freeMemory.get(0));
                    freeMemory.remove(0);
                } else {
                    Integer j = LRUList.remove(0);
                    System.out.println("调出页面" + j);
                    System.out.println("调入页面" + pageNumber);
                    LRUList.add(pageNumber);
                    PageInfo removePage = list.get(j);
                    if (removePage.getDirty() == 1) {
                        System.out.println("将页面" + j + "的修改写入硬盘");
                        removePage.setDirty(0);
                    }
                    removePage.setFlag(0);
                    int free = removePage.getMemoryNumber();
                    freeMemory.add(free);
                    removePage.setMemoryNumber(0);
                    pageInfo.setFlag(1);
                    pageInfo.setMemoryNumber(free);
                }
            } else {
                LRUList.remove((Integer) pageNumber);
                LRUList.add(pageNumber);
            }
            int address = 128 * pageInfo.getMemoryNumber() + offset;
            if (opt == '存') {
                pageInfo.setDirty(1);
            }
            System.out.println("查找成功，页号："+ pageNumber + " 地址：" + address);
        }
    }
}
