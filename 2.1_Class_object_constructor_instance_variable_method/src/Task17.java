
public class Task17 {
    // Kuinka valita kahvin
    
    static class CoffeeMaker {
        private int amount;
        private String type;
        private boolean isOn;
        
        public CoffeeMaker() {
            this.amount = 50;
            this.type = "espresso";
            this.isOn = false;
        }

        public void setChannel(int channel) {
            if (isOn && channel >= 1) {
                this.channel = channel;
            }
        }

        public int getChannel() {
            return this.channel;
        }

        public void pressOnOff() {
            this.isOn = !this.isOn;
        }

        public boolean isOn() {
            return this.isOn;
        }
    }

    public static void main(String[] args) throws Exception {
        Television myTV = new Television();
        myTV.setChannel(1);

        for (int day = 1; day <= 10; day++) {
            System.out.println("Woke up, day " + day);

            boolean tired = false;

            if (!myTV.isOn()) {
                myTV.pressOnOff();
            }

            while (!tired) {
                System.out.println("Watching channel " + myTV.getChannel());
                myTV.setChannel(myTV.getChannel() + 1);
                
                if (myTV.getChannel() > 10){
                    myTV.setChannel(1);
                }
                
                if (myTV.getChannel() % 4 == 0) {
                    tired = true;
                }
            }

            myTV.pressOnOff();
            System.out.println("Falling asleep");
        }
    }
}
