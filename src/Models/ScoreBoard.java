package Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Data
@Getter
@Setter
public class ScoreBoard {

    private Map<String, Integer> playerToScoreMap;
}
