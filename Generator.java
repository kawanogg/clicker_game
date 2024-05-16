public class Generator {
    private Entity entity;
    private double productionRate;
    private double cost;
    private int quantity;

    public Generator(Entity entity, double productionRate, double cost, int quantity) {
        this.entity = entity;
        this.productionRate = productionRate;
        this.cost = cost;
        this.quantity = quantity;
    }

    public Entity getEntity() {
        return entity;
    }
    public double getProductionRate() {
        return productionRate;
    }
    public double getCost() {
        return cost;
    }
    public int getQuantity() {
        return quantity;
    }

    public int buy(int quantity) {
        return this.quantity + quantity;
    }
}
