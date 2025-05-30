public class OneDice implements Dice {

    @Override
    public int rollDice() {
        int random = (int) (Math.random() * (6 - 1 + 1)) + 1;
        return random;
    }
}
