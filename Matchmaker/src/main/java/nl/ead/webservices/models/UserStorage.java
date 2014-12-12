package nl.ead.webservices.models;

public class UserStorage {
    User[] users = new User[3];

    public UserStorage() {
        User userOne = new User(1, "natnaelyntn", "1Qxkh9JrUR95yIg8E4COdB","Natnael", 27);
        User userTwo = new User(2, "11160520376", "7JRsQ9cHm18SV8i5CKGPav", "Willem", 23);
        User userThree = new User(3, "alexandersip", "4NY6wV9YFiNfozZZeqNMRO","Alex", 18);
        User userFour =  new User(4,"maikverheijen", "4cs3oqZvNBNSfSjJTuR0sj","Maik", 22);

        this.users[0] = userOne;
        this.users[1] = userTwo;
        this.users[2] = userThree;
        this.users[3] = userFour;
    }

    public User getUser(int userId) {
        return this.users[userId];
    }

    public User[] getUsers() {
        return this.users;
    }
}
