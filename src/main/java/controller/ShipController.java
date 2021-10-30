package controller;

import edu.austral.dissis.starships.vector.Vector2;
import javafx.scene.image.ImageView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import model.Ship;
import view.ShipView;

@AllArgsConstructor
@Getter
public class ShipController {
    private ShipView shipView;
    private Ship ship;

    public void forward(Double movement) {
        Vector2 movementVector = Vector2.vectorFromModule((float) movement.doubleValue(), (float) (Math.toRadians(shipView.getRotate()) - Math.PI/2));
        Vector2 from = Vector2.vector((float) shipView.getLayoutX(), (float) shipView.getLayoutY());
        Vector2 to = from.add(movementVector);
        shipView.move(to);
        ship.move(to);
        System.out.println(shipView.getLayoutX() + ";" + shipView.getLayoutY());
        System.out.println(ship.getShape().getLayoutX() + ";" + ship.getShape().getLayoutY());
    }

    public void backward(Double movement) {
        Vector2 movementVector = Vector2.vectorFromModule((float) -movement, (float) (Math.toRadians(shipView.getRotate()) - Math.PI/2));
        Vector2 from = Vector2.vector((float) shipView.getLayoutX(), (float) shipView.getLayoutY());
        Vector2 to = from.add(movementVector);
        shipView.move(to);
        ship.move(to);
    }

    public void rotateLeft(Double movement) {
        shipView.setRotate(shipView.getRotate() - movement);
    }

    public void rotateRight(Double movement) {
        shipView.setRotate(shipView.getRotate() + movement);
    }

    public ImageView updateDeath() {
        if(ship.getHealth() <= 0) return shipView.getImageView();
        else return null;
    }
}