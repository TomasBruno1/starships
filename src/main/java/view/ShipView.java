package view;

import edu.austral.dissis.starships.file.ImageLoader;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import lombok.Data;
import lombok.SneakyThrows;

@Data
public class ShipView implements View{
    ImageView imageView;
    Group healthView;
    Rectangle healthFill = new Rectangle(100, 10);
    Text points = new Text();

    public ShipView(Image image, int x, int y) {
        this.imageView = new ImageView(image);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        healthFill.setFill(Color.RED);

        Rectangle rectangle = new Rectangle(100, 10);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.RED);
        rectangle.setStrokeWidth(2);

        healthView = new Group(rectangle, healthFill);
        healthView.setLayoutX(x);
        healthView.setLayoutY(y + 100);

        points.setLayoutX(x);
        points.setLayoutY(y);
        points.setFont(Font.font(20));
        points.setFill(Color.WHITE);
        points.setText("0");
    }

    public void updateHealth(Double health) {
        healthFill.setWidth(health/200 * 100);
    }

    public void updatePoints(int points) {
        this.points.setText(String.valueOf(points));
    }

    public double getWidth() {
        return imageView.getImage().getWidth();
    }

    public double getHeight() {
        return imageView.getImage().getHeight();
    }

    @SneakyThrows
    public void updateShipStyle(String name) {
        ImageLoader imageLoader = new ImageLoader();
        imageView.setImage(imageLoader.loadFromResources(name, 100, 100));
    }
}
