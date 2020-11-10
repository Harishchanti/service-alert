package service;

import model.Message;

import java.util.List;

public interface INofication {
    boolean notify(List<String> recipient, Message message);
}
