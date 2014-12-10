package nl.ead.webservices.models;

public class UserStorage {
    User[] users = new User[2];

    public UserStorage() {
        User userOne = new User(1, "natnaelyntn", "1Qxkh9JrUR95yIg8E4COdB");
        User userTwo = new User(2, "11160520376", "7JRsQ9cHm18SV8i5CKGPav");

        this.users[0] = userOne;
        this.users[1] = userTwo;
    }

    public User getUser(int userId) {
        return this.users[userId];
    }

    public User[] getUsers() {return this.users;}
}
