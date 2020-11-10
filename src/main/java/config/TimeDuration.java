package config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeDuration {
    /*
    Frequency,duration,wait-time
     */
    int frequency;
    int duration;
    int waitTime;
}
