package lab5.lab5baithem;


public class DanhMuc {
    private String maDM, tenDM; 
    private int isDelete; 

    public DanhMuc(String maDM, String tenDM, int isDelete) {
        this.maDM = maDM;
        this.tenDM = tenDM;
        this.isDelete = isDelete;
    }

    public DanhMuc() {
    }

    public String getMaDM() {
        return maDM;
    }

    public void setMaDM(String maDM) {
        this.maDM = maDM;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
