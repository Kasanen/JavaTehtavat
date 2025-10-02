public class Pen {
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");

        private final String color;
        Color(String color) { this.color = color; };

        @Override
        public String toString() { return color; }
    }

    // your code here
    private Color color;
    private boolean capOn;

    public Pen(){
        this.color = Color.RED;
        this.capOn = true;
    }

    public Pen(Color color){
        this.color = color;
        this.capOn = true;
    }

    public void capOn(){
        this.capOn = true;
    }

    public void capOff(){
        this.capOn = false;
    }

    public void changeColor(Color newColor){
        if(this.capOn == true){
            this.color = newColor;
        }

    }

    public String draw(){
        if(this.capOn == true){
            return "";
        }
        else{
            return "Drawing " + color.toString();
        }
    }




}

