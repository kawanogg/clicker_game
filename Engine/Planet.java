package Engine;

public class Planet extends Entity {

    public Planet (int x, int y, int width, int height, double productionRate, double cost, int quantity) {
        super(
                "img/planet.png",
                x,
                y,
                width,
                height,
                "Planet",
                productionRate,
                cost,
                quantity
        );

        Resource.addEntity(this);
    }
}