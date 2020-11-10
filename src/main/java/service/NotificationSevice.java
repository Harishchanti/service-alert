package service;

import model.Message;

import java.util.List;

public class NotificationSevice implements INofication{

    public boolean notify(List<String> recipient, Message message) {
        return false;
    }
}
