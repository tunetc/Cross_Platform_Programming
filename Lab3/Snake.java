public final class  Snake extends Replite {
    private double mouth_size;
    public Snake(int age, String name, boolean sex, String eats, String body_color, String color_eggs, double mouth_size, String environment,boolean floats, boolean crawls){
        setAge(age);
        setName(name);
        setSex(sex);
        setEats(eats);
        setEnvironment(environment);
        setBody_color(body_color);
        setColor_eggs(color_eggs);
        setMouth_size(mouth_size);
        setFloats(floats);
        setCrawls(crawls);
    }

    public double getMouth_size() {
        return mouth_size;
    }

    public void setMouth_size(double mouth_size) {
        this.mouth_size = mouth_size;
    }

    public void cout(){
        System.out.println(
                        "\nЗмія:"
                        +"\n Вік: " + getAge()
                        +"\n Ім'я: " + getName()
                        +"\n Стать: " + getSex()
                        +"\n Чим харчується: " + getEats()
                        +"\n Колір тіла: " + getBody_color()
                        +"\n Колір яйця: " + getColor_eggs()
                        +"\n Розмір пащі: " + getMouth_size()
                        +"\n Навколишнє середовище: " + getEnvironment()
                        +"\n Чи плаває: " + getFloats()
                        +"\n Чи повзає: " + getCrawls());
    }
}