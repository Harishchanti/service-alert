package config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Configurations {

    Map<String, List<String>> subscribermap;
    Map<String, TimeDuration> alerttimeconfigmap;

}
