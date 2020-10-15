package ioc.spring.dependecyLookUp;

public class Student {

    private Long id;

    private String namel;

    public Student() {
        System.out.println("初始化。。。。。。。。。。。。。。。。。。");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamel() {
        return namel;
    }

    public void setNamel(String namel) {
        this.namel = namel;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", namel='" + namel + '\'' +
                '}';
    }
}
