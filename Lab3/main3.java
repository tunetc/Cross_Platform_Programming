class main_class {
    public static void main(String[] args) {
        Parrot parrot = new Parrot(1, "Мбед", true, "просо", "червоний", "жовте, з чорними цятками", true);
        parrot.cout();

        Lizard lizard = new Lizard(10, "Шейк", false, "комахи", "мультикам", "біло-жовте", "земля",true,false, true);
        lizard.cout();

        Snake snake = new Snake(4, "Блейн", true, "комахи/птахи/рачки", "чорний", "біло-жовте", 12.5,"земля/вода",true, true);
        snake.cout();

        Bat bat = new Bat(2, "Чікар", true, false, "тропічні ліси", false, true,false,16, 44000.3);
        bat.cout();

        Horse horse = new Horse(14, "Найма", false, true, "степ", false, false,true,52.5, 2.3);
        horse.cout();
    }
}