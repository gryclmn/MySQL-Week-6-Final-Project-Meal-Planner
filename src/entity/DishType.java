package entity;

public enum DishType {
    MAIN,
    SIDE;
    
    public static DishType get(String type) {
    	return DishType.valueOf(type.toUpperCase());
    }
}
