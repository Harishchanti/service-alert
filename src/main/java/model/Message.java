package model;

import lombok.Data;

@Data
public class Message {
    String data;
    String type;
    Long retry;
}
