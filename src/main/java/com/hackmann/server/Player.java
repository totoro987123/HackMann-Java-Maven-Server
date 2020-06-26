public class Player {

    private int score = 0;
    private String username = "";
    private Connection connection = null; //server id and socket

    public Player() {}

    public Player(String username, Connection connection) { //when a new player enters
        this.username = username;
        this.connection = connection;
    }

    public String setScore(int score) {
        this.score = score;
    }
    public String getUsername() {
        return this.username;
    }
    public int getScore() {
        return this.score;
    }
    public void disconnect() {
        //disconnect player, put I think Lawson already did this somewhere else
        connection.close();
    }

    public static void main(String[] args) {}
}
