public final class Horse extends Mammal {
    private double speed;
    private double height;
    public Horse(int age, String name, boolean sex, boolean activity, String area, boolean predation, boolean flying, boolean swimming, double speed, double height){
        setAge(age);
        setName(name);
        setSex(sex);
        setActivity(activity);
        setArea(area);
        setPredation(predation);
        setSwimming(swimming);
        setFlying(flying);
        setSpeed(speed);
        setHeight(height);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public void cout(){
        System.out.println(
                        "\nКінь:"
                        +"\n Вік: " + getAge()
                        +"\n Ім'я: " + getName()
                        +"\n Стать: " + getSex()
                        +"\n Пора активності: " + getActivity()
                        +"\n Середовище проживання: " + getArea()
                        +"\n Чи хижак: " + getPredation()
                        +"\n Чи літає: " + getFlying()
                        +"\n Чи плаває: " + getSwimming()
                        +"\n Максимальна швидкість: " + getSpeed()
                        +"\n Висота: " + getHeight());
    }
}