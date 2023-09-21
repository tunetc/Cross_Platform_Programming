public class Animal {
    private int age;
    private  String name;
    private boolean  sex;

    public String getSex() {
        if(sex) {
            return "чоловіча";
        }
        else{
            return "жіноча";
        }
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}