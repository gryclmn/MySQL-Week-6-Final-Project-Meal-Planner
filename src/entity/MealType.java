package entity;

public enum MealType {
	BREAKFAST,
	LUNCH, 
	DINNER;
	
	public static MealType get(String type) {
    	return MealType.valueOf(type.toUpperCase());
    }
}