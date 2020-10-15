package ioc.spring.dependecyLookUp;

@Supper
public class SupperStudent extends Student {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SupperStudent{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
