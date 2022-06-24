package bean;

public class PageInfo {
    private int pageNumber;
    private int flag;
    private int memoryNumber;
    private int dirty;
    private int diskNumber;

    public PageInfo() {
    }

    public PageInfo(int pageNumber, int flag, int memoryNumber, int dirty, int diskNumber) {
        this.pageNumber = pageNumber;
        this.flag = flag;
        this.memoryNumber = memoryNumber;
        this.dirty = dirty;
        this.diskNumber = diskNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getMemoryNumber() {
        return memoryNumber;
    }

    public void setMemoryNumber(int memoryNumber) {
        this.memoryNumber = memoryNumber;
    }

    public int getDirty() {
        return dirty;
    }

    public void setDirty(int dirty) {
        this.dirty = dirty;
    }

    public int getDiskNumber() {
        return diskNumber;
    }

    public void setDiskNumber(int diskNumber) {
        this.diskNumber = diskNumber;
    }
}
