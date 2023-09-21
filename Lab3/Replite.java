public class Replite extends Animal implements IReplite {

    private boolean floats = false;
    private boolean crawls = false;
    private String environment ;
    private  String eats ;
    private  String body_color ;
    private  String color_eggs ;

    @Override
    public String getFloats() {
        if(floats) {
            return "плаває";
        }
        else{
            return "не плаває";
        }
    }
    @Override
    public String getCrawls() {
        if(crawls) {
            return "повзає";
        }
        else{
            return "не повзає";
        }
    }
    @Override
    public String getEnvironment() {
        return environment;
    }
    @Override
    public String getEats() {
        return eats;
    }

    @Override
    public String getBody_color() {
        return body_color;
    }

    @Override
    public String getColor_eggs() {
        return color_eggs;
    }

    @Override
    public void setFloats(boolean floats) {
        this.floats  = floats;
    }

    @Override
    public void setCrawls(boolean crawls) {
        this.crawls  = crawls;
    }

    @Override
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public void setEats(String eats) {
        this.eats = eats;
    }

    @Override
    public void setBody_color(String body_color) {
        this.body_color = body_color;
    }

    @Override
    public void setColor_eggs(String color_eggs) {
        this.color_eggs = color_eggs;
    }

}