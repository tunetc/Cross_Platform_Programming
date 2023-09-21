public class Bird extends Animal implements IBird {
    private boolean fly = false;
    private String eats ;
    private  String color_beak ;
    private  String color_eggs ;

    public String getFly() {
        if(fly) {
            return "літає";
        }
        else{
            return "не літає";
        }
    }

    public String getEats() {
        return eats;
    }

    public String getColor_beak() {
        return color_beak;
    }

    public String getColor_eggs() {
        return color_eggs;
    }

    public void setFly(boolean fly) {
        this.fly = fly;
    }

    public void setEats(String eats) {
        this.eats = eats;
    }

    public void setColor_beak(String color_beak) {
        this.color_beak = color_beak;
    }

    public void setColor_eggs(String color_eggs) {
        this.color_eggs = color_eggs;
    }
}