public final class Bat extends Mammal {
    private int wings;
    private double frequency;
    public Bat(int age, String name, boolean sex, boolean activity, String area, boolean predation, boolean flying, boolean swimming, int wings, double frequency){
        setAge(age);
        setName(name);
        setSex(sex);
        setActivity(activity);
        setArea(area);
        setPredation(predation);
        setFlying(flying);
        setWings(wings);
        setSwimming(swimming);
        setFrequency(frequency);
    }

    public int getWings() {
        return wings;
    }

    public void setWings(int wings) {
        this.wings = wings;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
    public void cout(){
        System.out.println(
                        "\nКажан:"
                        +"\n Вік: " + getAge()
                        +"\n Ім'я: " + getName()
                        +"\n Стать: " + getSex()
                        +"\n Пора активності: " + getActivity()
                        +"\n Середовище проживання: " + getArea()
                        +"\n Чи хижак: " + getPredation()
                        +"\n Чи літає: " + getFlying()
                        +"\n Чи плаває: " + getSwimming()
                        +"\n Довжина крил: " + getWings()
                        +"\n Частота звуку: " + getFrequency());
    }
}