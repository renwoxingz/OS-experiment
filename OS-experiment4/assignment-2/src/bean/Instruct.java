package bean;

public class Instruct {
    private char opt;
    private int pageNumber;
    private int offset;

    public Instruct() {
    }

    public Instruct(char opt, int pageNumber, int offset) {
        this.opt = opt;
        this.pageNumber = pageNumber;
        this.offset = offset;
    }

    public char getOpt() {
        return opt;
    }

    public void setOpt(char opt) {
        this.opt = opt;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
