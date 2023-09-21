public final class Lizard extends Replite {
    private boolean regeneration;
    public Lizard(int age, String name, boolean sex, String eats, String body_color, String color_eggs, String environment, boolean regeneration,boolean floats, boolean crawls){
        setAge(age);
        setName(name);
        setSex(sex);
        setEats(eats);
        setEnvironment(environment);
        setRegeneration(regeneration);
        setBody_color(body_color);
        setColor_eggs(color_eggs);
        setFloats(floats);
        setCrawls(crawls);
    }

    public String getRegeneration() {
        if(regeneration) {
            return "присутня";
        }
        else{
            return "немає";
        }
    }

    public void setRegeneration(boolean regeneration) {
        this.regeneration = regeneration;
    }

    public void cout(){
        System.out.println(
                        "\nПлазун:"
                        +"\n Вік: " + getAge()
                        +"\n Ім'я: " + getName()
                        +"\n Стать: " + getSex()
                        +"\n Чим харчується: " + getEats()
                        +"\n Колір тіла: " + getBody_color()
                        +"\n Колір яйця: " + getColor_eggs()
                        +"\n Навколишнє середовище: " + getEnvironment()
                        +"\n Можливість регенерації: " + getRegeneration()
                        +"\n Чи плаває: " + getFloats()
                        +"\n Чи повзає: " + getCrawls());
    }
}