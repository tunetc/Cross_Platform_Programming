public class Mammal extends Animal implements IMammal {
    private boolean activity;
    private  String area;
    private boolean predation;
    private boolean flying;
    private boolean swimming;

    @Override
    public String getActivity() {
        if(activity) {
            return "день";
        }
        else{
            return "ніч";
        }
    }
    @Override
    public void setActivity(boolean activity) {
        this.activity = activity;
    }
    @Override
    public String getArea() {
        return area;
    }
    @Override
    public void setArea(String area) {
        this.area = area;
    }
    @Override
    public String getPredation() {
        if(predation) {
            return "хижак";
        }
        else{
            return "не хижак";
        }
    }
    @Override
    public void setPredation(boolean predation) {
        this.predation = predation;
    }
    @Override
    public String getFlying() {
        if(flying) {
            return "літає";
        }
        else{
            return "не літає";
        }
    }
    @Override
    public void setFlying(boolean flying) {
        this.flying = flying;
    }
    @Override
    public String getSwimming() {
        if(swimming) {
            return "плаває";
        }
        else{
            return "не плаває";
        }
    }
    @Override
    public void setSwimming(boolean swimming) {
        this.swimming = swimming;
    }
}