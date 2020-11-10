package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogData implements Comparable<LogData> {
    Timestamp timestamp;
    String data;

    public int compareTo(LogData o) {
        return this.getTimestamp().compareTo(o.getTimestamp());
    }
}
