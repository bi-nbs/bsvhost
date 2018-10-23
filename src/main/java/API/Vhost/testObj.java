package API.Vhost;

import com.fasterxml.jackson.annotation.JsonProperty;

public class testObj {

    private String att1;
    private String att2;

    public testObj() {
    }

    public testObj(String att1, String att2) {
        this.att1 = att1;
        this.att2 = att2;
    }

    public String getAtt1() {
        return att1;
    }

    public String getAtt2() {
        return att2;
    }

    public void setAtt1(String att1) {
        this.att1 = att1;
    }

    public void setAtt2(String att2) {
        this.att2 = att2;
    }

    @Override
    public String toString() {
        return "testObj{" +
                "att1='" + att1 + '\'' +
                ", att2='" + att2 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        testObj testObj = (testObj) o;

        if (att1 != null ? !att1.equals(testObj.att1) : testObj.att1 != null) return false;
        return att2 != null ? att2.equals(testObj.att2) : testObj.att2 == null;
    }

    @Override
    public int hashCode() {
        int result = att1 != null ? att1.hashCode() : 0;
        result = 31 * result + (att2 != null ? att2.hashCode() : 0);
        return result;
    }
}
