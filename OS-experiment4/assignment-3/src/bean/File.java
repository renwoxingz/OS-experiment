package bean;

public class File {
    private String fileName;
    private String protectionCode;
    private int size;
    private int cursor;

    public File() {
    }

    public File(String fileName, String protectionCode, int size, int cursor) {
        this.fileName = fileName;
        this.protectionCode = protectionCode;
        this.size = size;
        this.cursor = cursor;
    }

    public int getCursor() {
        return cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getProtectionCode() {
        return protectionCode;
    }

    public void setProtectionCode(String protectionCode) {
        this.protectionCode = protectionCode;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
