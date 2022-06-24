import bean.Instruct;
import bean.InstructSet;
import bean.PageInfo;
import bean.PageTable;

import java.util.List;

public class App {
    public static void main(String[] args) {
        PageTable pageTable = new PageTable();
        List<PageInfo> list = pageTable.getList();
        InstructSet instructSet = new InstructSet();
        for (Instruct instruct : instructSet.getList()) {
            int flag = 0;
            int pageNumber = instruct.getPageNumber();
            int offset = instruct.getOffset();
            for (PageInfo pageInfo : list) {
                if (pageInfo.getFlag() == 1 && pageInfo.getPageNumber() == pageNumber) {
                    int address = 128 * pageInfo.getMemoryNumber() + offset;
                    System.out.println("查找成功，地址：" + address);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("缺页错误：*" + pageNumber);
            }
        }
    }
}
