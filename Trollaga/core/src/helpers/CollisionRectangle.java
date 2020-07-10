package helpers;

public class CollisionRectangle {

    float x, y;
    int width, height;

    public CollisionRectangle(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move (float x, float y){
        this.x = x;
        this.y = y;
    }

    public boolean collidesWith(CollisionRectangle rectangle){
        return x < rectangle.x + rectangle.width && y < rectangle.y + rectangle.height && x + width > rectangle.x && y + height > rectangle.y;
    }
}
