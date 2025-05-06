package service;

import model.Friend;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FriendService {
    private String filePath;

    public FriendService(String username) {
        this.filePath = "FriendList_" + username + ".txt";
    }

    public void addFriend(Friend friend) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(friend.toString());
            writer.newLine();
        }
    }

    public List<String> getAllFriends() throws IOException {
        List<String> list = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return list;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        }
        return list;
    }

    public boolean deleteFriend(String name) throws IOException {
        File inputFile = new File(filePath);
        File tempFile = new File("temp.txt");
        boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.startsWith(name + ",")) {
                    found = true;
                } else {
                    writer.write(currentLine);
                    writer.newLine();
                }
            }
        }
        if (found) {
            inputFile.delete();
            tempFile.renameTo(inputFile);
        } else {
            tempFile.delete();
        }
        return found;
    }

    public boolean updateFriend(String name, Friend updatedFriend) throws IOException {
        boolean deleted = deleteFriend(name);
        if (deleted) {
            addFriend(updatedFriend);
        }
        return deleted;
    }
}