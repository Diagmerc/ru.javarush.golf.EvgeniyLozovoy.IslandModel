package island;
import animals.*;
import animals.biota.Plant;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.List;

@Getter
@Setter
public class Island {
    private int width;
    private int height;
    private EntitiesCreator entitiesCreator = new EntitiesCreator();
    public static Location[][] locations;

    public Island() {
        try (FileReader fileReader = new FileReader("settings.json")) {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
            width = Math.toIntExact((Long) jsonObject.get("width"));
            height = Math.toIntExact((Long) jsonObject.get("width"));
        } catch (Exception e) {
            System.out.println("Default size 2 x 2");
            width = 2;
            height = 2;
        }
    }

    public void initialize() {
        locations = new Location[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                List<Plant> plants = entitiesCreator.plantCreate();
                List<Animal> animals = entitiesCreator.getAnimals();
                locations[x][y] = new Location(x, y, animals, plants);
            }
        }
    }

    public void printStatistic() {
        System.out.printf("************************************************************************* \n На острове животных: %d , растений %d \n", statisticAnimal(), statisticPlants());

    }

    public int statisticAnimal() {
        int count = 0;
        for (Location[] location : locations) {
            for (Location value : location) {
                count+=value.getAnimals().size();
            }
        }return count;
    }

    public int statisticPlants() {
        int count = 0;
        for (Location[] location : locations) {
            for (Location value : location) {
                count+=value.getPlants().size();
            }
        }return count;
    }
}


