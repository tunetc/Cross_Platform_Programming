public  final class Parrot extends Bird {
    public Parrot(int age, String name, boolean sex, String eats, String color_break, String color_eggs, boolean fly){
        setAge(age);
        setName(name);
        setSex(sex);
        setEats(eats);
        setColor_beak(color_break);
        setColor_eggs(color_eggs);
        setFly(fly);
    }

    public void cout(){
        System.out.println(
                            "\nПапуга:"
                            +"\n Вік: " + getAge()
                            +"\n Ім'я: " + getName()
                            +"\n Стать: " + getSex()
                            +"\n Чим харчується: " + getEats()
                            +"\n Колір дзьоба: " + getColor_beak()
                            +"\n Колір яйця: " + getColor_eggs()
                            +"\n Чи літає: " + getFly());
    }
}